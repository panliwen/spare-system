package com.ufi.pdioms.resource.common.constant;

public interface CacheKeyPrefixConst
{
	/** 最新版本信息缓存前缀 **/
	String VERSION = "VERSION_";
	
	/** 最新审核中的版本信息 */
	String NEWEST_UNREVIEW_VERSION = "NEWEST_UNREVIEW_VERSION_";
	
	/** 最新需要强制更新版本信息缓存前缀  **/
	String FORCE_UPDATE_VERSION = "FORCEUPDATEVERSION_";
	
	/** 产品信息缓存key */
	String PRODUCT = "PRODUCT_";
	
	/** 注册使用临时缓存key前缀  */
	String REGISTER_USER = "REGISTUSER_";
	
	/** 验证码缓存key */
	String VALIDATE_CODE = "VALIDATE_CODE_";
	
	/** 注册验证码缓存key */
	String REGIST_VALIDATE_CODE = "REGIST_VALIDATE_CODE_";
	
	/** 重置密码验证码缓存key */
	String RESET_VALIDATE_CODE = "RESET_VALIDATE_CODE_";
	
    /** 改绑手机验证码缓存key */
    String REBIND_VALIDATE_CODE = "REBIND_PHONE_VALIDATE_CODE_";
	
    /**登录验证码缓存key*/
    String LOGIN_VALIDATE_CODE = "LOGIN_VALIDATE_CODE_";
	
	/** 短信一分钟内不能发送多次 */
	String SMS_MIN_LIMIT = "SMS_MIN_LIMIT_";
	
	/** 短信一个用户一天只能发一次*/
	String SMS_DAY_LIMIT = "SMS_DAY_LIMIT_";
	
	/** 重置用户密码限制 */
	String RESET_PWD_LIMIT = "RESET_PWD_LIMIT_";
	
	/** 支付了类型 */
	String PAYMENT = "PAYMENT_";
	
	/** 商家信息缓存key前缀 */
	String MERCHANT = "MERCHANT_";
	
	/** 平台管理员key前缀 */
	String MANAGER = "MANAGER_";
	
	/** 用户信息缓存key前缀 */
	String CUSTOMER = "CUSTOMER_";
	
	/** 用户缓存key前缀 */
	String USER = "USER_";
	
	/** 应用的最新环信授权token */
	String HX_SERVER_TOKEN = "HX_SERVER_TOKEN";
	
	/** 缓存key字符之间的分隔符 */
	String SPLIT_LINE = "_";
	
	/** 学校管理员key前缀*/
	String ADMIN = "ADMIN_";
	
	/** 异步任务key前缀*/
	String ASYNC_TASK = "ASYNC_TASK";
	
	/** 系统配置key前缀*/
	String SYSTEM_CONFIG = "SYSTEM_CONFIG";
	
	/** retail订单可选快递方式*/
    String RETAIL_SHIP_METHOD_SET = "RETAIL_SHIP_METHOD_SET";
    
	/** wholesale订单可选快递方式*/
	String WHOLESALE_SHIP_METHOD_SET = "WHOLESALE_SHIP_METHOD_SET";
	
	/** dropship订单可选快递方式*/
    String DROPSHIP_SHIP_METHOD_SET = "DROPSHIP_SHIP_METHOD_SET";
	
	/** 零售订单*/
	String RETAIL_ORDER = "RETAIL_ORDER";
	
	/** 零售订单发货*/
	String RETAIL_ORDER_SHIP = "RETAIL_ORDER_SHIP";
	
	/** 直销订单*/
    String DROPSHIP_ORDER = "DROPSHIP_ORDER";
    
    String DROPSHIP_ORDER_SHIP = "DROPSHIP_ORDER_SHIP";
    
    String DISTRIBUTOR_ORDER_SHIP = "DISTRIBUTOR_ORDER_SHIP";
}
