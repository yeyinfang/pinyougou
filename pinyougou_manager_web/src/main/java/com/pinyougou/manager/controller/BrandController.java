package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.sellergoods.service.BrandService;
import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: pinyougou_parent
 * @description:品牌业务的实现类
 * @author: YF
 * @create: 2018-07-05 17:25
 **/
@Controller
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    @ResponseBody
    public PageResult<TbBrand> findAll(@RequestParam(required = false,defaultValue = "1") Integer page,
                                       @RequestParam(required = false,defaultValue = "10")Integer size){
        return brandService.findAll(page,size);
    }
}
