package com.lihaomin.schoolo2o.service;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.model.Area;
import com.lihaomin.schoolo2o.model.HeadLines;

import java.util.List;

public interface HeadLinesService {
    Page<HeadLines> list(int page);
    boolean delete(List<Integer> ids);
    boolean save(HeadLines headLines);
}
