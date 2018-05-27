package com.lihaomin.schoolo2o.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lihaomin.schoolo2o.common.Contracts;
import com.lihaomin.schoolo2o.mapper.ProductImageMapper;
import com.lihaomin.schoolo2o.mapper.ProductMapper;
import com.lihaomin.schoolo2o.model.ProductExample;
import com.lihaomin.schoolo2o.model.ProductImage;
import com.lihaomin.schoolo2o.model.dto.ProductDto;
import com.lihaomin.schoolo2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImageMapper productImageMapper;

    @Override
    public Page<ProductDto> listPage(int page) {
        Page<ProductDto> objects = PageHelper.startPage(page, Contracts.PAGE_SIZE);
        productMapper.queryList(null);
        return objects;
    }

    @Override
    public List<ProductDto> list(int shopId) {
        List<ProductDto> productDtos = productMapper.queryList(shopId);
        return productDtos;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        int rows = productMapper.deleteByExample(example);
        if (rows > 0)
            return true;
        return false;
    }

    @Override
    public boolean save(ProductDto productDto) {
        productDto.setCreatetime(new Date());
        int rows = productMapper.insertSelective(productDto);
        if (rows > 0){
            for (int i = 0; i < productDto.getProductImages().size(); i++) {
                ProductImage productImage = productDto.getProductImages().get(i);
                productImage.setCreateTime(new Date());
                productImage.setPriority(i+1);
                productImage.setProductId(productDto.getId());
                productImageMapper.insertSelective(productImage);
            }
            return true;
        }

        return false;
    }
}
