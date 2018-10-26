package com.zherke.interceptor;

import io.micrometer.core.lang.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lwb
 * @create 2018-07-11 10:15
 * @desc a demo for interceptor
 **/
@Slf4j
public class DemoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(log.isInfoEnabled()){
            log.info(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        }
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        if(log.isInfoEnabled()){
            log.info(">>>MyInterceptor2>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        if(log.isInfoEnabled()){
            log.info(">>>MyInterceptor3>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
        }
    }
}
