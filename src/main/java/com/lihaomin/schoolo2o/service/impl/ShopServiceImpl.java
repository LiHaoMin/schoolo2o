package com.lihaomin.schoolo2o.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lihaomin.schoolo2o.common.Contracts;
import com.lihaomin.schoolo2o.mapper.ShopMapper;
import com.lihaomin.schoolo2o.model.Shop;
import com.lihaomin.schoolo2o.model.ShopExample;
import com.lihaomin.schoolo2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Page<Shop> list(int page) {
        Page<Shop> shops = PageHelper.startPage(page, Contracts.PAGE_SIZE);
        ShopExample example = new ShopExample();
        example.setOrderByClause("priority desc");
        shopMapper.selectByExample(example);
        return shops;
    }

    @Override
    public List<Shop> list2(Integer catId) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        if(catId != null)
            criteria.andShopCategoryIdEqualTo(catId);
        example.setOrderByClause("priority desc");
        List<Shop> shops = shopMapper.selectByExample(example);
        return shops;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        ShopExample example = new ShopExample();
        example.createCriteria().andIdIn(ids);
        int rows = shopMapper.deleteByExample(example);
        if(rows > 0)
            return true;
        return false;
    }

    @Override
    public boolean save(Shop shop) {
        shop.setCreateTime(new Date());
        int rows = shopMapper.insertSelective(shop);
        if(rows > 0)
            return true;
        return false;
    }

    @Override
    public Shop get(int id) {
        Shop shop = shopMapper.selectByPrimaryKey(id);
        return shop;
    }
}
