package com.ufi.pdioms.resource.common.interceptor;

import com.ufi.pdioms.resource.common.model.GeneralResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@ControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    public static final String DEFAULT_ERROR_VIEW = "error";
    

    
    @Value("panLiWen")
    private String appName;
    
    /**
     * handleMethodArgumentNotValidException(处理所有接口数据验证异常)
     * 
     * @param e
     * @return
     * @return GeneralResult 返回类型
     * @author caiwenhao
     * @date 2018年5月18日 上午10:20:57
     * @version [1.0, 2018年5月18日]
     * @since version 1.0
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public GeneralResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        
        GeneralResult response = new GeneralResult();
        StringBuilder errorMessage = new StringBuilder();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        int size = errors.size();
        for (int i = 0; i < size; i++)
        {
            errorMessage.append(errors.get(i).getDefaultMessage());
            if (i < size - 1)
            {
                errorMessage.append(";");
            }
        }

        response.setErrorMessage(errorMessage.toString());
        return response;
    }
    
    
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public GeneralResult handleConstraintViolationException(ConstraintViolationException e)
    {
        Set<ConstraintViolation<?>> constraints = e.getConstraintViolations();
        GeneralResult response = new GeneralResult();
        StringBuilder errorMessage = new StringBuilder();
        for (Iterator<ConstraintViolation<?>> iterator = constraints.iterator(); iterator.hasNext();)
        {
            ConstraintViolation<?> constraintViolation = iterator.next();
            errorMessage.append(constraintViolation.getMessage());
            if (iterator.hasNext())
            {
                errorMessage.append(";");
            }
        }

        response.setErrorMessage(errorMessage.toString());
        return response;
    }
    
    
    /**
     * defaultErrorHandler(处理其他所有异常) 若需要单独捕获某个异常，可参考spring的@EcxceptionHandler注解相关文档
     * 
     * @param req
     * @param e
     * @return
     * @return GeneralResult 返回类型
     * @author caiwenhao
     * @date 2018年5月18日 上午10:20:49
     * @version [1.0, 2018年5月18日]
     * @since version 1.0
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public GeneralResult defaultErrorHandler(HttpServletRequest req, Exception e)
    {
        LOGGER.error("req path =>{}, exception detail =>{}",
            (req.getRequestURI() + (null == req.getQueryString() ? "" : "?" + req.getQueryString())),
            e);
        
        if (e instanceof ServletRequestBindingException || e instanceof MissingServletRequestParameterException
            || e instanceof HttpMessageNotReadableException || e instanceof MethodArgumentNotValidException
            || e instanceof TypeMismatchException)
        {
            return new GeneralResult(false, HttpStatus.BAD_REQUEST.value() + "", e.getMessage());
        }
        

        
        return new GeneralResult(false, HttpStatus.INTERNAL_SERVER_ERROR.value() + "",
            "The server is busy. Please try again later.");
    }
    
}
