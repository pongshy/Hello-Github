package com.shu.labrary.service.springsecurity.impl;

import org.springframework.security.core.AuthenticationException;

public class imageCodeException extends AuthenticationException {
    public imageCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public imageCodeException(String msg) {
        super(msg);
    }
}
