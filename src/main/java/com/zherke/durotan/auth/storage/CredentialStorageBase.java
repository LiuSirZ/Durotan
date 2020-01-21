package com.zherke.durotan.auth.storage;

/**
 * 服务访问鉴权
 *  获取鉴权密钥
 * @author lwb
 * @since 2020/01/21
 * @version 1.0
 */
public abstract class CredentialStorageBase {
    /**
     * 根据appId获取校验密钥
     * @param appId
     * @return
     */
    public abstract String getCheckDigit(String appId);
}
