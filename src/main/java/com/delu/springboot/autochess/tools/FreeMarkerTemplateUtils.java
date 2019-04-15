package com.delu.springboot.autochess.tools;

import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

/**
 * Created by delu on 2019-04-07.
 */
public class FreeMarkerTemplateUtils {
    private FreeMarkerTemplateUtils(){}
    private static final Configuration CONFIGURATION = new Configuration();

    static{
        //这里比较重要，用来指定加载模板所在的路径
        try {
            CONFIGURATION.setDirectoryForTemplateLoading(new File("/Users/delu/programs/java/springBootDemo/freemarker/templates"));
            CONFIGURATION.setDefaultEncoding("UTF-8");
            CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            CONFIGURATION.setCacheStorage(new NullCacheStorage());
        } catch (Exception e){

        }

    }

    public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }

    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }
}
