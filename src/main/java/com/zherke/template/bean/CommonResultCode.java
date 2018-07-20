package com.zherke.template.bean;

import java.io.Serializable;

/**
 * @author lwb
 * @date 2018-07-13
 */
public enum CommonResultCode implements Serializable {

    SUCCESS("200", "成功"),
    FAIL("400", "失败"),
    UNKNOWN_ERROR("99", "系统繁忙，请稍后再试"),
    SYSTEM_INSIDE_ERROR("500", "系统内部错误"),
    NOT_FOUND("404","接口不存在"),
    UNAUTHORIZED("401","未认证（签名错误）");

    private String code;
    private String msg;

    private CommonResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }


}
