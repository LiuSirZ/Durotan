package com.zherke.durotan.auth.service.impl;

import com.zherke.durotan.auth.bean.ApiRequest;
import com.zherke.durotan.auth.bean.AuthToken;
import com.zherke.durotan.auth.service.ApiAuthenticator;
import com.zherke.durotan.auth.storage.CredentialStorageBase;
import com.zherke.durotan.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务访问鉴权
 *  接口具体实现
 * @author lwb
 * @since 2020/01/21
 * @version 1.0
 */
public class ApiAuthenticatorImpl implements ApiAuthenticator {

    @Autowired
    private CredentialStorageBase redisCredentialStorageBase;

    @Override
    public void auth(String url) throws Exception {
        //根据url获取请求实体 调用实体校验方法
        ApiRequest apiRequest = ApiRequest.formatFromUrl(url);
        this.executeAuth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) throws Exception {
        executeAuth(apiRequest);
    }

    /**
     * 实际通用鉴权方法
     * @param apiRequest
     */
    private void executeAuth(ApiRequest apiRequest) throws Exception {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();

        //验证请求token是否失效
        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if(!clientAuthToken.isExpired()){
            throw new ServiceException("token已失效");
        }

        //验证token是否正确
        Map<String,String> params = new HashMap<>();
        params.put("appId",appId);
        params.put("checkDigit",redisCredentialStorageBase.getCheckDigit(appId));
        AuthToken authToken = AuthToken.create(apiRequest.getBaseUrl(), apiRequest.getTimestamp(), params);
        if(!authToken.match(clientAuthToken)){
            throw new ServiceException("token验证失败");
        }
    }
}
