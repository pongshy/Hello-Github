package com.shu.labrary.mapper;

import com.shu.labrary.pojo.Applybody;
import com.shu.labrary.pojo.ApplybodyExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ApplybodyMapper {
    int countByExample(ApplybodyExample example);

    int deleteByExample(ApplybodyExample example);

    int deleteByPrimaryKey(Integer requestid);

    int insert(Applybody record);

    int insertSelective(Applybody record);

    List<Applybody> selectByExample(ApplybodyExample example);

    Applybody selectByPrimaryKey(Integer requestid);

    int updateByExampleSelective(@Param("record") Applybody record, @Param("example") ApplybodyExample example);

    int updateByExample(@Param("record") Applybody record, @Param("example") ApplybodyExample example);

    int updateByPrimaryKeySelective(Applybody record);

    int updateByPrimaryKey(Applybody record);

    List<Map> getAppointmentsin14days();

    List<Map> selectApplicationByOneTime(Date startfinalDate);

    List<Map> selectAppointsMents();

    List<Map> selectAppointmentByDate(Date startdate, Date enddate);

    List<Map> selectAppointmentByDate2(Date startdate, Date enddate);

    List<Map> selectApplicationByOneTime2(Date startfinalDate);

    List<Map> selectAppointsMents2();
}