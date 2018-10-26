package com.durotan.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author lwb
 * @create 下午3:40 2018-07-19
 * @desc 配置类 读取properties配置文件
 * @ConfigurationProperties 用来指定properties配置文件中的key前缀
 */
@Component
@ConfigurationProperties(prefix="demo")
@PropertySource("classpath:config/demo.properties")
public class ConfigProperties {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
