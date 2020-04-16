package com.zherke.durotan.algorithm.impl;

import com.zherke.durotan.algorithm.SensitiveAlgorithm;
import com.zherke.durotan.util.SensitiveUtil;
import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 邮箱脱敏算法实现
 * @author lwb
 * @since
 * @version 1.0
 */
@Slf4j
public class EmailSensitiveAlgorithm implements SensitiveAlgorithm {

    @Override
    public void executeSensitive(Field field, Object object) {

        if(log.isDebugEnabled()){
            log.debug("EmailSensitiveAlgorithm execute");
        }

        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                //反射获取字段值
                Method getMethod = SensitiveUtil.invokeFieldGetMethod(field, clazz);
                Object invoke = getMethod.invoke(object);
                if(invoke instanceof String){
                    String temp = (String) invoke;
                    //调用脱敏逻辑
                    invoke = executeDesensitization(temp);
                }
                field.set(object, invoke);
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
                if(log.isErrorEnabled()){
                    log.error("EmailSensitiveAlgorithm error:{}",e.getMessage());
                }
            }
        }
    }

    /**
     * 脱敏操作逻辑实现
     * @param temp
     * @return
     */
    private Object executeDesensitization(String temp) {
        return temp;
    }
}
