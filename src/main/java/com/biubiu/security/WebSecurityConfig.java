package com.biubiu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


/**
 * @author tangjingxiang
 * @date 20180117
 * @desc spring security 配置类
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private MyFilterSecurityInterceptor mySecurityFilter;

    /**
     * 授权请求
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(mySecurityFilter, FilterSecurityInterceptor.class)
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?err").permitAll()
                .successHandler(loginSuccessHandler())
                .and().logout().logoutSuccessUrl("/login").permitAll()
                .invalidateHttpSession(true)
                .and()
                //登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
                .rememberMe()
                .tokenValiditySeconds(1209600);
    }


    /**
     * 认证配置
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //指定密码加密所使用的加密器为passwordEncoder()
        //需要将密码加密后写入数据库
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);


    }


    /**
     * 密码加密方式
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }


    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

}
