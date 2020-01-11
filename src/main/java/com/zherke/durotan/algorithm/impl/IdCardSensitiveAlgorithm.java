package com.zherke.durotan.algorithm.impl;

import com.zherke.durotan.algorithm.SensitiveAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * 身份证脱敏
 * @author lwb
 * @since 2020/01/10
 * @version 1.0
 */
@Slf4j
public class IdCardSensitiveAlgorithm implements SensitiveAlgorithm {

    @Override
    public void excuteSensitive(Field field, Object object) {
        log.info("IdCardSensitiveAlgorithm excute");
    }
}
