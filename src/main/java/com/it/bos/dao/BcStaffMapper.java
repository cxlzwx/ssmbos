package com.it.bos.dao;

import com.it.bos.pojo.BcStaff;
import com.it.bos.pojo.BcStaffExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BcStaffMapper {
    int countByExample(BcStaffExample example);

    int deleteByExample(BcStaffExample example);

    int deleteByPrimaryKey(String id);

    int insert(BcStaff record);

    int insertSelective(BcStaff record);

    List<BcStaff> selectByExample(BcStaffExample example);

    BcStaff selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BcStaff record);

    int updateByPrimaryKey(BcStaff record);
}