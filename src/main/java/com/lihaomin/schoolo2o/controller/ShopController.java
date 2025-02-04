package com.lihaomin.schoolo2o.controller;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.common.RequestResult;
import com.lihaomin.schoolo2o.model.Shop;
import com.lihaomin.schoolo2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/list")
    public RequestResult<List<Shop>> list(@RequestParam(value = "page",defaultValue = "1") int page){
        Page<Shop> shops = shopService.list(page);
        RequestResult<List<Shop>> result = new RequestResult(shops.getResult());
        result.setTotal(shops.getPages());
        return result;
    }

    @RequestMapping("/list2")
    public RequestResult<List<Shop>> list2(@RequestParam(value = "catId",required = false) int catId){
        List<Shop> shops = shopService.list2(catId);
        return new RequestResult<>(shops);
    }

    @RequestMapping("/delete")
    public RequestResult delete(@RequestParam("ids") List<Integer> ids){
        boolean flag = shopService.delete(ids);
        if(flag){
            return new RequestResult(true,"删除成功");
        }
        return new RequestResult(false,"删除失败");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RequestResult save(@RequestBody Shop shop){
        boolean flag = shopService.save(shop);
        if(flag){
            return new RequestResult(true,"添加成功");
        }
        return new RequestResult(false,"添加失败");
    }

    @RequestMapping("/get")
    public RequestResult get(int id){
        Shop shop = shopService.get(id);
        if(shop!=null){
            return new RequestResult(shop);
        }
        return new RequestResult(false,"添加失败");
    }
}
