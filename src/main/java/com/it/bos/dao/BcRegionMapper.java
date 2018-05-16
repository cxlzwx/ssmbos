package com.it.bos.dao;

import com.it.bos.pojo.BcRegion;
import com.it.bos.pojo.BcRegionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BcRegionMapper {
    int countByExample(BcRegionExample example);

    int deleteByExample(BcRegionExample example);

    int deleteByPrimaryKey(String id);

    int insert(BcRegion record);

    int insertSelective(BcRegion record);

    List<BcRegion> selectByExample(BcRegionExample example);

    BcRegion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BcRegion record, @Param("example") BcRegionExample example);

    int updateByExample(@Param("record") BcRegion record, @Param("example") BcRegionExample example);

    int updateByPrimaryKeySelective(BcRegion record);

    int updateByPrimaryKey(BcRegion record);
}