package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

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
     * @param brand
     */
    public PageResult<TbBrand> findAll(Integer page, Integer size, TbBrand brand);

    /** 
    * @Description: 对品牌业务进行增加
    * @Param: [brand] 
    * @return: com.pinyougou.entity.Result 
    * @Author: Yin 
    * @Date: 2018/7/6 
    */ 
    void addBrand(TbBrand brand);

    /** 
    * @Description: 修改数据
    * @Param: [brand] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/7/6 
    */ 
    void updateBrand(TbBrand brand);

    /** 
    * @Description: 回显数据 
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbBrand 
    * @Author: Yin 
    * @Date: 2018/7/6 
    */ 
    TbBrand findById(long id);

    /** 
    * @Description: 删除选中的数据 
    * @Param: [ids] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/7/6 
    */ 
    void deleteBrand(Long[] ids);
}
