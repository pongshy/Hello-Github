package com.shu.labrary.mapper;

import com.shu.labrary.pojo.Stteacher;
import com.shu.labrary.pojo.StteacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StteacherMapper {
    int countByExample(StteacherExample example);

    int deleteByExample(StteacherExample example);

    int deleteByPrimaryKey(Integer stteacherid);

    int insert(Stteacher record);

    int insertSelective(Stteacher record);

    List<Stteacher> selectByExample(StteacherExample example);

    Stteacher selectByPrimaryKey(Integer stteacherid);

    int updateByExampleSelective(@Param("record") Stteacher record, @Param("example") StteacherExample example);

    int updateByExample(@Param("record") Stteacher record, @Param("example") StteacherExample example);

    int updateByPrimaryKeySelective(Stteacher record);

    int updateByPrimaryKey(Stteacher record);
}