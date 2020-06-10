package com.example.family.utils.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
@description 请求拦截
@anther  Administrator
@creater 2020-03-09 15:16
*/
@Component
public class LoginIntercept implements HandlerInterceptor {
    /**
     * controller方法执行前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求地址
        String servltPath = request.getServletPath();
        String requestUrl = request.getRequestURI();
        System.out.println("servletPath:"+servltPath+";requestUrl:"+requestUrl);

        //需要验证的请求
        return true;
    }

    /**
     * controller方法执行后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//    }
}
