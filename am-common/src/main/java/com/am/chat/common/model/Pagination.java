package com.am.chat.common.model;

/**
 * Created by zhangpeng12 on 2016/12/21.
 */

import java.io.Serializable;

/**
 * 分页
 */
public class Pagination implements Serializable {
    // 当前页
    private int page = 1;
    // 总页数
    private int totalPage;
    // 总记录数
    private int totalRecord;
    // 页大小
    private int pageSize = 10;
    // 起始记录条数
    private int start = -1;

    public Pagination() {
    }

    public Pagination(int page, int pageSize) {
        setPage(page);
        setPageSize(pageSize);
    }

    public static Pagination newWithAll() {
        return new Pagination(1, Integer.MAX_VALUE);
    }

    public static Pagination newWithOne() {
        return new Pagination(1, 1);
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        if (page < 0) {
            throw new IllegalArgumentException("page must be greater than 1");
        }
        this.page = page;
        this.start = -1;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        if (totalPage < 0) {
            throw new IllegalArgumentException("totalPage must be greater than or equal 0");
        }
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return this.totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        if (totalRecord < 0) {
            throw new IllegalArgumentException("totalRecord must be greater than or equal 0");
        }
        this.totalRecord = totalRecord;
        totalPage = totalRecord / pageSize;
        if (totalRecord % pageSize > 0) {
            totalPage += 1;
        }
        if (totalPage == 0) {
            page = 1;
            start = -1;
        } else if (page > totalPage) {
            page = totalPage;
            start = -1;
        }
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            throw new IllegalArgumentException("pageSize must be greater than  0");
        }
        this.pageSize = pageSize;
    }

    public int getStart() {
        if (start < 0) {
            start = (page - 1) * pageSize;
        }
        return start;
    }

}