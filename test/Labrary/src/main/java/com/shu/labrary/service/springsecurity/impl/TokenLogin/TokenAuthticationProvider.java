package com.shu.labrary.service.springsecurity.impl.TokenLogin;

import com.shu.labrary.service.springsecurity.impl.MyUserDetailService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class TokenAuthticationProvider implements AuthenticationProvider {
    private MyUserDetailService myUserDetailService=new MyUserDetailService();

    public MyUserDetailService getMyUserDetailService() {
        return myUserDetailService;
    }
    public void setMyUserDetailService(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthenticationToken tokenAuthenticationToken= (TokenAuthenticationToken) authentication;
        UserDetails user = myUserDetailService.loadUserByUsername((String) tokenAuthenticationToken.getPrincipal());
        if (user==null)
        {
            throw new InternalAuthenticationServiceException("用户信息有误！");
        }
        TokenAuthenticationToken tokenAuthenticationTokenResult=new TokenAuthenticationToken(user,user.getAuthorities());
        tokenAuthenticationTokenResult.setDetails(tokenAuthenticationToken.getDetails());
        return tokenAuthenticationTokenResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
