package com.pc.myblog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pc.myblog.Enum.LoginType;
import com.pc.myblog.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 自定义登录成功处理器
 * @Author zhouzixiang
 * @Date 2019/3/4 21:46
 **/
@Component
public class BlogAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    final Logger logger = LoggerFactory.getLogger(BlogAuthenticationSuccessHandler.class);
    private RequestCache requestCache = new HttpSessionRequestCache();
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    SecurityProperties securityProperties;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (LoginType.REDIRECT.toString().equals(securityProperties.getLoginType())) {

            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest == null) {
                String successRedirect = securityProperties.getSuccessRedirect();
                logger.info("登录成功 正在跳转...."+successRedirect);
                response.sendRedirect(successRedirect);
            } else {
                logger.info(savedRequest.getRedirectUrl());
                super.onAuthenticationSuccess(request, response, authentication);
            }
        } else if (LoginType.JSON.toString().equals(securityProperties.getLoginType())) {
            response.setContentType("application/json");
            logger.info("登录成功 响应客户端....");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(mapper.writeValueAsString(authentication.getPrincipal()));
        }
    }
}
