package com.ufi.pdioms.resource.utils.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Utils
{
    private static final String DIGEST_TYPE = "MD5";
    
    private static final String DEFAULT_CHARSET = "UTF-8";
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Utils.class);
    
    private MD5Utils()
    {
    
    }
    
    public static String getMD5Digest(String message, String charset)
    {
        String digestResult = null;
        
        try
        {
            MessageDigest md5 = MessageDigest.getInstance(DIGEST_TYPE);
            
            byte[] temp;
            // 使用指定的 byte 数组对摘要进行最后更新，然后完成摘要计算
            temp = md5.digest(message.getBytes(charset));
            
            digestResult = HexByte.parseByte2HexStr(temp);
            
        }
        catch (NoSuchAlgorithmException e)
        {
            LOGGER.error("Failed to get md5 instance!", e);
        }
        catch (UnsupportedEncodingException e)
        {
            LOGGER.error("Failed to encode utf-8 instance!", e);
        }
        
        return digestResult;
    }
    
    /**
     * 
     * 获取MD5加密后的的摘要信息<br>
     *
     * @param message
     * @param digestKey
     * @return String
     * @Author fanyaowu
     * @data 2014年7月23日
     * @exception @version
     *               
     */
    public static String getMD5Digest(String message)
    {
        
        return getMD5Digest(message, DEFAULT_CHARSET);
    }
    
    /**
     * Calculate content MD5 header values for feeds stored on disk.
     */
    public static String computeContentMD5HeaderValue(FileInputStream fis)
        throws IOException, NoSuchAlgorithmException
    {
        
        DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));
        
        byte[] buffer = new byte[8192];
        while (dis.read(buffer) > 0)
            ;
            
        String md5Content =
            new String(org.apache.commons.codec.binary.Base64.encodeBase64(dis.getMessageDigest().digest()));
            
        // Effectively resets the stream to be beginning of the file
        // via a FileChannel.
        fis.getChannel().position(0);
        
        return md5Content;
    }
}
