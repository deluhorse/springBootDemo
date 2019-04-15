package com.delu.springboot.autochess.user.account;

import com.alibaba.fastjson.JSONObject;
import com.delu.springboot.autochess.base.BaseResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by delu on 2019-03-30.
 */
@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public BaseResultMap testJson(@RequestParam Map<String, Object> params){

        BaseResultMap baseResultMap = new BaseResultMap();
        baseResultMap.setDataMap(params);

        return baseResultMap;
    }


//    @ResponseBody
//    @RequestMapping(value = "/test2", method = RequestMethod.POST)
//    public String testJson2(@RequestBody Map<String, Object> params){
//
//        // 直接将json信息打印出来
//        System.out.println(params);
//
//        // 将获取的json数据封装一层，然后在给返回
//        JSONObject result = new JSONObject();
//        result.put("msg", "ok");
//        result.put("method", "@ResponseBody");
//        result.put("data", params);
//
//        return result.toJSONString();
//    }
}