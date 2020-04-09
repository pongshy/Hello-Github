package com.shu.labrary.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Notice {
    private Integer noticeid;

    private String content;

    private Date timestamp;


}