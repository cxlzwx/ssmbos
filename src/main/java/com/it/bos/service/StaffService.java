package com.it.bos.service;

import com.it.bos.pojo.BcStaff;

import java.util.List;

/**
 * Created by Think on 2018/5/8.
 */
public interface StaffService {

    List<BcStaff> findAll();

    void addStaff(BcStaff bcStaff);

    int findCount();
}
