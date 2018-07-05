package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pingyougou.sellergoods.service.BrandService;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @program: pinyougou_parent
 * @description: 品牌业务的实现类
 * @author: YF
 * @create: 2018-07-05 17:02
 **/
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {
        return brandMapper.select(null);
    }
}
