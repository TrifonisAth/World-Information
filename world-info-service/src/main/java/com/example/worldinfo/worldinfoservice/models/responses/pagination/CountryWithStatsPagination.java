package com.example.worldinfo.worldinfoservice.models.responses.pagination;

import com.example.worldinfo.worldinfoservice.entities.CountryWithStats;

import java.io.Serializable;
import java.util.List;

public class CountryWithStatsPagination extends Pagination implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<CountryWithStats> countries;

    public CountryWithStatsPagination(int pageNumber, int limit, int total, int offset, String orderBy, String order, List<PaginationLink> links, List<CountryWithStats> countries) {
        super(pageNumber, limit, total, offset, orderBy, order, links);
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "CountryWithStatsPagination{" +
                "countries=" + countries +
                '}';
    }

    public List<CountryWithStats> getCountries() {
        return countries;
    }
}
