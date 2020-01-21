package com.zherke.durotan.auth.service;

import com.zherke.durotan.auth.bean.ApiRequest;

/**
 * 服务访问鉴权
 *  外放API接口
 * @author lwb
 * @since 2020/01/21
 * @version 1.0
 */
public interface ApiAuthenticator {
    /**
     * 根据请求URL格式鉴权
     * @param url 拼接token的url
     */
    void auth(String url) throws Exception;

    /**
     * 根据请求参数鉴权
     * @param apiRequest 封装好的ApiRequest实体
     */
    void auth(ApiRequest apiRequest);
}
