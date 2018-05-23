package com.lihaomin.schoolo2o.controller;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.common.RequestResult;
import com.lihaomin.schoolo2o.model.HeadLines;
import com.lihaomin.schoolo2o.model.ShopCategory;
import com.lihaomin.schoolo2o.service.HeadLinesService;
import com.lihaomin.schoolo2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/headLines")
public class HeadLinesController {
    @Autowired
    private HeadLinesService headLinesService;

    @RequestMapping("/list")
    public RequestResult<List<HeadLines>> list(@RequestParam(value = "page",defaultValue = "1") int page){
        Page<HeadLines> headLines = headLinesService.list(page);
        RequestResult<List<HeadLines>> result = new RequestResult(headLines.getResult());
        result.setTotal(headLines.getPages());
        return result;
    }

    @RequestMapping("/delete")
    public RequestResult delete(@RequestParam("ids") List<Integer> ids){
        boolean flag = headLinesService.delete(ids);
        if(flag){
            return new RequestResult(true,"删除成功");
        }
        return new RequestResult(false,"删除失败");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RequestResult save(@RequestBody HeadLines headLines){
        boolean flag = headLinesService.save(headLines);
        if(flag){
            return new RequestResult(true,"添加成功");
        }
        return new RequestResult(false,"添加失败");
    }
}
