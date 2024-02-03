package com.example.worldinfo.worldinfoservice.models.responses.pagination;

import java.io.Serializable;
import java.util.Arrays;

public class Pagination implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int[] pageSizes;
    private final int defaultPageSize;


    public Pagination(int[] pageSizes, int defaultPageSize) {
        this.pageSizes = pageSizes;
        this.defaultPageSize = defaultPageSize;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "pageSizes=" + Arrays.toString(pageSizes) +
                ", defaultPageSize=" + defaultPageSize +
                '}';
    }

    public int[] getPageSizes() {
        return pageSizes;
    }

    public int getDefaultPageSize() {
        return defaultPageSize;
    }
}
