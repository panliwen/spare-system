package com.ufi.pdioms.resource.common.spring;


import com.ufi.pdioms.resource.common.exception.EncryptException;
import com.ufi.pdioms.resource.utils.encrypt.AESUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class DecryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer
{

	/** 
	 * 重写父类方法，解密指定属性名对应的属性值 
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue)
	{
		if (isEncryptPropertyVal(propertyName))
		{
			String decryptPropValue = null;
			// 调用解密方法
			try {
				decryptPropValue = AESUtils.decrypt(propertyValue);
			} catch (EncryptException e) {
				e.printStackTrace();
			}

			return decryptPropValue;
		}
		else
		{
			return propertyValue;
		}
	}

	/** 
	 * 判断属性值是否需要解密，这里我约定需要解密的属性名用encrypt开头 
	 * @param propertyName 
	 * @return 
	 */
	private boolean isEncryptPropertyVal(String propertyName)
	{
		if (propertyName.startsWith("encrypt"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
