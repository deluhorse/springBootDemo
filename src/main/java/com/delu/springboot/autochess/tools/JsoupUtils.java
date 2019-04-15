package com.delu.springboot.autochess.tools;

import com.delu.springboot.autochess.chess.Chess;
import com.delu.springboot.autochess.chess.ChessDao;
import com.delu.springboot.autochess.chess.dto.ChessDaoBaseDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by delu on 2019-04-07.
 */
public class JsoupUtils {

    private Map<String, String> chessAttrMap = new HashMap<>();

    public JsoupUtils(){

        chessAttrMap.put("生命值", "health");
        chessAttrMap.put("生命恢复", "healthRegen");
        chessAttrMap.put("魔法抗性", "magicRes");
        chessAttrMap.put("魔法值", "mana");
        chessAttrMap.put("魔法恢复", "manaRegen");
        chessAttrMap.put("技能伤害", "spellDmg");
        chessAttrMap.put("护甲", "armor");
        chessAttrMap.put("攻击速度", "attSec");
        chessAttrMap.put("移动速度", "moveSpAmp");
        chessAttrMap.put("攻击力", "damage");
    }


    public Chess getChessFromUrl(String url){
        try{
            Chess chess = new Chess();

            Document doc = Jsoup.connect(url).get();

            chess.setChessName(doc.select("#firstHeading").text());
            String headImg = doc.select(".infobox .image img").attr("src");
            chess.setHeadImg(headImg);

            String baseUrl = headImg.split("\\?")[0];
            String[] tempArray = baseUrl.split("\\/");
            String chessId = tempArray[tempArray.length - 1].split("_")[0];
            chess.setChessId(chessId);

            Element detail = doc.select("#heroBio").get(0);

            String detailStr = detail.childNode(5).childNode(1).childNode(3).childNode(0).outerHtml();

            chess.setDetail(detailStr);

            Elements elements = doc.select(".evenrowsgray tr");
            int index = -1;
            for (Element element: elements){

                index += 1;

                if (index == 0){
                    continue;
                }

                String attr = element.childNode(1).childNode(0).attr("title");

                String value = element.childNode(3).childNode(0).outerHtml()
                        + "-" + element.childNode(5).childNode(0).outerHtml()
                        + "-" + element.childNode(7).childNode(0).outerHtml()
                        + "-" + element.childNode(9).childNode(0).outerHtml();

                ReflectUtils.instance.invokeMethod(chess, "set" + CommonUtils.captureName(chessAttrMap.get(attr), attr), value.trim());
            }

            return chess;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新棋子的基本信息(自走棋信息)
     * @param filePath
     * @param chessList
     * @return
     */
    public List<Chess> getOccupationFromFile(String filePath, List<Chess> chessList){
        try{
            Map<String, Chess> chessMap = new HashMap<>();

            for (Chess chess: chessList){

                chessMap.put(chess.getChessId(), chess);
            }

            Document doc = Jsoup.parse(new File(filePath), "utf-8");

            Elements elements = doc.select(".heroes");

            for (Element element: elements){

                Elements heroList = elements.select(".hero");

                for (Element hero: heroList){

                    String chessId = hero.attr("data-hero-search");

                    Chess chess = chessMap.get(chessId);

                    if (chess == null){
                        System.out.println(chessId);
                        System.out.println(hero.select(".hero__class").get(0).childNode(0).outerHtml());
                        System.out.println(hero.select(".hero__class").get(1).childNode(0).outerHtml());
                        continue;
                    }

                    chess.setRace(hero.select(".hero__class").get(0).childNode(0).outerHtml().replaceAll("\n", ""));
                    chess.setOccupation(hero.select(".hero__class").get(1).childNode(0).outerHtml().replaceAll("\n", ""));

                    Elements attrElementList = hero.select(".dark-table__content");

                    for (Element attrElement: attrElementList){

                        chess.setHealth(attrElement.childNode(2).outerHtml());
                        chess.setArmor(attrElement.childNode(6).outerHtml());
                        chess.setMagicRes(attrElement.childNode(10).outerHtml());
                        chess.setDamage(attrElement.childNode(14).outerHtml());
                        chess.setAttSec(attrElement.childNode(18).outerHtml());
                        chess.setAvgDps(attrElement.childNode(22).outerHtml());
                    }
                }
            }


        } catch (Exception e){
            e.printStackTrace();
        }
        return chessList;
    }

    public static void main(String args[]){

    }
}
