package com.shu.labrary.mapper;

import com.shu.labrary.pojo.Teacherq;
import com.shu.labrary.pojo.TeacherqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherqMapper {
    int countByExample(TeacherqExample example);

    int deleteByExample(TeacherqExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacherq record);

    int insertSelective(Teacherq record);

    List<Teacherq> selectByExample(TeacherqExample example);

    Teacherq selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacherq record, @Param("example") TeacherqExample example);

    int updateByExample(@Param("record") Teacherq record, @Param("example") TeacherqExample example);

    int updateByPrimaryKeySelective(Teacherq record);

    int updateByPrimaryKey(Teacherq record);
}