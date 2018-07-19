package com.zherke.template.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author lwb
 * @create 2018-07-11 10:11
 * @desc a demo for filter
 **/
@Slf4j
@Component
@WebFilter(filterName="demoServlet",urlPatterns="/**")
public class DemoFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) {
        if(log.isInfoEnabled()){
            log.info("filter init.");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if(log.isInfoEnabled()){
            log.info("filter doFilter.");
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        if(log.isInfoEnabled()){
            log.info("filter destroy.");
        }
    }

}
