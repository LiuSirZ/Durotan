package com.zherke.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lwb
 * @date 2018-07-13
 */
@Slf4j
@EnableWebMvc
@RestController
@ServletComponentScan
@SpringBootApplication
@MapperScan(basePackages = "com.zherke.template.mapper")
public class Application extends WebMvcConfigurationSupport implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        if(log.isInfoEnabled()){
            log.info("服务启动完成!");
        }
    }
}
