package com.delu.springboot.autochess.tools;

/**
 * Created by delu on 2019-03-29.
 */
public class SqlUtils {

    public static String formatField(String field){

        return "'" + field + "'";
    }

    public static String formatField(int field){

        return "'" + field + "'";
    }
}
