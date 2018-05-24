package com.lihaomin.schoolo2o.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lihaomin.schoolo2o.common.Contracts;
import com.lihaomin.schoolo2o.mapper.ShopCategoryMapper;
import com.lihaomin.schoolo2o.model.ShopCategory;
import com.lihaomin.schoolo2o.model.ShopCategoryExample;
import com.lihaomin.schoolo2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{
    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Override
    public Page<ShopCategory> list(int page) {
        Page<ShopCategory> pages = PageHelper.startPage(page, Contracts.PAGE_SIZE);
        shopCategoryMapper.selectByExample(null);
        return pages;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        ShopCategoryExample example = new ShopCategoryExample();
        example.createCriteria().andIdIn(ids);
        int rows = shopCategoryMapper.deleteByExample(example);
        if(rows > 0)
            return true;
        return false;
    }

    @Override
    public boolean save(ShopCategory shopCategory) {
        shopCategory.setCreateTime(new Date());
        int rows = shopCategoryMapper.insertSelective(shopCategory);
        if(rows > 0)
            return true;
        return false;
    }

    @Override
    public List<ShopCategory> parentList(int lv) {
        ShopCategoryExample example = new ShopCategoryExample();
        if(lv == 1)
            example.createCriteria().andParentIdIsNull();
        else
            example.createCriteria().andParentIdIsNotNull();
        List<ShopCategory> shopCategories = shopCategoryMapper.selectByExample(example);
        return shopCategories;
    }
}
