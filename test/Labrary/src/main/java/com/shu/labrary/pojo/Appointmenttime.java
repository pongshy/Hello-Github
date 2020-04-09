package com.shu.labrary.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Appointmenttime {
    private Integer id;

    private Date starttime;

    private Date endtime;

    private Integer teacherid;

    private Integer occupy;


}