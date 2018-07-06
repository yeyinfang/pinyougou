package com.pingyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

/*
* 品牌业务逻辑接口
* */
public interface BrandService {

    /** 
    * @Description: 查找到所有的品牌信息
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/7/5
     * @param page
     * @param size
    */ 
    public PageResult<TbBrand> findAll(Integer page, Integer size);
}
