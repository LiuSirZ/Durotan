package com.zherke.durotan.interceptor;

import com.zherke.durotan.util.SensitiveUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 基于自定义注解实现
 * 脱敏拦截器
 * super HandlerInterceptor 其中方法改成默认方法
 */
@Slf4j
public class SensitiveAlgorithmInterceptor implements HandlerInterceptor {

    /**
     * 重写查询执行后拦截方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        List list = (List)modelAndView.getModel().get("");
        for (Object object : list) {
            SensitiveUtil.excute(object);
        }
    }

}
