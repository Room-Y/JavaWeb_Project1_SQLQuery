package com.itheima.pojo;

import java.util.List;

/**
 * @author: Java_cmr
 * @Date: 2023/2/16 - 16:52
 */
public class PageBean<T> {
    private int totalCount;
    private List<T> rows;

    public PageBean() {
    }

    public PageBean(int totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }

    /**
     * 获取
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取
     * @return rows
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * 设置
     * @param rows
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String toString() {
        return "PageBean{totalCount = " + totalCount + ", rows = " + rows + "}";
    }
}
