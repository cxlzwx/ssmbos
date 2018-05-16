package com.it.bos.dao;

import com.it.bos.pojo.BcSubarea;
import com.it.bos.pojo.BcSubareaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BcSubareaMapper {
    int countByExample(BcSubareaExample example);

    int deleteByExample(BcSubareaExample example);

    int deleteByPrimaryKey(String id);

    int insert(BcSubarea record);

    int insertSelective(BcSubarea record);

    List<BcSubarea> selectByExample(BcSubareaExample example);

    BcSubarea selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BcSubarea record, @Param("example") BcSubareaExample example);

    int updateByExample(@Param("record") BcSubarea record, @Param("example") BcSubareaExample example);

    int updateByPrimaryKeySelective(BcSubarea record);

    int updateByPrimaryKey(BcSubarea record);
}