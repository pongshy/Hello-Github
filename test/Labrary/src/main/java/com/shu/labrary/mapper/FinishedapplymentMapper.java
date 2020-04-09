package com.shu.labrary.mapper;

import com.shu.labrary.pojo.Finishedapplyment;
import com.shu.labrary.pojo.FinishedapplymentExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FinishedapplymentMapper {
    int countByExample(FinishedapplymentExample example);

    int deleteByExample(FinishedapplymentExample example);

    int deleteByPrimaryKey(Integer requestid);

    int insert(Finishedapplyment record);

    int insertSelective(Finishedapplyment record);

    List<Finishedapplyment> selectByExample(FinishedapplymentExample example);

    Finishedapplyment selectByPrimaryKey(Integer requestid);

    int updateByExampleSelective(@Param("record") Finishedapplyment record, @Param("example") FinishedapplymentExample example);

    int updateByExample(@Param("record") Finishedapplyment record, @Param("example") FinishedapplymentExample example);

    int updateByPrimaryKeySelective(Finishedapplyment record);

    int updateByPrimaryKey(Finishedapplyment record);

    List<Map> selectfinishAppointmentByDate(Date newstartdate, Date newenddate);
}