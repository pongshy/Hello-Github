package com.shu.labrary.mapper;

import com.shu.labrary.pojo.Appointmenttime;
import com.shu.labrary.pojo.AppointmenttimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppointmenttimeMapper {
    int countByExample(AppointmenttimeExample example);

    int deleteByExample(AppointmenttimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Appointmenttime record);

    int insertSelective(Appointmenttime record);

    List<Appointmenttime> selectByExample(AppointmenttimeExample example);

    Appointmenttime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Appointmenttime record, @Param("example") AppointmenttimeExample example);

    int updateByExample(@Param("record") Appointmenttime record, @Param("example") AppointmenttimeExample example);

    int updateByPrimaryKeySelective(Appointmenttime record);

    int updateByPrimaryKey(Appointmenttime record);
}