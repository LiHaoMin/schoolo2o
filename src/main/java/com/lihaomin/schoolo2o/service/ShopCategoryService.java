package com.lihaomin.schoolo2o.service;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.model.Area;
import com.lihaomin.schoolo2o.model.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    Page<ShopCategory> list(int page);
    boolean delete(List<Integer> ids);
    boolean save(ShopCategory shopCategory);
    List<ShopCategory> parentList(int lv);
}
