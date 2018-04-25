package com.zryq.cms.common.data;

/**
 * 用于jqPagination插件分页
 * Created by Gong on 2016/7/6.
 */
public class PaginationResponse extends JsonResult {
    private int page;
    private int totalPage;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PaginationResponse{" + "page=" + page + ", totalPage=" + totalPage + '}';
    }
}
