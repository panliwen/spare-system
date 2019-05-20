package com.ufi.pdioms.resource.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cross-Origin Resource Sharing跨源资源共享 过滤器 允许前台页面通过ajax或者angualr直接访问
 *
 */
@Component
public class CorsFilter implements Filter
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CorsFilter.class);
    
//    @Value("http://template.30days-tech.com}")
//    private String pageHome;
    
    @Override
    public void init(FilterConfig filterConfig)
        throws ServletException
    {
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException
    {
        HttpServletResponse response = (HttpServletResponse) res;
        
        // 允许的访问域，允许全部则为*，允许部分则配置详细的http地址，端口后不能有/
        response.setHeader("Access-Control-Allow-Origin", "*");
        
        // 访问授权有效期 为一周，单位为秒
        response.setHeader("Access-Control-Max-Age", "604800");
        
        // 默认只允许GET、POST请求，需要将PUT和DELETE也加入此列
        response.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,PUT,DELETE");
        
        // 允许自定义 header accessToken
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin, Accept, Content-Type, X-HTTP-Method, X-HTTP-METHOD-OVERRIDE,XRequestedWith,X-Requested-With,xhr,custom-enterpriseId,x-clientappversion, x-wxopenid, x-devicetype");
        
        response.setHeader("Access-Control-Allow-Credentials", "true");
        
        chain.doFilter(req, res);
        
        LOGGER.debug("do filter");
    }
    
    @Override
    public void destroy()
    {
    }
    
}
