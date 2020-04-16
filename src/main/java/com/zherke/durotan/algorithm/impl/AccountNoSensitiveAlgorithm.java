package com.zherke.durotan.algorithm.impl;

import com.zherke.durotan.algorithm.SensitiveAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * 银行账户号解密
 * @author lwb
 * @since 2020/01/10
 * @version 1.0
 */
@Slf4j
public class AccountNoSensitiveAlgorithm implements SensitiveAlgorithm {

    @Override
    public void executeSensitive(Field field, Object object) {
        log.info("AccountNoSensitiveAlgorithm execute");
    }
}
