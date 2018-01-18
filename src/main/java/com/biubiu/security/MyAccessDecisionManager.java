package com.biubiu.security;


import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;


/**
 * @author tangjingxiang
 * @date 20180117
 * @desc 自定义决策管理器
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {


    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if (configAttributes == null || configAttributes.size() <= 0) {
            return;
        }

        ConfigAttribute ca;
        String needRole;
        Iterator<ConfigAttribute> iter = configAttributes.iterator();

        while (iter.hasNext()) {
            ca = iter.next();
            needRole = ca.getAttribute();
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needRole.trim().equals(ga.getAuthority())) {
                    return;
                }
            }
        }

        throw new AccessDeniedException("权限不足！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
