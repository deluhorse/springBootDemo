package com.delu.springboot.auto_chess.tools;

import com.delu.springboot.autochess.tools.JcsegUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lionsoul.jcseg.test.JcsegTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by delu on 2019-04-02.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JcsegUtilsTest {

    @Test
    public void test() {

        JcsegUtils jcsegUtils = new JcsegUtils();

        String str = "SpringBoot mybatis 整合\n" +
                "自走棋大作战\n" +
                "\n" +
                "2019JAVA面试题附答案(长期更新) - weixin_38399962的博客 - CSDN博客\n" +
                "\n" +
                "architect-awesome/README.md at master · xingshaocheng/architect-awesome · GitHub\n" +
                "\n" +
                "Spring Boot基础教程 | 程序猿DD\n" +
                "\n" +
                "GitHub - dyc87112/SpringBoot-Learning: Spring Boot基础教程，Spring Boot 2.x版本连载中！！！\n" +
                "\n" +
                "Spring Boot\n" +
                "\n" +
                "Spring Initializr\n" +
                "\n" +
                "我的桌面 - 石墨文档\n" +
                "\n" +
                "mybatis注解方式查询，返回null - Google 搜索\n" +
                "\n" +
                "使用mybatis3--注解方式 - 阿宇_的个人空间 - 开源中国\n" +
                "\n" +
                "mybatis注解Select查询List，返回有对象个数，但是为null - weixin_41887312的博客 - CSDN博客\n" +
                "\n" +
                "Mybatis查询全部信息的时候，返回的List有记录数，但是都是null??-CSDN论坛\n" +
                "\n" +
                "基于 SpringBoot2.0+优雅整合 SpringBoot+Mybatis - 掘金\n" +
                "\n" +
                "spring注解大全解析 spring springboot注解等 - 筱进GG - CSDN博客\n" +
                "\n" +
                "YuiAPI - A REST Client, Api Test and document\n" +
                "\n" +
                "localhost:8089/spring-boot/user/query\n" +
                "\n" +
                "spring boot junit单元测试 - Google 搜索\n" +
                "\n" +
                "Spring Boot---(11)SpringBoot使用Junit单元测试 - IT云清 - CSDN博客\n" +
                "\n" +
                "IDEA Maven打包时去掉test - wk022的专栏 - CSDN博客\n" +
                "\n" +
                "Maven编译打包时如何忽略测试用例 - JAVA_EE技术探讨 - ITeye博客\n" +
                "\n" +
                "mybatis 教程 - Google 搜索\n" +
                "\n" +
                "史上最简单的 MyBatis 教程（一） - CG国斌的博客 - CSDN博客\n" +
                "\n" +
                "SpringBoot 快速开启事务（附常见坑点） - 简书\n" +
                "\n" +
                "spring boot配置mybatis和事务管理 - 凌大大的博客 - CSDN博客\n" +
                "\n" +
                "springboot junit 教程 - Google 搜索\n" +
                "\n" +
                "学习 Spring Boot：（二十九）Spring Boot Junit 单元测试 | My Sunshine\n" +
                "\n" +
                "Spring Boot Junit单元测试 - 小单的博客专栏 - CSDN博客\n" +
                "\n" +
                "@SelectProvider - Google 搜索\n" +
                "\n" +
                "mybatis使用@SelectProvider构建动态语句，多个参数(不使用@param注解情况下),3.4.2版本之后报错 BindingException: Parameter 'arg0' - nesxy的博客 - CSDN博客\n" +
                "\n" +
                "Mybatis @SelectProvider注解详解 - 酷毙了耶的博客 - CSDN博客\n" +
                "\n" +
                "mybatis3中@SelectProvider的使用技巧 - dbstar的技术Blog - BlogJava\n" +
                "\n" +
                "mybatis 防止 sql 注入 和 mybatis 的预编译 - qq_40285302的博客 - CSDN博客\n" +
                "\n" +
                "springboot 对象转map - Google 搜索\n" +
                "\n" +
                "Mybatis传入参数类型为Map - earthhour的专栏 - CSDN博客\n" +
                "\n" +
                "mybatis – MyBatis 3 | SQL语句构建器\n" +
                "\n" +
                "@Transactional这个事务注解对父类继承过来的方法无效 - 我叫阿狸猫 - CSDN博客\n" +
                "\n" +
                "护甲 - Dota 2 Wiki，刀塔百科\n" +
                "\n" +
                "springboot Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported - Google 搜索\n" +
                "\n" +
                "chrome 插件开发 - Google 搜索\n" +
                "\n" +
                "开发者指南 - Google Chrome 扩展程序开发文档（非官方中文版）\n" +
                "\n" +
                "【干货】Chrome插件(扩展)开发全攻略 - 我是小茗同学 - 博客园\n" +
                "\n" +
                "tabManager 开发\n" +
                "\n" +
                "网页布局工具 - Google 搜索\n" +
                "\n" +
                "Bootstrap可视化布局系统\n" +
                "\n" +
                "开发chrome extension抓取页面数据，并传输到另一页面 - m0_37729058的博客 - CSDN博客\n" +
                "\n" +
                "Getting Started Tutorial - Google Chrome\n" +
                "\n" +
                "chrome.tabs - Google Chrome 扩展程序开发文档（非官方中文版）\n" +
                "\n" +
                "yuiitsu/CEF: A simple Chrome Extension development falsework\n" +
                "\n" +
                "扩展程序\n" +
                "\n" +
                "chrome.tabs.query - Google 搜索\n" +
                "\n" +
                "CES - A simple Chrome Extension development framework";

        String initArray[] = str.split("\n");

        List<String> strArray = new ArrayList<>();

        for(String tempStr: initArray){

            if (!"".equals(tempStr)){
                strArray.add(tempStr);
            }
        }

        Map<String, String> resultMap = new HashMap<>();
        Map<String, String> tempMap = new HashMap<>();

        for (int i = 0; i < strArray.size(); i ++){

            for (int j = i + 1; j < strArray.size(); j ++){

                String source = strArray.get(i);
                String target = strArray.get(j);

                int similarity = jcsegUtils.getSimilarity(source, target, true);

                if (similarity > 50){
                    // 如果相似度大于0, 则打印两个句子
//                    System.out.println(source);
//                    System.out.println(target);
//                    System.out.println(similarity);

                    resultMap.put(source, target);
                }
            }
        }

        for (Map.Entry<String, String> entry: resultMap.entrySet()){

            List<String> groupList = new ArrayList<>();

            String key = entry.getKey();
            String value = entry.getValue();

            groupList.add(key);
            groupList.add(value);

            tempMap.put(key, "");
            tempMap.put(value, "");

            while (resultMap.get(value) != null){

                value = resultMap.get(value);

                if (tempMap.containsKey(value)){
                    break;
                }

                tempMap.put(value, "");

                groupList.add(value);
            }

            System.out.println("------分组: " + groupList.get(0));
            System.out.println(groupList);
        }
    }

    @Test
    public void test1(){
        JcsegUtils jcsegUtils = new JcsegUtils();

        String source = "是猴子";
        String target = "不是金丝猴";

        int similarity = jcsegUtils.getSimilarity(source, target, false);
        System.out.println(similarity);
    }
}