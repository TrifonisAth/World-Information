package com.example.worldinfo.worldinfoservice.models.responses.pagination;

import java.io.Serializable;

public class PaginationLink implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String uri;

    public PaginationLink(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "PaginationLink{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }
}
