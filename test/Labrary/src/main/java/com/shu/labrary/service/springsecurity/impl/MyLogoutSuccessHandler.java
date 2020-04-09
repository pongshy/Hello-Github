package com.shu.labrary.service.springsecurity.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.labrary.tools.TableModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        TableModel tableModel=new TableModel();
        tableModel.setCode(406);
        tableModel.setMsg("登出成功");
        String json = objectMapper.writeValueAsString(tableModel);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
