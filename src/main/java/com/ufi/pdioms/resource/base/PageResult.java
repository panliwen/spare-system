package com.ufi.pdioms.resource.base;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {

    //列表；占位符，如果赋值以后是不可以修改其里面的值的
    private List<?> rows;

    //总记录数
    private long total;

    public PageResult(long total, List<?> rows) {
        this.rows = rows;
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
