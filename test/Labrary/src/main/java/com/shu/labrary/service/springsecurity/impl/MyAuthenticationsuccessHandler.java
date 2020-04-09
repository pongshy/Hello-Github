package com.shu.labrary.service.springsecurity.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.labrary.tools.TableModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAuthenticationsuccessHandler implements AuthenticationSuccessHandler {
    private ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String username = authentication.getName();
        List authorities = (List) authentication.getAuthorities();
        TableModel tableModel=new TableModel();
        tableModel.setData(authorities);
        tableModel.setMsg(username);
        System.out.println("success");
        response.setStatus(200);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(tableModel));

    }
}
