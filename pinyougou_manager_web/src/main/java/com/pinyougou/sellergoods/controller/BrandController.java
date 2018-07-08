package com.pinyougou.sellergoods.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    //日志对象
    Logger logger =Logger.getLogger(BrandController.class);
    @Reference
    private BrandService brandService;

    //条件查询
    @RequestMapping("/search")
    @ResponseBody
    public PageResult<TbBrand> search(Integer page, Integer size,@RequestBody TbBrand brand){
        return brandService.search(page,size,brand);
    }

    //分页
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult<TbBrand> findPage(Integer page, Integer size){
        return brandService.findPage(page,size);
    }

    //查找所有的
    @RequestMapping("/findAll")
    @ResponseBody
    public List<TbBrand> findAll(){
        return  brandService.findAll();
    }

    /*
    * 增加品牌消息
    * */
    @RequestMapping("/add")
    public Result addBrand(@RequestBody TbBrand brand){
        try {
            brandService.addBrand(brand);
            if(brand.getId()!=null){
                //证明保存成功
                return new Result(true,"品牌保存成功！");
            }
        } catch (Exception e) {
            logger.error("品牌保存出现异常！",e);
            return new Result(false,"保存品牌失败！");
        }
        return null;
    }

    //回显要修改的数据
    @RequestMapping("/findById")
    @ResponseBody
    public TbBrand findById(long id){
        return brandService.findById(id);
    }

    //修改操作
    @RequestMapping("/update")
    public Result updateBrand(@RequestBody TbBrand brand){
        try {
            brandService.updateBrand(brand);
           return new Result(true,"品牌修改成功！");
        } catch (Exception e) {
            logger.error("品牌修改出现异常！",e);
            return new Result(false,"品牌修改失败！");
        }
    }

    //删除所选中的数据
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteBrand(Long[] ids){
        try {
            brandService.deleteBrand(ids);
            return new Result(true,"删除品牌成功");
        } catch (Exception e) {
            logger.error("删除品牌出现异常",e);
            return new Result(false,"删除品牌失败");
        }
    }


}
