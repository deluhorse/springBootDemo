package com.delu.springboot.autochess.base.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by delu on 2019-03-30.
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器被调用");
        //省略具体的逻辑

        request.setAttribute("key", "haha");


        return true;
    }
}
