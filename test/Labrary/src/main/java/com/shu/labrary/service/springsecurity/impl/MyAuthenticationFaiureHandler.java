package com.shu.labrary.service.springsecurity.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.labrary.tools.TableModel;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyAuthenticationFaiureHandler implements AuthenticationFailureHandler {

   ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

     response.setStatus(405);
    }
}
