package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pingyougou.sellergoods.service.BrandService;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: pinyougou_parent
 * @description: 品牌业务的实现类
 * @author: YF
 * @create: 2018-07-05 17:02
 **/
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public PageResult<TbBrand> findAll(Integer page, Integer size) {
        /*分页处理*/
        PageHelper.startPage(page,size);
        List<TbBrand> brandList = brandMapper.select(null);
        PageInfo<TbBrand> info = new PageInfo<>(brandList);
        PageResult<TbBrand> pageResult = new PageResult<>();
        pageResult.setRows(info.getList());
        pageResult.setTotal(info.getTotal());
        return pageResult;
    }
}
