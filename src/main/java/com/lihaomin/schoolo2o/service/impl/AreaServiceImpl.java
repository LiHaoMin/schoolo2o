package com.lihaomin.schoolo2o.service.impl;

import com.lihaomin.schoolo2o.mapper.AreaMapper;
import com.lihaomin.schoolo2o.model.Area;
import com.lihaomin.schoolo2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaMapper areaMapper;
}
