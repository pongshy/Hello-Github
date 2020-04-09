package com.shu.labrary.service.springsecurity.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.labrary.tools.TableModel;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EntryPoint implements AuthenticationEntryPoint {
    ObjectMapper objectMapper=new ObjectMapper();
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
       response.setStatus(405);
    }
}
