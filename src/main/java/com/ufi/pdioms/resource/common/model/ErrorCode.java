package com.ufi.pdioms.resource.common.model;


public enum ErrorCode 
{
		RS_SERVICE_OK("00200","服务正常"),
		INVALID_REQ_PARAMS("00400", "Invalid parameter."),
		PERMISSION_DENY("00403","Access denied."),
		NO_FOUND("00404","Not found Web page"),
		SERVER_EXCEPTION("00500", "服务器忙。请稍后再试..."),
		SYSTEM_ERROR("00501", "System error.系统错误"),

		RS_SERVICE_DAO_ERROR("20104","数据库异常访问异常"),
		RS_SERVICE_NETWORK_ERROR ("20103","网络异常!请检查网络设备..."),

		DEVICE_TYPE_NOT_EXIST("30101", "该类型不存在"),
		DEVICE_TYPE_NAME_HAS_BEEN_USED("30102", "该类型名称已被使用"),

		DEVICE_MODEL_NOT_EXIST("30201", "该型号不存在"),
		DEVICE_MODEL_NAME_HAS_BEEN_USED("30202", "该型号名称已被使用"),

		DEVICE_NOT_EXIST("40101", "该设备不存在"),
		DEVICE_NUMBER_EXIST("40102", "该设备编号已存在"),


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
