package com.ufi.pdioms.resource.common.model;


public enum ErrorCode 
{
    ErrorCode("214521","输出错误"),
    SYSTEM_ERROR("527923","使用测试日志信息"),
	SERVER_EXCEPTION("1323358","输出形式"),
	;
	
    private String code;
    
    private String msg;
    
    /** 产品错误码前缀 */
    private ErrorCode(String errCode, String errMsg)
    {
        this.code = errCode;
        this.msg = errMsg;
    }

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
    
}
