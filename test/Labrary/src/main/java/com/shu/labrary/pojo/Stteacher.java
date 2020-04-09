package com.shu.labrary.pojo;

public class Stteacher {
    private Integer stteacherid;

    private String stteachername;

    private String duty;

    private Integer departmentid;

    private String helpintention;

    private String building;

    private String imagesrc;

    private String description;

    private String organization;

    private String campus;

    private Integer ordernumber;

    private String satisfaction;

    private Boolean reservestatus;

    public Integer getStteacherid() {
        return stteacherid;
    }

    public void setStteacherid(Integer stteacherid) {
        this.stteacherid = stteacherid;
    }

    public String getStteachername() {
        return stteachername;
    }

    public void setStteachername(String stteachername) {
        this.stteachername = stteachername == null ? null : stteachername.trim();
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

    public String getHelpintention() {
        return helpintention;
    }

    public void setHelpintention(String helpintention) {
        this.helpintention = helpintention == null ? null : helpintention.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc == null ? null : imagesrc.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus == null ? null : campus.trim();
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction == null ? null : satisfaction.trim();
    }

    public Boolean getReservestatus() {
        return reservestatus;
    }

    public void setReservestatus(Boolean reservestatus) {
        this.reservestatus = reservestatus;
    }
}