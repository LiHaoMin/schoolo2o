package com.lihaomin.schoolo2o.controller;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.common.RequestResult;
import com.lihaomin.schoolo2o.model.User;
import com.lihaomin.schoolo2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public RequestResult<List<User>> list(@RequestParam(value = "page",defaultValue = "1") int page){
        Page<User> users = userService.queryList(page);
        RequestResult<List<User>> result = new RequestResult(users.getResult());
        result.setTotal(users.getPages());
        return result;
    }

    @RequestMapping("/login")
    public RequestResult login(String username,String password){
        boolean flag = userService.login(username, password);
        if(flag){
            return new RequestResult(true,"登录成功");
        }
        return new RequestResult(false,"登录失败");
    }
}
