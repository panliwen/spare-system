package com.ufi.pdioms.resource.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralResult 
{
	// 结果状态, true 成功 false 失败
    private boolean resultStatus;
    
    // 如果错误则返回 错误代码
    private String errorCode;
    
    // 错误详情描述
    private String errorMessage;
    
    // 结果为true时的 业务数据，可为空
    private Object resultData;
    
    public GeneralResult(){
    }
    
    public GeneralResult(ErrorCode error){
    	this.resultStatus = false;
    	this.errorCode = error.getCode();
    	this.errorMessage = error.getMsg();
    }
    
    public GeneralResult(ErrorCode error, Object obj){
    	this.resultStatus = false;
    	this.errorCode = error.getCode();
    	this.errorMessage = error.getMsg();
    	this.resultData = obj;
    }
    
    public GeneralResult(boolean resultStatus, String errorCode, String errorMessage)
    {
        super();
        this.resultStatus = resultStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

	public boolean getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(boolean resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errCode) {
		this.errorCode = errCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errMsg) {
		this.errorMessage = errMsg;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
		this.resultStatus = true;
	}
	
	public void setErr(ErrorCode errCode) {
		this.errorCode = errCode.getCode();
		this.errorMessage = errCode.getMsg();
		this.resultStatus = false;
	}
	
}
