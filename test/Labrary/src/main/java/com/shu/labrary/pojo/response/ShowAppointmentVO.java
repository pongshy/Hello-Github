package com.shu.labrary.pojo.response;

import com.shu.labrary.pojo.Appointmenttime;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * program: ShowAppointmentVO
 * description: 用户界面展示预约情况
 * author: pongshy
 * create: 2020-1-31
 */
@Data
public class ShowAppointmentVO {
    private Integer requestid;

    private String adminid;

    private String beginTime;

    private String endTime;

    private String requestreason;

    private Integer teacherid;

    private Integer applystatus;

    private String timeStamp;

    private Integer totalpersonnum;

    private String teachername;

    private String organization;

    private Integer online;

    private String campus;

    private String building;

    private String housenumber;

    private String helpintention;

    private String satisfaction;

    private String phone;

    private String academy;

    private String job;

    private String imagesrc;

    private String description;

    private String email;

    private List<TeacherTimeVO> timeList;

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

}
