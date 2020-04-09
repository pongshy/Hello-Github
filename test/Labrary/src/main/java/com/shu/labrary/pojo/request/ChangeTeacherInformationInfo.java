package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * program: ChangeTeacherInformationInfo
 * description: 教师修改个人信息
 * author: pongshy
 * create: 2020-1-31
 */
@Data
public class ChangeTeacherInformationInfo {
    @NotNull(message = "teacherId不能为空")
    private Integer teacherId;

    private String email;

    private String phone;

    private Boolean free;

    private String helpintention;

    private String campus;

    private String building;

    private String housenumber;

    private String job;

    private String organization;

    private Integer online;

    private String description;

    private String imagesrc;

    private String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getHelpintention() {
        return helpintention;
    }

    public void setHelpintention(String helpintention) {
        this.helpintention = helpintention;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }
}
