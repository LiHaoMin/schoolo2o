package com.lihaomin.schoolo2o.service;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.model.Area;

import java.util.List;

public interface AreaService {
    Page<Area> list(int page);
    boolean delete(List<Integer> ids);
    boolean save(Area area);
}
