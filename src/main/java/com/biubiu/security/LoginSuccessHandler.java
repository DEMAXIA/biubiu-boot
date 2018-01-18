package com.biubiu.security;

import com.biubiu.domain.entity.sys.SysUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author tangjingxiang
 * @date 20180117
 * @desc 登录成功辅助类
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        SysUser userDetails = (SysUser) authentication.getPrincipal();
        /* Set<SysRole> roles = userDetails.getSysRoles();*/
        //输出登录提示信息
        logger.info("用户 " + userDetails.getName() + " 登录成功! 登录IP:" + getIpAddress(request));

        super.onAuthenticationSuccess(request, response, authentication);
    }


    /**
     * 获取请求IP
     *
     * @param request
     * @return
     */
    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if ("".equals(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if ("".equals(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ("".equals(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if ("".equals(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if ("".equals(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
