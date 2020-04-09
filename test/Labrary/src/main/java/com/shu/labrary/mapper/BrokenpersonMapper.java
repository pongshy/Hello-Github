package com.shu.labrary.mapper;

import com.shu.labrary.pojo.Brokenperson;
import com.shu.labrary.pojo.BrokenpersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrokenpersonMapper {
    int countByExample(BrokenpersonExample example);

    int deleteByExample(BrokenpersonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Brokenperson record);

    int insertSelective(Brokenperson record);

    List<Brokenperson> selectByExample(BrokenpersonExample example);

    Brokenperson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brokenperson record, @Param("example") BrokenpersonExample example);

    int updateByExample(@Param("record") Brokenperson record, @Param("example") BrokenpersonExample example);

    int updateByPrimaryKeySelective(Brokenperson record);

    int updateByPrimaryKey(Brokenperson record);
}