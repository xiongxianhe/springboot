/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/15 19:56
 * Desc:
 */
package org.example.frame.interceptor;

import org.example.entity.User;
import org.example.frame.exception.JDZException;
import org.example.frame.util.RtCode;
import org.example.frame.util.TokenBuilder;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserService userService;

    public MyInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("==========preHandle================");

        // 从 http header 中获取 token
        String token = request.getHeader("x-token");
        if(token == null) { // 判断是否有 token 如果没有则抛出异常，终止运行
            throw new JDZException(RtCode.ERR_NEED_TOKEN);
        }

        // 解析 token
        TokenBuilder tokenBuilder = new TokenBuilder();
        RtCode rtCode = tokenBuilder.parse(token);
        if(rtCode != RtCode.SUCCESS) { // token 解析失败
            throw new JDZException(rtCode);
        }
        // token 解析成功，继续往下执行

        User user = userService.getInfo(tokenBuilder.getUid());
        if(user == null) { // 用户不在数据库中
            throw new JDZException(RtCode.ERR_USER_NOT_EXIST);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("==========postHandle================");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("==========afterCompletion================");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
