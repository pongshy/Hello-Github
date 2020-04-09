package com.shu.labrary.mapper;

import com.shu.labrary.pojo.Essay;
import com.shu.labrary.pojo.EssayExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EssayMapper {
    int countByExample(EssayExample example);

    int deleteByExample(EssayExample example);

    int deleteByPrimaryKey(Integer essayid);

    int insert(Essay record);

    int insertSelective(Essay record);

    List<Essay> selectByExample(EssayExample example);

    Essay selectByPrimaryKey(Integer essayid);

    int updateByExampleSelective(@Param("record") Essay record, @Param("example") EssayExample example);

    int updateByExample(@Param("record") Essay record, @Param("example") EssayExample example);

    int updateByPrimaryKeySelective(Essay record);

    int updateByPrimaryKey(Essay record);

    List<Map> selecthasupdatedessay(Integer isupdate);

    List<Map> selectnoupdatedessay(Integer isupdate);

    List<Map> selectessays(int parseInt);

    List<Map> selectEssaysByName(String toString);
}