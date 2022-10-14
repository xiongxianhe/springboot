/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/14 16:54
 * Desc:
 */
package org.example.controller;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DefExceptionHandle {
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest req, RuntimeException e) {
        return "运行时异常: " + e.getMessage();
    }

    /**
     * 处理空指针的异常
     *
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest req, NullPointerException e) {
        return "处理空指针的异常: " + e.getMessage();
    }

    /**
     * 处理请求方法不支持的异常
     *
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest req, HttpRequestMethodNotSupportedException e) {
        return "理请求方法不支持的异常: " + e.getMessage();
    }

    /**
     * 处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest req, Exception e) {
        return "处理其他异常: " + e.getMessage();
    }


    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest req, ArithmeticException e) {
        return "运算异常: " + e.getMessage();
    }
}
