package com.zherke.durotan.algorithm;

import java.lang.reflect.Field;

/**
 * 脱敏策略执行类
 * @author lwb
 * @since 2020/01/20
 * @version 1.0
 */
public class ExcuteSensitiveAlgorithmContext {

    private Field field;
    private Object object;
    private SensitiveAlgorithm sensitiveAlgorithm;

    public ExcuteSensitiveAlgorithmContext(SensitiveAlgorithm sensitiveAlgorithm){
        this.sensitiveAlgorithm = sensitiveAlgorithm;
    }

    public void excuteSensitive(){
        sensitiveAlgorithm.excuteSensitive(field,object);
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setObj(Object object) {
        this.object = object;
    }
}
