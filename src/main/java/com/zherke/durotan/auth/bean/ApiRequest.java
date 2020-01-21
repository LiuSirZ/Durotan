package com.zherke.durotan.auth.bean;

import com.zherke.durotan.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * 服务访问鉴权
 *  API请求处理类
 * @author lwb
 * @since 2020/01/21
 * @version 1.0
 */
public class ApiRequest {

    /**
     * 请求URL
     */
    private String baseUrl;
    /**
     * 请求携带token
     */
    private String token;
    /**
     * 请求时间戳
     */
    private long timestamp;
    /**
     * 请求服务ID
     */
    private String appId;

    /**
     * 全参构造
     * @param baseUrl
     * @param token
     * @param appId
     * @param timestamp
     */
    public ApiRequest(String baseUrl, String token, String appId, long timestamp){
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    /**
     * 将url为ApiRequest
     * @param url 访问url  http://baseUrl?appId=value&token=value&timestamp=value
     * @return
     */
    public static ApiRequest formatFromUrl(@NotNull String url){

        //分割原始请求url
        String[] urlPattern = url.split("\\?");
        if(urlPattern.length < 2){
            throw new ServiceException("请求url有误");
        }

        //截取参数集
        String params = urlPattern[1];
        if(StringUtils.isBlank(params)){
            throw new ServiceException("请求url中不包含参数");
        }

        //分解参数
        String[] param = params.split("&");
        if(param.length < 3){
            throw new ServiceException("请求url中必备参数不全");
        }

        //解析参数
        String baseUrl = urlPattern[0];
        String appId = param[0];
        String token = param[1];
        long timestamp = Long.parseLong(param[2]);

        //封装ApiRequest
        return new ApiRequest(baseUrl, token, appId, timestamp);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getAppId() {
        return appId;
    }
}
