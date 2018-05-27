package com.lihaomin.schoolo2o.controller;

import com.github.pagehelper.Page;
import com.lihaomin.schoolo2o.common.RequestResult;
import com.lihaomin.schoolo2o.model.dto.ProductDto;
import com.lihaomin.schoolo2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class PoductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public RequestResult<List<ProductDto>> list(@RequestParam(value = "page",defaultValue = "1") int page,@RequestParam(value = "shopId",required = false) Integer shopId){
        if(shopId == null){
            Page<ProductDto> productDtos = productService.listPage(page);
            RequestResult<List<ProductDto>> result = new RequestResult(productDtos.getResult());
            result.setTotal(productDtos.getPages());
            return result;
        }else{
            List<ProductDto> list = productService.list(shopId);
            RequestResult<List<ProductDto>> result = new RequestResult(list);
            result.setTotal(list.size());
            return result;
        }

    }

    @RequestMapping("/delete")
    public RequestResult delete(@RequestParam("ids") List<Integer> ids){
        boolean flag = productService.delete(ids);
        if(flag){
            return new RequestResult(true,"删除成功");
        }
        return new RequestResult(false,"删除失败");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RequestResult save(@RequestBody ProductDto productDto){
        boolean flag = productService.save(productDto);
        if(flag){
            return new RequestResult(true,"添加成功");
        }
        return new RequestResult(false,"添加失败");
    }
}
