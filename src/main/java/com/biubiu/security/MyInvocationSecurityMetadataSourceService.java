package com.biubiu.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.biubiu.domain.entity.sys.SysResource;
import com.biubiu.domain.entity.sys.SysRole;
import com.biubiu.service.sys.SysResourceService;
import com.biubiu.service.sys.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * @author tangjingxiang
 * @date 20180117
 * @desc
 */

@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {


    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private SysRoleService sysRoleService;

    private static Map<String, Collection<ConfigAttribute>> resourceMap;

    /**
     * 根据URL，找到相关的权限配置
     *
     * @param object 用户请求的url
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (resourceMap == null) {
            loadResourceDefine();
        }
        FilterInvocation filterInvocation = (FilterInvocation) object;
        AntPathRequestMatcher matcher;
        String resourceAction;
        Iterator<String> iter = resourceMap.keySet().iterator();
        while (iter.hasNext()){
            resourceAction = iter.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resourceAction);
            if(requestMatcher.matches(filterInvocation.getHttpRequest())) {
                return resourceMap.get(resourceAction);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


    /**
     * 加载资源对应的角色权限列表
     */
    @PostConstruct
    private void loadResourceDefine() {
        resourceMap = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        //查询出所有资源
        List<SysResource> sysResources = sysResourceService.selectList(new EntityWrapper<SysResource>().where("enable={0}", 1));
        for (SysResource sysResource : sysResources) {
            array = new ArrayList<>();
            //查询出资源对应的角色权限
            List<SysRole> sysRoles = sysRoleService.selectRolesByResourceId(sysResource.getId());
            for (SysRole sysRole : sysRoles){
                cfg = new SecurityConfig(sysRole.getText());
                array.add(cfg);
            }

            resourceMap.put(sysResource.getAction(), array);
        }

    }


}
