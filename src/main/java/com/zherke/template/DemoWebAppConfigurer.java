package com.zherke.template;

import com.zherke.template.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author lwb
 * @create 上午10:35 2018-07-11
 * @desc a demo
 **/
@Configuration
public class DemoWebAppConfigurer extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //TODO 添加拦截器到拦截器组 添加拦截URL以及忽略的URL
        registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**").excludePathPatterns("/User/hello");
        super.addInterceptors(registry);
    }
}