package com.zherke.durotan.algorithm;

import java.lang.reflect.Field;

/**
 * 脱敏策略执行类
 * @author lwb
 * @since 2020/01/20
 * @version 1.0
 */
public class executeSensitiveAlgorithmContext {

    private Field field;
    private Object object;
    private SensitiveAlgorithm sensitiveAlgorithm;

    public executeSensitiveAlgorithmContext(SensitiveAlgorithm sensitiveAlgorithm){
        this.sensitiveAlgorithm = sensitiveAlgorithm;
    }

    public void executeSensitive(){
        sensitiveAlgorithm.executeSensitive(field,object);
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setObj(Object object) {
        this.object = object;
    }
}
