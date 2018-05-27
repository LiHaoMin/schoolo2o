package com.lihaomin.schoolo2o.service;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Page<ProductDto> listPage(int page);
    List<ProductDto> list(int shopId);
    boolean delete(List<Integer> ids);
    boolean save(ProductDto productDto);
}
