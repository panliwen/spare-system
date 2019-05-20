package com.ufi.pdioms.resource.common.constant;

/**
 * 
 * 常用的正则表达式<br>
 * 
 * @author fanyaowu
 * @data 2014年7月13日
 * @version 1.0.0
 *
 */
public interface RegexConstant {

	
	// 匹配IP
	String IP_REGEX = "^((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|\\[1-9])(\\.((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|\\d)){3}$";
	// 匹配中文字符
	String CHINESE_CHAR_REGEX = "[\u4e00-\u9fa5]";
	
	// 匹配空白行
	String NULL_LINE_REGEX = "\\n\\s*\r";
	
	// 匹配email
	String EMAIL_REGEX = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
	
	// 匹配手机号码，必须是以1开头，长度为11位
	String PHONE_NUMBER_REGEX = "^1\\d{10}$";
	
	
}
