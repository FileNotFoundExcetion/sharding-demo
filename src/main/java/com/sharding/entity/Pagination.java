package com.sharding.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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


    public int getPageIndex() {
        return this.pageNum;
    }

    public void setPageIndex(int pageIndex) {
        this.pageNum = pageIndex;
        this.pageIndex = pageIndex;
    }
}
