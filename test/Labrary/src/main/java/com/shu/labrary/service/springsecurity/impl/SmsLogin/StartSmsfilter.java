package com.shu.labrary.service.springsecurity.impl.SmsLogin;

import com.shu.labrary.service.springsecurity.impl.imageCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartSmsfilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler;

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }


    private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().contains("/smslogin"))
        {
            try {
                //获取用户输入的验证码
                String inputcode= ServletRequestUtils.getStringParameter(new ServletWebRequest(request).getRequest() ,"password");

                //获取生成的验证码

                if (!"Yanglao123".equals(inputcode.trim()))
                {
                    throw new imageCodeException("验证码不正确");
                }
                if (StringUtils.isEmpty(inputcode))
                {
                    throw new imageCodeException("验证码不能为空");
                }
            }catch (AuthenticationException e)
            {
                authenticationFailureHandler.onAuthenticationFailure(request,response,e);
                return;
            }


        }
        filterChain.doFilter(request,response);
    }

}
