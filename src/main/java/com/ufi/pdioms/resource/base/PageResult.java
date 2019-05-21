package com.ufi.pdioms.resource.base;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
    //当前页
    private long current;

    //页面大小，数据的存放数量
    private long pageSize;

    //总记录数
    private long total;

    //总页数
    private long totalPage;

    //列表；占位符，如果赋值以后是不可以修改其里面的值的
    private List<?> data;

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public PageResult(long total, List<?> data, long totalPage,long pageSize,long current) {
        this.data = data;
        this.total = total;
        this.totalPage=totalPage;
        this.pageSize=pageSize;
        this.current=current;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
