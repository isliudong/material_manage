package com.ld.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: material_manage
 * @description:
 * @author: LD
 * @create: 2020-08-01 13:27
 **/
public class PaginationDTO<T> {

    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;

    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 包含页码
     */
    private List<Integer> pages;
    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        //Integer totalPage;//页数
        int temp;//当前包含页码
        this.page = page;

        //当前页包含页码设置
        for (int i = -3; i < 4; i++) {
            temp = page + i;
            if (temp > 0 && temp <= totalPage) {
                pages.add(temp);
            } else {
                if (temp < totalPage) {
                    i--;
                }
                page++;
            }
        }
        //是否暂展示上一页按钮
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否暂展示下一页按钮
        if (page.equals(totalPage)) {
            showNext = false;
        } else {
            showNext = true;
        }
        //是否暂展示第一页按钮
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        //是否暂展示最后一页按钮
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }

    public PaginationDTO() {
        pages = new ArrayList<>();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isShowPrevious() {
        return showPrevious;
    }

    public void setShowPrevious(boolean showPrevious) {
        this.showPrevious = showPrevious;
    }

    public boolean isShowFirstPage() {
        return showFirstPage;
    }

    public void setShowFirstPage(boolean showFirstPage) {
        this.showFirstPage = showFirstPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowEndPage() {
        return showEndPage;
    }

    public void setShowEndPage(boolean showEndPage) {
        this.showEndPage = showEndPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
