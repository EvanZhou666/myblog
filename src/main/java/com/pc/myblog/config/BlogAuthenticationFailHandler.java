package com.pc.myblog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pc.myblog.Enum.LoginType;
import com.pc.myblog.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 自定义登录失败处理器
 * @Author zhouzixiang
 * @Date 2019/3/4 23:07
 **/
@Component
public class BlogAuthenticationFailHandler implements AuthenticationFailureHandler {
    final Logger logger = LoggerFactory.getLogger("登录失败处理器:");
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    SecurityProperties securityProperties;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (LoginType.REDIRECT.toString().equals(securityProperties.getLoginType())) {
            String failRedirect = securityProperties.getFailRedirect();
            logger.info("跳转"+failRedirect);
            response.sendRedirect(failRedirect);
        } else if (LoginType.JSON.toString().equals(securityProperties.getLoginType())) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(mapper.writeValueAsString(exception));
        }
    }
}
