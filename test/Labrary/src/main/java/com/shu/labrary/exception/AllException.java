package com.shu.labrary.exception;

/**
 * @description: 错误操作
 * @author: pongshy
 * @create: 2020-1-15 20:47
 */
public class AllException extends Exception {

    private EmAllException emAllException;

    // 直接接收EmSqlException的传参用于构造业务异常
    public AllException(EmAllException emAllException) {
        super();
        this.emAllException = emAllException;

    }

    public EmAllException getEmAllException() {
        return emAllException;
    }

    public void setEmAllException(EmAllException emAllException) {
        this.emAllException = emAllException;
    }
}
