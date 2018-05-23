package com.lihaomin.schoolo2o.controller;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.common.RequestResult;
import com.lihaomin.schoolo2o.model.Area;
import com.lihaomin.schoolo2o.model.User;
import com.lihaomin.schoolo2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping("/list")
    public RequestResult<List<Area>> list(@RequestParam(value = "page",defaultValue = "1") int page){
        Page<Area> areas = areaService.list(page);
        RequestResult<List<Area>> result = new RequestResult(areas.getResult());
        result.setTotal(areas.getPages());
        return result;
    }

    @RequestMapping("/delete")
    public RequestResult delete(@RequestParam("ids") List<Integer> ids){
        boolean flag = areaService.delete(ids);
        if(flag){
            return new RequestResult(true,"删除成功");
        }
        return new RequestResult(false,"删除失败");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RequestResult save(@RequestBody Area area){
        boolean flag = areaService.save(area);
        if(flag){
            return new RequestResult(true,"添加成功");
        }
        return new RequestResult(false,"添加失败");
    }
}
