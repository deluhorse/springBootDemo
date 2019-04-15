package com.delu.springboot.tab;

import com.delu.springboot.autochess.tools.JcsegUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by delu on 2019-04-03.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
public class TabService {

    public List<Set<Tab>> getParticiple(List<Tab> initArray){

        JcsegUtils jcsegUtils = new JcsegUtils();

        List<Tab> tabList = new ArrayList<>();
        List<Set<Tab>> finalTabList = new ArrayList<>();
        Set<String> titleSet = new HashSet<>();

        for(Tab tab: initArray){

            if (!"".equals(tab.getTitle())){
                tabList.add(tab);
            }
        }

        for (int i = 0; i < tabList.size(); i ++){

            for (int j = i + 1; j < tabList.size(); j ++){

                Tab source = tabList.get(i);
                Tab target = tabList.get(j);

                int similarity = jcsegUtils.getSimilarity(source.getTitle(), target.getTitle(), true);

                if (similarity > 30){
                    titleSet.add(target.getTitle());

                    Set<Tab> sourceSet = containsSet(source, finalTabList);
                    Set<Tab> targetSet = containsSet(target, finalTabList);

                    if (sourceSet != null && targetSet == null){
                        sourceSet.add(target);
                    } else if (sourceSet == null && targetSet != null){
                        targetSet.add(source);
                    } else if (sourceSet == null && targetSet == null){
                        Set<Tab> tabSet = new HashSet<>();
                        tabSet.add(source);
                        tabSet.add(target);
                        finalTabList.add(tabSet);
                    }
                }
            }
        }

        for (Tab tab: initArray){

            if (containsSet(tab, finalTabList) == null){

                Set<Tab> tabSet = new HashSet<>();
                tabSet.add(tab);

                finalTabList.add(tabSet);
            }
        }

        return finalTabList;
    }

    /**
     * 检查tab是否已经存在于集合中，若存在则返回对应集合
     * @param tab
     * @param finalTabList
     * @return
     */
    public Set<Tab> containsSet(Tab tab, List<Set<Tab>> finalTabList){

        for (Set set: finalTabList){

            if (set.contains(tab)){
                return set;
            }
        }

        return null;
    }
}