package com.delu.springboot.autochess.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by delu on 2019-03-27.
 */
public class BaseResultMap {

    private int code = 0;
    private String msg = "success";
    private Map dataMap = new HashMap();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map dataMap) {
        this.dataMap = dataMap;
    }
}
