package com.zherke.template.bean;

import java.io.Serializable;

/**
 * @author lwb
 * @date 2018-07-13
 */
public enum CommonResultCode implements Serializable {

    SUCCESS("00", "成功"),
    FAILD("01", "无失败信息"),
    UNKNOW_ERROR("99", "系统繁忙，请稍后再试"),
    SYSTEM_INSIDE_ERROR("98", "系统内部错误");

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
