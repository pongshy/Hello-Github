package com.shu.labrary.pojo;

import java.util.Date;

public class Finishedapplyment {
    private Integer requestid;

    private String adminid;

    private Date begintime;

    private Date endtime;

    private Date finishtime;

    private String requestreason;

    private Integer teacherid;

    private Integer applystatus;

    private Date timestamp;

    private Integer totalpersonnum;

    public Integer getRequestid() {
        return requestid;
    }

    public void setRequestid(Integer requestid) {
        this.requestid = requestid;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid == null ? null : adminid.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public String getRequestreason() {
        return requestreason;
    }

    public void setRequestreason(String requestreason) {
        this.requestreason = requestreason == null ? null : requestreason.trim();
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(Integer applystatus) {
        this.applystatus = applystatus;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getTotalpersonnum() {
        return totalpersonnum;
    }

    public void setTotalpersonnum(Integer totalpersonnum) {
        this.totalpersonnum = totalpersonnum;
    }
}