package com.shu.labrary.pojo.response;

import com.shu.labrary.tools.DateUtils;

import java.util.Date;

/**
 * program: TeacherTimeVO
 * description: 专门用于存储教师设置的预约时间，拆分版
 * author: pongshy
 * create: 2020-2-3
 */
public class TeacherTimeVO {
    private Integer id;

    private String startTime;

    private String endTime;

    private Integer occupy;

    public void setStart(Date start) {
        startTime = DateUtils.DatetoStr(start);
    }

    public void setEnd(Date end) {
        endTime = DateUtils.DatetoStr(end);
    }


    public Integer getOccupy() {
        return occupy;
    }

    public void setOccupy(Integer occupy) {
        this.occupy = occupy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
