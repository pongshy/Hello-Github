package com.shu.labrary.pojo.response;

import com.shu.labrary.pojo.Appointmenttime;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * program: ShowStudentTeacherVo
 * description: 小老师预约页面，根据姓名返回教师信息
 * author: pongshy
 * create: 2020-3-9
 */
@Data
public class ShowStudentTeacherVO {
    private Integer stteacherid;

    private String stteachername;

    private String duty;

    private String academy;

    private String helpintention;

    private String building;

    private String imagesrc;

    private String description;

    private String organization;

    private String campus;

    private Integer ordernumber;

    private String satisfaction;

    private Boolean reservestatus;

    private String email;

    private String phone;

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
