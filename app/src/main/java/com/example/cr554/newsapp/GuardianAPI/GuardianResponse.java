package com.example.cr554.newsapp.GuardianAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cr554 on 2/20/2017.
 */

public class GuardianResponse {
    private String status;
    private String userTier;
    private int total;
    private int pageSize;
    private int currentPage;
    private int numberOfPages;
    private String orderBy;
    private List<GuardianResult> results = new ArrayList<GuardianResult>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserTier() {
        return userTier;
    }

    public void setUserTier(String userTier) {
        this.userTier = userTier;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<GuardianResult> getResults() {
        return results;
    }

    public void setResults(List<GuardianResult> results) {
        this.results = results;
    }
}
