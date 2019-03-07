package com.pc.myblog.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/3/5 10:24
 **/
@ConfigurationProperties(prefix = "security")
@PropertySource(value = "classpath:/config/SecurityProperties.properties",encoding = "GBK")
@Component
public class SecurityProperties {
    private String successRedirect;
    private String failRedirect;
    private String loginType;

    public String getSuccessRedirect() {
        return successRedirect;
    }

    public void setSuccessRedirect(String successRedirect) {
        this.successRedirect = successRedirect;
    }

    public String getFailRedirect() {
        return failRedirect;
    }

    public void setFailRedirect(String failRedirect) {
        this.failRedirect = failRedirect;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
