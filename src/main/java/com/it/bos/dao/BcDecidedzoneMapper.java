package com.it.bos.dao;

import com.it.bos.pojo.BcDecidedzone;
import com.it.bos.pojo.BcDecidedzoneExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BcDecidedzoneMapper {
    int countByExample(BcDecidedzoneExample example);

    int deleteByExample(BcDecidedzoneExample example);

    int deleteByPrimaryKey(String id);

    int insert(BcDecidedzone record);

    int insertSelective(BcDecidedzone record);

    List<BcDecidedzone> selectByExample(BcDecidedzoneExample example);

    BcDecidedzone selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BcDecidedzone record, @Param("example") BcDecidedzoneExample example);

    int updateByExample(@Param("record") BcDecidedzone record, @Param("example") BcDecidedzoneExample example);

    int updateByPrimaryKeySelective(BcDecidedzone record);

    int updateByPrimaryKey(BcDecidedzone record);
}