package com.it.bos.service;

import com.it.bos.pojo.BcRegion;

import java.util.List;

/**
 * Created by Think on 2018/5/9.
 */
public interface RegionService {
    List<BcRegion> findAllRegion();

    int findCount();
}
