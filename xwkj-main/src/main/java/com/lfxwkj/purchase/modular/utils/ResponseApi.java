package com.lfxwkj.purchase.modular.utils;


import com.lfxwkj.purchase.common.ResultCode;

public class ResponseApi {

	// 返回的返回码
	private String code;
	// 返回的数据
	private Object data;
	// 请求的正确信息
	private boolean success;
	// 返回的信息
	private String message;
	// 后台的异常
	private String exceptionName;


	public void success(Object data){
		this.success = Boolean.TRUE;
		this.code = ResultCode.SUCCEE;
		this.message = "请求成功";
		this.data = data;
	}

	
	public void fail(){
		this.success = Boolean.FALSE;
		this.code = ResultCode.FAIL;
		this.data = null;
		this.message = "网络异常";
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
}
