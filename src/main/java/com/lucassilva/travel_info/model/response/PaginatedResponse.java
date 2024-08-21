package com.lucassilva.travel_info.model.response;

import java.util.List;

public class PaginatedResponse<T> {
    private final List<T> items;
    private final int totalItems;
    private final int currentPage;
    private final int totalPages;
    private final int pageSize;

    public PaginatedResponse(List<T> items, int totalItems, int currentPage, int pageSize) {
        this.items = items;
        this.totalItems = totalItems;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
    }

    public List<T> getItems() {
        return items;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }
}
