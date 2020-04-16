package com.zherke.durotan.algorithm;

import java.lang.reflect.Field;

/**
 * 脱敏算法接口
 * @author lwb
 * @since 2020/01/10
 * @version 1.0
 */
public interface SensitiveAlgorithm {

    /**
     * 执行脱敏算法
     */
    void executeSensitive(Field field, Object object);
}
