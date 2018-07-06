package com.pinyougou.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: pinyougou_parent
 * @description: 这是一个分页的工具
 * @author: YF
 * @create: 2018-07-06 15:55
 **/
public class PageResult<T> implements Serializable{
    /*
    * 两个参数
    * */
    private long total;//记录总页数
    private List<T> rows;//数据的集合

    //空参构造
    public PageResult() {

    }

    //有参构造
    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
