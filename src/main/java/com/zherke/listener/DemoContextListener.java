package com.zherke.listener;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author lwb
 * @create 上午10:20 2018-07-11
 * @desc a demo for listener
 **/
@Slf4j
@WebListener
public class DemoContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if(log.isInfoEnabled()){
            log.info("ServletContext初始化.");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if(log.isInfoEnabled()){
            log.info("ServletContext销毁.");
        }
    }
}
