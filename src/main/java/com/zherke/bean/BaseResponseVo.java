package com.zherke.bean;

import java.io.Serializable;

/**
 * @author lwb
 * @param <T>
 */
public class BaseResponseVo<T> implements Serializable{
	private String code;
	private String msg;
	private T data;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public void setCodeAndMsg(String code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public void setCodeAndMsg(CommonResultCode resultCode){
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
	}

	@Override
	public String toString() {
		return "BaseResponseVo{" +
				", code='" + code + '\'' +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
