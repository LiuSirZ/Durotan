package com.zherke.durotan.util;

import com.zherke.durotan.algorithm.ExcuteSensitiveAlgorithmContext;
import com.zherke.durotan.algorithm.SensitiveAlgorithm;
import com.zherke.durotan.algorithm.impl.*;
import com.zherke.durotan.annotation.Desensitization;
import com.zherke.durotan.pojo.Users;
import org.apache.commons.lang3.SerializationUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 脱敏注解解析类
 * @author lwb
 * @since 2020/01/10
 * @version 1.0
 */
public class SensitiveUtil {
    /**
     * 初始化算法实例
     * @auther lwb
     * @since 2020/01/10
     * @version 1.0
     */
    /**
     * 密码脱敏
     */
    private static SensitiveAlgorithm passwordSensitiveAlgorithm = new PasswordSensitiveAlgorithm();
    /**
     * 邮件脱敏
     */
    private static SensitiveAlgorithm emailSensitiveAlgorithm = new EmailSensitiveAlgorithm();
    /**
     * 身份证号脱敏
     */
    private static SensitiveAlgorithm idCardSensitiveAlgorithm = new IdCardSensitiveAlgorithm();
    /**
     * 账户编号脱敏
     */
    private static SensitiveAlgorithm accountNoSensitiveAlgorithm = new AccountNoSensitiveAlgorithm();
    /**
     * 固定电话脱敏
     */
    private static SensitiveAlgorithm fixedPhoneSensitiveAlgorithm = new FixedPhoneSensitiveAlgorithm();
    /**
     * 中文名脱敏
     */
    private static SensitiveAlgorithm chineseNameSensitiveAlgorithm = new ChineseNameSensitiveAlgorithm();
    /**
     * 手机号脱敏
     */
    private static SensitiveAlgorithm mobilePhoneSensitiveAlgorithm = new MobilePhoneSensitiveAlgorithm();

    /**
     * 空实现
     */
    private static SensitiveAlgorithm baseSensitiveAlgorithm = new BaseSensitiveAlgorithm();

    /**
     * 解析方法
     * @param clazz
     */
    public static void excute(Object object) throws IntrospectionException {

        //Map格式单独处理
        if(object instanceof Map){
            //TODO 待实现

        }else{
            /**
             * // 深层复制bean 避免操作原始bean
             * // 序列化
             * byte[] serialize = SerializationUtils.serialize(clazz);
             * // 反序列化
             * Class<?> clazzCopy = SerializationUtils.deserialize(serialize);
             */
            Class<?> clazz = object.getClass();
            Field [] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // 判断字段是否存在该注解
                if(field.isAnnotationPresent(Desensitization.class)){
                    Desensitization annotation = field.getAnnotation(Desensitization.class);
                    // 注解是否开启状态
                    if(annotation.isDesensitization()){

                        ExcuteSensitiveAlgorithmContext excute = null;
                        excute = switchExcute(annotation);
                        //设置需要脱敏的字段属性
                        excute.setField(field);
                        excute.setObj(object);
                        //执行脱敏算法
                        excute.excuteSensitive();
                    }
                }
            }
        }

    }

    /**
     * 选取脱敏执行类
     * @param excute
     */
    private static ExcuteSensitiveAlgorithmContext switchExcute(Desensitization annotation) {
        ExcuteSensitiveAlgorithmContext excute = null;
        switch (annotation.sensitiveType()){
            case PASSWORD:
                excute = new ExcuteSensitiveAlgorithmContext(passwordSensitiveAlgorithm);
                break;
            case EMAIL:
                excute = new ExcuteSensitiveAlgorithmContext(emailSensitiveAlgorithm);
                break;
            case ID_CARD:
                excute = new ExcuteSensitiveAlgorithmContext(idCardSensitiveAlgorithm);
                break;
            case ACCOUNT_NO:
                excute = new ExcuteSensitiveAlgorithmContext(accountNoSensitiveAlgorithm);
                break;
            case FIXED_PHONE:
                excute = new ExcuteSensitiveAlgorithmContext(fixedPhoneSensitiveAlgorithm);
                break;
            case CHINESE_NAME:
                excute = new ExcuteSensitiveAlgorithmContext(chineseNameSensitiveAlgorithm);
                break;
            case MOBILE_PHONE:
                excute = new ExcuteSensitiveAlgorithmContext(mobilePhoneSensitiveAlgorithm);
                break;
            default:
                excute = new ExcuteSensitiveAlgorithmContext(baseSensitiveAlgorithm);
        }
        return excute;
    }

    public static void main(String[] args) throws IntrospectionException {
        Users u = new Users();
        u.setUserEmail("liuwenbiao12138@163.com");
        SensitiveUtil.excute(u);
        System.out.println(u);
    }

    /**
     * 获取
     * @param field
     * @return
     */
    public static Method invokeFieldGetMethod(Field field, Class<?> clazz) throws IntrospectionException {
        //设置字段可修改
        field.setAccessible(true);
        PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
        //获得get方法
        Method getMethod = pd.getReadMethod();
        //执行get方法返回一个Object
        return getMethod;
    }
}
