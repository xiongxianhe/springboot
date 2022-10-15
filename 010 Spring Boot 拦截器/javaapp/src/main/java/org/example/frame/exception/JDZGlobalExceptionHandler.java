/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/13 21:46
 * Desc:
 */
package org.example.frame.exception;

import org.example.frame.controller.BaseController;
import org.example.frame.util.RtCode;
import org.example.frame.util.RtData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class JDZGlobalExceptionHandler extends BaseController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public RtData<String> exceptionHandler(HttpServletRequest req, RuntimeException e) {
        logger.warn(e.getMessage() + " " + e.getStackTrace()[0].toString());
        return new RtData<String>(RtCode.ERR_INNER);
    }

    /**
     * 处理空指针的异常
     *
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public RtData<String> exceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.warn(e.getMessage() + " " + e.getStackTrace()[0].toString());
        return new RtData<String>(RtCode.ERR_ACCESS);
    }

    /**
     * 处理请求方法不支持的异常
     *
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public RtData<String> exceptionHandler(HttpServletRequest req, HttpRequestMethodNotSupportedException e) {
        logger.warn(e.getMessage() + " " + e.getStackTrace()[0].toString());
        return new RtData<String>(RtCode.ERR_NOT_USE);
    }

    /**
     * 处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RtData<String> exceptionHandler(HttpServletRequest req, Exception e) {
        logger.warn(e.getMessage() + " " + e.getStackTrace()[0].toString());
        return new RtData<String>(RtCode.ERR_ACCESS);
    }


    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public RtData<String> exceptionHandler(HttpServletRequest req, ArithmeticException e) {
        logger.warn(e.getMessage() + " " + e.getStackTrace()[0].toString());
        return new RtData<String>(RtCode.ERR_ACCESS);
    }

    @ExceptionHandler(value = JDZException.class)
    @ResponseBody
    public RtData<String> exceptionHandler(HttpServletRequest req, JDZException e) {
        return new RtData<String>(e.getRtCode());
    }
}
