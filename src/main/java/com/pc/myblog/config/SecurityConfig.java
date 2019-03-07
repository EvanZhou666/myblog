package com.pc.myblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * SpringSecurity 大致原理：
 * AbstractAuthenticationProcessingFilter
 *      UsernamePasswordAuthenticationFilter 将表单输入的用户名密码封装为authRequest请求。将认证请求交给（认证管理器）提供商ProviderManager处理
 *      提供商将请求委托给ProviderManager们 ，进行真正的认证请求处理
 *      1、匿名认证提供商
 *      2、数据库认证提供商 DaoAuthenticationProvider  调用父类AbstractUserDetailsAuthenticationProvider认证处理
 *            loadedUser = this.getUserDetailsService().loadUserByUsername(username); 如果找不到 抛出异常，如果找到
 *            构建authentication对象，并擦出敏感数据，最后利用Spring事件机制，发布事件 eventPublisher.publishAuthenticationSuccess(result);
 *
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BlogAuthenticationSuccessHandler blogAuthenticationSuccessHandler;
    @Autowired
    BlogAuthenticationFailHandler blogAuthenticationFailHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //暂且先关闭
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(blogAuthenticationSuccessHandler)
                .failureHandler(blogAuthenticationFailHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /**
     * 自定义一组用户名/密码 保存在内存中  方便开发调试
     * @param
     * @throws Exception
     */
/*   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("1@163.com").password("1").roles("USER");
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/assets/**")
                .antMatchers("/images/**")
                .antMatchers("/error/**");
    }

   /* @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
