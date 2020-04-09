package com.shu.labrary.service.springsecurity.impl.TokenLogin;

import com.shu.labrary.service.springsecurity.impl.MyAuthenticationFaiureHandler;
import com.shu.labrary.service.springsecurity.impl.imageCodeException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenLoginFilter extends OncePerRequestFilter {
    private MyAuthenticationFaiureHandler myAuthenticationFaiureHandler=new MyAuthenticationFaiureHandler();

    public MyAuthenticationFaiureHandler getMyAuthenticationFaiureHandler() {
        return myAuthenticationFaiureHandler;
    }

    public void setMyAuthenticationFaiureHandler(MyAuthenticationFaiureHandler myAuthenticationFaiureHandler) {
        this.myAuthenticationFaiureHandler = myAuthenticationFaiureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
          if (request.getRequestURI().contains("/loginWithoutKey"))
          {
              try{
                  //获取统一认证后传过来的token
                  String tokens = request.getHeader("teken");
                  String username="19721631";
                  String password="aaa";
                  if (username.length()!=8)
                  {
                      throw new imageCodeException("用户信息有误");
                  }
                  if (username.equals("数据库中没有该用户"))
                  {
                      System.out.println("此处填写增加用户的代码");
                  }
              }catch (AuthenticationException e)
              {
                  myAuthenticationFaiureHandler.onAuthenticationFailure(request,response,e);
                  return;
              }
          }
          filterChain.doFilter(request,response);
    }
}

