package com.lihaomin.schoolo2o.service;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.model.User;

import java.util.List;

public interface UserService {
    Page<User> queryList(int currentPage);
    boolean login(String username,String password);
    boolean delete(List<Integer> ids);
    boolean save(User user);
}
