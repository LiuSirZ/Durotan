package com.zherke.template.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author lwb
 * @create 上午10:20 2018-07-11
 * @desc a demo for listener
 **/
@WebListener
public class DemoContextListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(DemoContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("ServletContex初始化.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("ServletContex销毁.");
    }
}
