package com.biubiu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;


/**
 * @author tangjingxiang
 * @date 20180117
 * @desc 生成securityMetadataSource拦截器
 */

@Service
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {


    @Autowired
    private MyInvocationSecurityMetadataSourceService myInvocationSecurityMetadataSourceService;

    @Autowired
    private MyAccessDecisionManager myAccessDecisionManager;

//    @Autowired
//    private AuthenticationManager authenticationManager;


    @PostConstruct
    public void init(){
//        super.setAuthenticationManager(authenticationManager);
        super.setAccessDecisionManager(myAccessDecisionManager);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("filter===========================");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(request, response, filterChain);
        invoke(fi);
    }

    @Override
    public void destroy() {
        logger.info("------>filter end");
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.myInvocationSecurityMetadataSourceService;
    }


    private void invoke(FilterInvocation fi) throws IOException, ServletException {
        //fi里面有一个被拦截的url
        //里面调用MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取fi对应的所有权限
        //再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }
}
