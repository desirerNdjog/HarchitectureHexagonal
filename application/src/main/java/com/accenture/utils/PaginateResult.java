package com.accenture.utils;

import java.util.List;

/**
 * @Project TestProject
 * @Author desire.junior.ndjog
 * @Date Created 9/10/2024
 */

public class PaginateResult<T> {
    private long totalElement;
    private int totalPage;
    private List<T> data;

    public PaginateResult() {
    }

    public PaginateResult(long totalElement, int totalPage, List<T> data) {
        this.totalElement = totalElement;
        this.totalPage = totalPage;
        this.data = data;
    }

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
