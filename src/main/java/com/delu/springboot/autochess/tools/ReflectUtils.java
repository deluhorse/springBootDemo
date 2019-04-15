package com.delu.springboot.autochess.tools;

import com.delu.springboot.autochess.chess.Chess;

import java.lang.reflect.Method;

/**
 * Created by delu on 2019-04-08.
 */
public class ReflectUtils {

    public static ReflectUtils instance = new ReflectUtils();

    /**
     * 反射调用函数
     * @param object
     * @param methodStr
     * @param value
     */
    public void invokeMethod(Object object, String methodStr, String value){

        try{
            Method method = object.getClass().getDeclaredMethod(methodStr, String.class);
            method.invoke(object, value);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){

        ReflectUtils reflectUtils = new ReflectUtils();

        Chess chess = new Chess();

        reflectUtils.invokeMethod(chess, "setChessId", "123");
        System.out.println(chess.getChessId());
    }
}
