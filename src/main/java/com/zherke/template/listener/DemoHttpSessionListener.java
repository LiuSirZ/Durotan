package com.zherke.template.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author lwb
 * @create 上午10:22 2018-07-11
 * @desc a demo for HttpSessionListener
 **/
@WebListener
public class DemoHttpSessionListener implements HttpSessionListener {

    private Logger logger = LoggerFactory.getLogger(DemoHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("session初始化.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("session销毁.");
    }
}
