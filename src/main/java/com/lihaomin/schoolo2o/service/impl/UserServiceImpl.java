package com.lihaomin.schoolo2o.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lihaomin.schoolo2o.common.Contracts;
import com.lihaomin.schoolo2o.mapper.UserMapper;
import com.lihaomin.schoolo2o.model.User;
import com.lihaomin.schoolo2o.model.UserExample;
import com.lihaomin.schoolo2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> queryList(int currentPage) {
        Page<User> pages = PageHelper.startPage(currentPage, Contracts.PAGE_SIZE);
        userMapper.selectByExample(null);
        return pages;
    }

    @Override
    public boolean login(String username, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusEqualTo(1);
        criteria.andTypeEqualTo("3");
        example.setLimit(1);
        List<User> users = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(users))
            return false;
        if(password.equals(users.get(0).getPassword()))
            return true;
        return false;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        UserExample example = new UserExample();
        example.or().andIdIn(ids);
        int rows = userMapper.deleteByExample(example);
        if(rows > 0)
            return true;
        return false;
    }

    @Override
    public boolean save(User user) {
        user.setCreateTime(new Date());
        user.setName(user.getUsername());
        int rows = userMapper.insertSelective(user);
        if(rows > 0)
            return true;
        return false;
    }
}
