package com.delu.springboot.tab;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.delu.springboot.autochess.base.BaseResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by delu on 2019-04-03.
 */
@RestController
@RequestMapping(value = "tab")
public class TabController {

    @Autowired
    private TabService tabService;

    @RequestMapping(value = "participle/create", method = RequestMethod.POST)
    public BaseResultMap getParticiple(@RequestParam Map<String, Object> params){

        BaseResultMap baseResultMap = new BaseResultMap();

        List<Set<Tab>> participleResult = tabService.getParticiple(JSONArray.parseArray((String)params.get("tabList"), Tab.class));

        Map dataMap = new HashMap();

        dataMap.put("participleResult", participleResult);

        baseResultMap.setDataMap(dataMap);

        return baseResultMap;
    }
}