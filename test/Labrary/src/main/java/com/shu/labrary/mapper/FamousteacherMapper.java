package com.shu.labrary.mapper;

import com.shu.labrary.pojo.Famousteacher;
import com.shu.labrary.pojo.FamousteacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FamousteacherMapper {
    int countByExample(FamousteacherExample example);

    int deleteByExample(FamousteacherExample example);

    int deleteByPrimaryKey(Integer teacherid);

    int insert(Famousteacher record);

    int insertSelective(Famousteacher record);

    List<Famousteacher> selectByExampleWithBLOBs(FamousteacherExample example);

    List<Famousteacher> selectByExample(FamousteacherExample example);

    Famousteacher selectByPrimaryKey(Integer teacherid);

    int updateByExampleSelective(@Param("record") Famousteacher record, @Param("example") FamousteacherExample example);

    int updateByExampleWithBLOBs(@Param("record") Famousteacher record, @Param("example") FamousteacherExample example);

    int updateByExample(@Param("record") Famousteacher record, @Param("example") FamousteacherExample example);

    int updateByPrimaryKeySelective(Famousteacher record);

    int updateByPrimaryKeyWithBLOBs(Famousteacher record);
}