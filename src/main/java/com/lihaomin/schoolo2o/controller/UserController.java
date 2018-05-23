package com.lihaomin.schoolo2o.controller;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.common.RequestResult;
import com.lihaomin.schoolo2o.model.User;
import com.lihaomin.schoolo2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/delete")
    public RequestResult delete(@RequestParam("ids") List<Integer> ids){
        boolean flag = userService.delete(ids);
        if(flag){
            return new RequestResult(true,"删除成功");
        }
        return new RequestResult(false,"删除失败");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RequestResult save(@RequestBody User user){
        boolean flag = userService.save(user);
        if(flag){
            return new RequestResult(true,"添加成功");
        }
        return new RequestResult(false,"添加失败");
    }
}
