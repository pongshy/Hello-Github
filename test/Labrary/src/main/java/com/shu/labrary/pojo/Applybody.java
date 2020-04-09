package com.shu.labrary.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Applybody {
    private Integer requestid;

    private String adminid;

    private Date begintime;

    private Date endtime;

    private String requestreason;

    private Integer teacherid;

    private Integer applystatus;

    private Date timestamp;

    private Integer totalpersonnum;

    private String refusereason;

    private Integer essayid;


}