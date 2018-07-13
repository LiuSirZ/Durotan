package com.zherke.template.listener;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@WebListener
public class DemoHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        if(log.isInfoEnabled()){
            log.info("session初始化.");
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if(log.isInfoEnabled()){
            log.info("session销毁.");
        }
    }
}
