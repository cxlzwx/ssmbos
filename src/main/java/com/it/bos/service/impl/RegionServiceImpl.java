package com.it.bos.service.impl;
/**
 * Created by Think on 2018/5/9.
 */

import com.it.bos.dao.BcRegionMapper;
import com.it.bos.pojo.BcRegion;
import com.it.bos.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RegionServiceImpl
 * @Description 区域设置service
 * @Author Think
 * @Date 2018/5/9 0:07
 * @Version 1.0
 */
@Service
public class RegionServiceImpl implements RegionService{

    @Autowired
    private BcRegionMapper bcRegionMapper;

    @Override
    public List<BcRegion> findAllRegion() {
        List<BcRegion> regions = bcRegionMapper.selectByExample(null);
        return regions;
    }

    @Override
    public int findCount() {
        return bcRegionMapper.countByExample(null);
    }
}
