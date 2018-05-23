package com.lihaomin.schoolo2o.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lihaomin.schoolo2o.common.Contracts;
import com.lihaomin.schoolo2o.mapper.HeadLinesMapper;
import com.lihaomin.schoolo2o.model.Area;
import com.lihaomin.schoolo2o.model.HeadLines;
import com.lihaomin.schoolo2o.model.HeadLinesExample;
import com.lihaomin.schoolo2o.service.HeadLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HeadLinesServiceImpl implements HeadLinesService {
    @Autowired
    private HeadLinesMapper headLinesMapper;

    @Override
    public Page<HeadLines> list(int page) {
        Page<HeadLines> headLines = PageHelper.startPage(page, Contracts.PAGE_SIZE);
        HeadLinesExample example = new HeadLinesExample();
        example.setOrderByClause("priority desc");
        headLinesMapper.selectByExample(example);
        return headLines;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        HeadLinesExample example = new HeadLinesExample();
        example.createCriteria().andIdIn(ids);
        int rows = headLinesMapper.deleteByExample(example);
        if(rows > 0)
            return true;
        return false;
    }

    @Override
    public boolean save(HeadLines headLines) {
        headLines.setCreateTime(new Date());
        int rows = headLinesMapper.insertSelective(headLines);
        if(rows > 0)
            return true;
        return false;
    }
}
