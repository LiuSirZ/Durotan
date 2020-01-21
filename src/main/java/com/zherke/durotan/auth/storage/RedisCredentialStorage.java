package com.zherke.durotan.auth.storage;

import org.springframework.stereotype.Component;

/**
 * 服务访问鉴权
 *  缓存获取加密密钥
 * @author lwb
 * @since 2020/01/21
 * @version 1.0
 */
@Component
public class RedisCredentialStorage extends CredentialStorageBase {

    @Override
    public String getCheckDigit(String appId) {
        //TODO 暂缓
        return "1111";
    }
}
