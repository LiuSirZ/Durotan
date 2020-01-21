package com.zherke.durotan.auth.bean;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/**
 * 服务访问鉴权
 * auth token 处理类
 * @author lwb
 * @since 2020/01/21
 * @version 1.0
 */
public class AuthToken {
    /**
     * 默认失效时间
     */
    private static final long DEFAULT_EXPIRATION_TIME = 1*60*1000;
    /**
     * 校验token
     */
    private String token;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 失效间隔
     */
    private long expirationTimeInterval = DEFAULT_EXPIRATION_TIME;

    public AuthToken(String token, long createTime){
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime ,long expirationTimeInterval){
        this.token = token;
        this.createTime = createTime;
        this.expirationTimeInterval = expirationTimeInterval;
    }

    /**
     * 初始化 AuthToken
     * @param baseUrl
     * @param createTime
     * @param params
     * @return
     */
    public static AuthToken create(String baseUrl, long createTime, Map<String,String> params) throws Exception {
        String appId = params.get("appId");
        String checkDigit = params.get("checkDigit");
        //填充生成token算法
        String token = "";
        token = HmacSHA1(baseUrl + appId, checkDigit);
        return new AuthToken(token, createTime);
    }

    /**
     * 获取token
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     * 判断是否失效
     * @return
     */
    public boolean isExpired(){
        return createTime - System.currentTimeMillis() <= DEFAULT_EXPIRATION_TIME;
    }

    /**
     * 验证token
     * @param authToken
     * @return
     */
    public boolean match(AuthToken authToken){
        return this.token.equals(authToken.getToken());
    }

    /**
     * HmacSHA1 加密
     * @param encryptText
     * @param encryptKey
     * @return
     * @throws Exception
     */
    private static String HmacSHA1(String encryptText, String encryptKey) throws Exception {
        byte[] data=encryptKey.getBytes(StandardCharsets.UTF_8);
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");
        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance("HmacSHA1");
        //用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(StandardCharsets.UTF_8);
        //完成 Mac 操作
        return Arrays.toString(mac.doFinal(text));
    }
}
