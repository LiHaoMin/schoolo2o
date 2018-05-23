package com.lihaomin.schoolo2o.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lihaomin.schoolo2o.common.Contracts;
import com.lihaomin.schoolo2o.mapper.AreaMapper;
import com.lihaomin.schoolo2o.model.Area;
import com.lihaomin.schoolo2o.model.AreaExample;
import com.lihaomin.schoolo2o.model.User;
import com.lihaomin.schoolo2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public Page<Area> list(int page) {
        Page<Area> pages = PageHelper.startPage(page, Contracts.PAGE_SIZE);
        AreaExample example = new AreaExample();
        example.setOrderByClause("priority desc");
        areaMapper.selectByExample(example);
        return pages;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        AreaExample example = new AreaExample();
        example.createCriteria().andIdIn(ids);
        int rows = areaMapper.deleteByExample(example);
        if(rows > 0)
            return true;
        return false;
    }

    @Override
    public boolean save(Area area) {
        area.setCreateTime(new Date());
        int rows = areaMapper.insertSelective(area);
        if(rows > 0)
            return true;
        return false;
    }
}
