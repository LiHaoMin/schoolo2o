package com.lihaomin.schoolo2o.service;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.model.User;

public interface UserService {
    Page<User> queryList(int currentPage);
    boolean login(String username,String password);
}
