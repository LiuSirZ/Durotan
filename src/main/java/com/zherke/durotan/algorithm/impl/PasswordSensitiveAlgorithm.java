package com.zherke.durotan.algorithm.impl;

import com.zherke.durotan.algorithm.SensitiveAlgorithm;
import com.zherke.durotan.util.SensitiveUtil;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 密码脱敏算法
 * @author lwb
 * @since 2020/01/10
 * @version 1.0
 */
@Slf4j
public class PasswordSensitiveAlgorithm implements SensitiveAlgorithm {

    @Override
    public void executeSensitive(Field field, Object object) {

        log.info("PasswordSensitiveAlgorithm execute。");
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                //反射预处理字段值
                Method getMethod = SensitiveUtil.invokeFieldGetMethod(field, clazz);

                //执行get方法返回一个Object
                Object invoke = getMethod.invoke(object);
                if(invoke instanceof String){
                    String temp = (String) invoke;
                    //调用密码脱敏方法

                }
                field.set(object, invoke);
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
                if(log.isErrorEnabled()){
                    log.error("PasswordSensitiveAlgorithm error:{}",e.getMessage());
                }
            }
        }
    }
}
