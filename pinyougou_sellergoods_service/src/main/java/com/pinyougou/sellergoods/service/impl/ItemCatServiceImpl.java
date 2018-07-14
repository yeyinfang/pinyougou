package com.pinyougou.sellergoods.service.impl;
import java.util.Arrays;
import java.util.List;

import com.pinyougou.entity.PageResult;
import com.pinyougou.sellergoods.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbItemCatMapper;
import com.pinyougou.pojo.TbItemCat;


/**
 * 业务逻辑实现
 * @author Steven
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbItemCat> findAll() {
		return itemCatMapper.select(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		
		PageResult<TbItemCat> result = new PageResult<TbItemCat>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //查询数据
        List<TbItemCat> list = itemCatMapper.select(null);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<TbItemCat> info = new PageInfo<TbItemCat>(list);
        result.setTotal(info.getTotal());
		return result;
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbItemCat itemCat) {
		itemCatMapper.insertSelective(itemCat);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbItemCat itemCat){
		itemCatMapper.updateByPrimaryKeySelective(itemCat);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbItemCat findOne(Long id){
		return itemCatMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		//数组转list
        List longs = Arrays.asList(ids);
		
        //查询出父类的id，然后看是否有下级的分类
		for (Object id : longs) {
			
		}
		//构建查询条件
        Example example = new Example(TbItemCat.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", longs);

        //跟据查询条件删除数据
        itemCatMapper.deleteByExample(example);
	}
	
	
	@Override
	public PageResult findPage(TbItemCat itemCat, int pageNum, int pageSize) {
		PageResult<TbItemCat> result = new PageResult<TbItemCat>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(TbItemCat.class);
        Example.Criteria criteria = example.createCriteria();
		
		if(itemCat!=null){			
						//如果字段不为空
			if (itemCat.getName()!=null && itemCat.getName().length()>0) {
				criteria.andLike("name", "%" + itemCat.getName() + "%");
			}
	
		}

        //查询数据
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<TbItemCat> info = new PageInfo<TbItemCat>(list);
        result.setTotal(info.getTotal());
		
		return result;
	}

	@Override
	public List<TbItemCat> findByParentId(Long parentId) {
		//组装查询的条件
		TbItemCat itemCat = new TbItemCat();
		itemCat.setParentId(parentId);
		return itemCatMapper.select(itemCat);
	}

	//删除
	@Override
	public void getChildren(Long[] ids) {
		//数组转list
		List longs = Arrays.asList(ids);
		//这是时候进行第一次的循环
		for (Long id : ids) {
			//设置为父类的id
			TbItemCat itemCat = new TbItemCat();
			itemCat.setParentId(id);
			//寻找看是否有下级标签
			List<TbItemCat> cats = itemCatMapper.select(itemCat);
			//判断
			if(cats!=null && cats.size()>0){
				//若是数组不为0的话就是再次进行循环遍历
				for (TbItemCat tbItemCat : cats) {
					TbItemCat itemCat1 = new TbItemCat();
					itemCat1.setParentId(tbItemCat.getId());
					//由于在进行id之前我就已经是二级标题了，所以其实可以直接删除这个的id
					//删除3级标题
					itemCatMapper.delete(itemCat1);
					itemCatMapper.deleteByPrimaryKey(tbItemCat.getId());
				}
			}
			//这边就是没有下级标签的
			//构建查询条件
			Example example = new Example(TbItemCat.class);
			Example.Criteria criteria = example.createCriteria();
			criteria.andIn("id", longs);

			//跟据查询条件删除数据
			itemCatMapper.deleteByExample(example);
		}

	}

}
