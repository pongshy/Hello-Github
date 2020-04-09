package com.shu.labrary.pojo.SsmPojo;

import lombok.Data;

import java.util.Date;

@Data
public class SmsCodePojo {
    private String smsCode;
    private Date sendDate;

    public SmsCodePojo(String smsCode) {
        this.smsCode = smsCode;
        sendDate=new Date();
    }


}
