package com.pinyougou.pojogroup;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

/**
 * @program: pinyougou_parent
 * @description: 这是增加商品的参数或者是实体类管理
 * @author: YF
 * @create: 2018-07-13 17:29
 **/
public class Goods implements Serializable {
    //h获取到商品管理
    private TbGoods goods;
    //获取到扩展的
    private TbGoodsDesc goodsDesc;
    //获取到分类,商品的sku列表
    private List<TbItem> items;
    //获取到品牌管理
    private TbBrand brands;

    public TbGoods getGoods() {
        return goods;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<TbItem> getItems() {
        return items;
    }

    public void setItems(List<TbItem> items) {
        this.items = items;
    }

    public TbBrand getBrands() {
        return brands;
    }

    public void setBrands(TbBrand brands) {
        this.brands = brands;
    }
}
