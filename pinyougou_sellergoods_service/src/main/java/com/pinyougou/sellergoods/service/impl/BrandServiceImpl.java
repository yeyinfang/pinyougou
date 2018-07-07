package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pingyougou.sellergoods.service.BrandService;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
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
    public PageResult<TbBrand> findAll(Integer page, Integer size, TbBrand brand) {
        /*分页处理*/
        PageHelper.startPage(page,size);
        //首先就是构建查询的条件
        Example example = new Example(TbBrand.class);
        Example.Criteria criteria = example.createCriteria();
        //判断是否名称为空
        if(StringUtils.isNotEmpty(brand.getName())){
            criteria.andLike("name", "%" + brand.getName() + "%");
        }
        //首字母是否为空
        if(StringUtils.isNotEmpty(brand.getFirstChar())){
            criteria.andEqualTo("firstChar",brand.getFirstChar());
        }
        List<TbBrand> brandList = brandMapper.selectByExample(example);
        PageInfo<TbBrand> info = new PageInfo<>(brandList);
        PageResult<TbBrand> pageResult = new PageResult<>();
        pageResult.setRows(info.getList());
        pageResult.setTotal(info.getTotal());
        return pageResult;
    }

    //增加业务
    @Override
    public void addBrand(TbBrand brand) {
        brandMapper.insertSelective(brand);

    }

    @Override
    public void updateBrand(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public TbBrand findById(long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteBrand(Long[] ids) {
        //将传过来的数组转成list
        List longs = Arrays.asList(ids);
        //构造查询条件
        Example example = new Example(TbBrand.class);
        Example.Criteria criteria =example.createCriteria();
        criteria.andIn("id",longs);
        //删除
        brandMapper.deleteByExample(example);
    }

}
