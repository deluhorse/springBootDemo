package com.delu.springboot.autochess.tools;

import org.lionsoul.jcseg.extractor.KeyphraseExtractor;
import org.lionsoul.jcseg.extractor.KeywordsExtractor;
import org.lionsoul.jcseg.extractor.SummaryExtractor;
import org.lionsoul.jcseg.extractor.impl.TextRankKeyphraseExtractor;
import org.lionsoul.jcseg.extractor.impl.TextRankKeywordsExtractor;
import org.lionsoul.jcseg.extractor.impl.TextRankSummaryExtractor;
import org.lionsoul.jcseg.sentence.SentenceSeg;
import org.lionsoul.jcseg.tokenizer.NLPSeg;
import org.lionsoul.jcseg.tokenizer.core.*;
import org.lionsoul.jcseg.util.ArrayUtil;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Created by delu on 2019-04-02.
 */
public class JcsegUtils {

    JcsegTaskConfig tokenizerConfig = null;
    ADictionary dic = null;

    ISegment tokenizerSeg = null;
    ISegment extractorSeg = null;

    KeywordsExtractor keywordsExtractor = null;
    KeyphraseExtractor keyphraseExtractor = null;
    SummaryExtractor summaryExtractor = null;

    List<String> ignoreKeyList = Arrays.asList("CSDN", "博客", "教程", "博客园", "CSDN博客", "程序",
            "Google 搜索", "Github");

    public JcsegUtils(){

        try{
            tokenizerConfig = new JcsegTaskConfig("/apps/web/autochess/jcseg.properties");
            JcsegTaskConfig extractorConfig = tokenizerConfig.clone();

            dic = DictionaryFactory.createSingletonDictionary(tokenizerConfig);

            tokenizerSeg = SegmentFactory.createJcseg(
                    JcsegTaskConfig.COMPLEX_MODE,
                    new Object[]{tokenizerConfig, dic}
            );

            //segmentation object for extractor
            extractorConfig.setAppendCJKPinyin(false);
            extractorConfig.setClearStopwords(true);
            extractorConfig.setKeepUnregWords(false);
            extractorSeg = SegmentFactory.createJcseg(
                    JcsegTaskConfig.COMPLEX_MODE,
                    new Object[]{extractorConfig, dic}
            );

            //create and initialize the extractor
            keywordsExtractor  = new TextRankKeywordsExtractor(tokenizerSeg);
            keyphraseExtractor = new TextRankKeyphraseExtractor(tokenizerSeg);
            summaryExtractor   = new TextRankSummaryExtractor(tokenizerSeg, new SentenceSeg());

            TextRankKeyphraseExtractor trkp = (TextRankKeyphraseExtractor)keyphraseExtractor;
            trkp.setAutoMinLength(4);
            trkp.setMaxWordsNum(4);
        } catch (Exception e){

        }
    }


    /**
     * 比较两个字符串的相似度
     * 1. 先做分词
     * 2. 根据分词结果形成两个向量
     * 3. 比较两个向量度相似度
     * @param source
     * @param target
     * @return
     */
    public int getSimilarity(String source, String target, Boolean ignorePunctuation){

        Map<String, Integer> sourceMap = tokenize(source);
        Map<String, Integer> targetMap = tokenize(target);

        if (ignorePunctuation){
            sourceMap = tokenize(ignorePunctuation(source));
            targetMap = tokenize(ignorePunctuation(target));
        }
        List<Integer> sourceList = new ArrayList();
        List<Integer> targetList = new ArrayList();
        int sourceLength = sourceMap.size();
        int targetLength = targetMap.size();

        for (Map.Entry<String, Integer> entry: sourceMap.entrySet()){

            String key = entry.getKey();
            int value = entry.getValue();

            sourceList.add(value);

            if (targetMap.containsKey(key)){
                targetList.add(targetMap.get(key));
            } else {
                targetList.add(0);
            }
        }

        for (Map.Entry<String, Integer> entry: targetMap.entrySet()){

            String key = entry.getKey();
            int value = entry.getValue();

            if (!sourceMap.containsKey(key)){
                sourceList.add(0);
                targetList.add(value);
            }
        }


        int length = sourceList.size();

        int denominator = 0;
        int sourcePow = 0;
        int targetPow = 0;

        for (int i = 0; i < length; i ++ ){

            denominator += sourceList.get(i) * targetList.get(i);
            sourcePow += sourceList.get(i) * sourceList.get(i);
            targetPow += targetList.get(i) * targetList.get(i);
        }

        int similarity = (int)(100 * (denominator / (Math.sqrt((double)sourcePow) * Math.sqrt((double)targetPow))));

//        System.out.println(source);
//        System.out.println(sourceList);
//        System.out.println(target);
//        System.out.println(targetList);

        return similarity;
    }

    /**
     * 完成句子的分词, 并排序
     * @param str
     * @return
     */
    public Map tokenize(String str){

        Map<String, Integer> tokenMap = new TreeMap();

        IWord word = null;

        try{
            tokenizerSeg.reset(new StringReader(str));
            while ( (word = tokenizerSeg.next()) != null ) {

                String value = word.getValue();

                if (tokenMap.containsKey(value)){
                    tokenMap.put(value, tokenMap.get(value) + 1);
                } else {
                    tokenMap.put(value, 1);
                }
            }
        } catch (Exception e){

        }

        return tokenMap;
    }

    public String ignorePunctuation(String source){

        String target = source.replaceAll("[\\pP\\p{Punct}]", " ");

        for(String punctuation: ignoreKeyList){

            target = target.replaceAll(punctuation, " ");
        }

        return target;
    }
}
