package com.sharding.entity;

public class Pagination {
    private int pageSize = 10;
    private int totalPage;
    private int pageNum = 1;
    private int totalRecords;
    /** @deprecated */
    @Deprecated
    private int pageIndex;

    public Pagination(int pageNum, int pageSize) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public Pagination() {
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageIndex() {
        return this.pageNum;
    }

    public void setPageIndex(int pageIndex) {
        this.pageNum = pageIndex;
        this.pageIndex = pageIndex;
    }
}
