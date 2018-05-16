package com.it.bos.service.impl;/**
 * Created by Think on 2018/5/8.
 */

import com.it.bos.dao.BcStaffMapper;
import com.it.bos.pojo.BcStaff;
import com.it.bos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StaffServiceImpl
 * @Description 取派员service
 * @Author Think
 * @Date 2018/5/8 17:40
 * @Version 1.0
 */
@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private BcStaffMapper bcStaffMapper;
    
    /**  
     * 
     * @Description 取派员列表查询
     * @date 2018/5/8 19:16  
     * @param []  
     * @return java.util.List<com.it.bos.pojo.BcStaff>  
     */
    @Override
    public List<BcStaff> findAll() {
        List<BcStaff> bcStaffs = bcStaffMapper.selectByExample(null);
        return bcStaffs;
    }

    /**  
     * 
     * @Description 取派员的添加功能实现
     * @date 2018/5/8 19:15  
     * @param [bcStaff]  
     * @return void  
     */
    @Override
    public void addStaff(BcStaff bcStaff) {
        bcStaffMapper.insert(bcStaff);
    }

    @Override
    public int findCount() {
        return  bcStaffMapper.countByExample(null);
    }
}
