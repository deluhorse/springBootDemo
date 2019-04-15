package com.delu.springboot.autochess.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

/**
 * Created by delu on 2019-03-28.
 */
public class CommonUtils {

    /**
     * 生成固定长度的随机字符串
     * @param length
     * @return
     */
    public static String createRamdonString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * md5加密
     * @param source
     * @return
     */
    public static String md5(String source) {
        try{
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(source.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e){
            e.printStackTrace();
        }

        return source;
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static Boolean isEmpty(Object str){

        if (str == null){
            return true;
        }

        if ("".equals((String)str)){
            return true;
        }

        return false;
    }

    public static String captureName(String name, String ... args) {
        try{
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(args[0]);
        }
        return name;
    }

}
