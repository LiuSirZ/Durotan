package com.zherke.durotan.annotation;

import com.zherke.durotan.enums.SensitiveTypeEnum;

import java.lang.annotation.*;

/**
 * 返回参数字段
 * isDesensitization：是否脱敏操作
 * sensitiveType：    脱敏字段类型
 * @author lwb
 * @since 2020/01/10
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitization {
    /**
     * 是否脱敏
     * @return
     */
    boolean isDesensitization() default false;

    /**
     * 字段脱敏方案
     * @return
     */
    SensitiveTypeEnum sensitiveType();
}
