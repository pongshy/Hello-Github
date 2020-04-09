package com.shu.labrary.pojo.response;

import com.shu.labrary.pojo.Appointmenttime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * program: ShowTeacherMessageVO
 * description: 首页显示明星教师信息
 * author: pongshy
 * create: 2020-1-19
 */
public class ShowTeacherMessageVO {
    private Integer teacherId;

    private String teachername;

    private String imagesrc;

    private String description;

    private Integer online;

    private String building;

    private String campus;

    private String housenumber;

    private String satisfaction;

    private Boolean free;

    private List<TeacherTimeVO> timeList;

    private String job;

    private String phone;

    private String email;

    private Boolean reservestatus;

    private Integer department1id;

    private String major;

    private String helpintention;

    private String academy;

    private String organization;

    private String introductions;


    public String getIntroductions() {
        return introductions;
    }

    public void setIntroductions(String introductions) {
        this.introductions = introductions;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setAppointmentTimeList(List<Appointmenttime> list) {
        timeList = new ArrayList<>();
        if (list == null) {
            timeList = null;
            return;
        }
        for (Appointmenttime appoinmenttime : list) {
            TeacherTimeVO teacherTimeVO = new TeacherTimeVO();
            teacherTimeVO.setStart(appoinmenttime.getStarttime());
            teacherTimeVO.setEnd(appoinmenttime.getEndtime());
            teacherTimeVO.setId(appoinmenttime.getId());
            teacherTimeVO.setOccupy(appoinmenttime.getOccupy());

            timeList.add(teacherTimeVO);
        }
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getReservestatus() {
        return reservestatus;
    }

    public void setReservestatus(Boolean reservestatus) {
        this.reservestatus = reservestatus;
    }

    public Integer getDepartment1id() {
        return department1id;
    }

    public void setDepartment1id(Integer department1id) {
        this.department1id = department1id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getHelpintention() {
        return helpintention;
    }

    public void setHelpintention(String helpintention) {
        this.helpintention = helpintention;
    }

    public List<TeacherTimeVO> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<TeacherTimeVO> timeList) {
        this.timeList = timeList;
    }
}
