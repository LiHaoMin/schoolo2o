package com.lihaomin.schoolo2o.controller;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.common.RequestResult;
import com.lihaomin.schoolo2o.model.Area;
import com.lihaomin.schoolo2o.model.ShopCategory;
import com.lihaomin.schoolo2o.model.User;
import com.lihaomin.schoolo2o.service.ShopCategoryService;
import com.lihaomin.schoolo2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shopCategory")
public class ShopCategoryController {
    @Autowired
    private ShopCategoryService shopCategoryService;

    @RequestMapping("/list")
    public RequestResult<List<ShopCategory>> list(@RequestParam(value = "page",defaultValue = "1") int page){
        Page<ShopCategory> shopCategories = shopCategoryService.list(page);
        RequestResult<List<ShopCategory>> result = new RequestResult(shopCategories.getResult());
        result.setTotal(shopCategories.getPages());
        return result;
    }

    @RequestMapping("/delete")
    public RequestResult delete(@RequestParam("ids") List<Integer> ids){
        boolean flag = shopCategoryService.delete(ids);
        if(flag){
            return new RequestResult(true,"删除成功");
        }
        return new RequestResult(false,"删除失败");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RequestResult save(@RequestBody ShopCategory shopCategory){
        boolean flag = shopCategoryService.save(shopCategory);
        if(flag){
            return new RequestResult(true,"添加成功");
        }
        return new RequestResult(false,"添加失败");
    }

    @RequestMapping("/parentList")
    public RequestResult<List<ShopCategory>> parentList(@RequestParam(value = "lv",defaultValue = "1") int lv){
        List<ShopCategory> shopCategories = shopCategoryService.parentList(lv);
        RequestResult<List<ShopCategory>> result = new RequestResult(shopCategories);
        result.setTotal(shopCategories.size());
        return result;
    }
}
