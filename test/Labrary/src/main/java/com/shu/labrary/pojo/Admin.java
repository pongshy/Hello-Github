package com.shu.labrary.pojo;

public class Admin {
    private Integer adminid;

    private String name;

    private String auth;

    private Boolean online;

    private String duty;

    private Integer departmentid;

    private String phone;

    private String organization;

    private String password;

    private Integer brokenrecord;

    private Integer eassynumber;

    private String email;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getBrokenrecord() {
        return brokenrecord;
    }

    public void setBrokenrecord(Integer brokenrecord) {
        this.brokenrecord = brokenrecord;
    }

    public Integer getEassynumber() {
        return eassynumber;
    }

    public void setEassynumber(Integer eassynumber) {
        this.eassynumber = eassynumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}