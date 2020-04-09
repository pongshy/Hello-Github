package com.shu.labrary.exception;

/**
 * @description: 报错枚举
 * @author: pongshy
 * @create: 2020-1-15
 */
public enum EmAllException {
    NO_LOGIN_AUTHORIZATION(403, "没有登录权限"),

    IDENTITY_ERROR(403, "没有权限"),

    LOGIN_VERIFICATION_ERROR(500, "上海大学登录接口出现异常"),

    USER_AND_PASSWORD_ERROR(400, "输入密码账号或者密码错误"),

    TOKEN_PHASE_ERROR(500, "解析token出错"),

    ENCODE_ERROR(500, "token编码错误"),

    BAD_REQUEST(400, "请求参数格式有误"),

    BAD_FILE_TYPE(400, "文件格式错误"),

    UNIFY_ERROR(400, "请保证Excel表格格式无误"),

    USER_AND_PASSWORD_BLANK_ERROR(400, "账号或密码不能为空"),

    QUERY_TIME_OUT(500, "请求超时，请确定您是否使用校园网登录"),

    INSERT_ERROR(500, "插入数据失败"),

    CARD_NUMBER_ERROR(400, "一卡通账号或工号无效"),

    DATABASE_ERROR(500, "数据库异常或数据有误");

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //错误码
    private Integer code;

    //错误信息
    private String msg;

    EmAllException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    @Override
    public String toString() {
        return "EmAllException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
