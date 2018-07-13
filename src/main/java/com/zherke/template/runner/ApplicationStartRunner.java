package com.zherke.template.runner;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lwb
 * @create 上午10:25 2018-07-11
 * @desc a demo for runner
 **/
@Component
@Slf4j
@Order(value = 1)
public class ApplicationStartRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //TODO 服务启动执行 处理加载数据等操作
        if(log.isInfoEnabled()){
            log.info(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        }
    }
}
