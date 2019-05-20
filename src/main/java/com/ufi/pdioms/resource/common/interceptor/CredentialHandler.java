package com.ufi.pdioms.resource.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * CredentialHandler(授权凭证校验)
 * 
 * @author caiwenhao
 * @date 2018年3月15日 上午10:28:32 
 * @version  [1.0, 2018年3月15日]
 * @since  version 1.0
 * @see [相关类/方法]
 */
public class CredentialHandler extends HandlerInterceptorAdapter
{

    private static final Logger LOGGER = LoggerFactory.getLogger(CredentialHandler.class);
    
    private static final List<String> ignorePath = new ArrayList<String>(); // 不需要鉴权的路径
    
    public CredentialHandler()
    {
        ignorePath.add("/error");
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception
    {
        String reqPath = request.getRequestURI();
        String queryString = request.getQueryString();
        String userAgent = request.getHeader("User-Agent");
        LOGGER.info("userAgent:{}, reqPath:{}, queryString: {}", userAgent, reqPath, queryString);
        
        return true;
    }

//    public void setSessionBind(String sessionBind)
//    {
//        this.sessionBind = sessionBind;
//    }
    
}
