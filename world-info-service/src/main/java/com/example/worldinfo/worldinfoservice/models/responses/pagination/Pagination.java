package com.example.worldinfo.worldinfoservice.models.responses.pagination;

import java.io.Serializable;
import java.util.List;

public abstract class Pagination implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int pageNumber;
    private final int limit;
    private final int total;
    private final int offset;
    private final String orderBy;
    private final String order;
    private final List<PaginationLink> links;

    public Pagination(int pageNumber, int limit, int total, int offset, String orderBy, String order, List<PaginationLink> links) {
        this.pageNumber = pageNumber;
        this.limit = limit;
        this.total = total;
        this.offset = offset;
        this.orderBy = orderBy;
        this.order = order;
        this.links = links;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "pageNumber=" + pageNumber +
                ", limit=" + limit +
                ", total=" + total +
                ", offset=" + offset +
                ", orderBy='" + orderBy + '\'' +
                ", orderAsc=" + order +
                ", links=" + links +
                '}';
    }

    public String getOrder() {
        return order;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public List<PaginationLink> getLinks() {
        return links;
    }

    public int getOffset() {
        return offset;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

}
