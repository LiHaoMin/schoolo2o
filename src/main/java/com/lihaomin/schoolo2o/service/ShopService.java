package com.lihaomin.schoolo2o.service;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.model.Shop;

import java.util.List;

public interface ShopService {
    Page<Shop> list(int page);
    List<Shop> list2(Integer catId);
    boolean delete(List<Integer> ids);
    boolean save(Shop shop);
    Shop get(int id);
}
