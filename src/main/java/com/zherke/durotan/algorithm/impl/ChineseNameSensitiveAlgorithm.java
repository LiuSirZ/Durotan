package com.zherke.durotan.algorithm.impl;

import com.zherke.durotan.algorithm.SensitiveAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * 中文名脱敏算法实现
 * @author lwb
 * @since 2020/01/20
 * @version 1.0
 */
@Slf4j
public class ChineseNameSensitiveAlgorithm implements SensitiveAlgorithm {

    @Override
    public void excuteSensitive(Field field, Object object) {
        log.info("ChineseNameSensitiveAlgorithm excute");
    }
}
