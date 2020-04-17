package com.zherke.durotan.interceptor;

import com.zherke.durotan.auth.service.ApiAuthenticator;
import com.zherke.durotan.util.SensitiveUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * 接口验证token
 * super HandlerInterceptor 其中方法改成默认方法
 */
@Slf4j
public class TokenAuthInterceptor implements HandlerInterceptor {

    /**
     * 重写查询执行后拦截方法
     * @param request
     * @param response
     * @param handler
     * @param
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从Spring容器中获取校验API
        ApiAuthenticator apiAuthenticator = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()).getBean(ApiAuthenticator.class);
        //获取请求完整url
        String url = request.getRequestURL() + "?" + request.getQueryString();
        if(!url.contains("error")){
            apiAuthenticator.auth(url);
        }
        return true;
    }


}
