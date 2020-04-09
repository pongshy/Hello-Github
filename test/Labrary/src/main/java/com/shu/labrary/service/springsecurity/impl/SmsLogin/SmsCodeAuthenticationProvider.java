package com.shu.labrary.service.springsecurity.impl.SmsLogin;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
    private UserDetailsService userDetailsService;

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //校验用户信息流程
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        SmsCodeAuthenticationToken authenticationToken= (SmsCodeAuthenticationToken) authentication;

        //通过该方法从token中获得username
        UserDetails user=userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
        if (user==null)
        {
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }
        //创建一个已经认证（传两个参数代表已经认证）的token对象，将传进来的未认证信息复制进入已经认证的token中去
        SmsCodeAuthenticationToken authenticationResult=new SmsCodeAuthenticationToken(user,user.getAuthorities());
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }


    //判断是否是SmsCodeAuthenticationTaken类型的，如果是则将该token交个SmsProvider来处理
    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
