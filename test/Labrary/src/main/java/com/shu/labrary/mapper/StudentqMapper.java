package com.shu.labrary.mapper;

import com.shu.labrary.pojo.Studentq;
import com.shu.labrary.pojo.StudentqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentqMapper {
    int countByExample(StudentqExample example);

    int deleteByExample(StudentqExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Studentq record);

    int insertSelective(Studentq record);

    List<Studentq> selectByExample(StudentqExample example);

    Studentq selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Studentq record, @Param("example") StudentqExample example);

    int updateByExample(@Param("record") Studentq record, @Param("example") StudentqExample example);

    int updateByPrimaryKeySelective(Studentq record);

    int updateByPrimaryKey(Studentq record);
}