package com.example.worldinfo.worldinfoservice.models.responses.pagination;

import com.example.worldinfo.worldinfoservice.entities.Country;

import java.io.Serializable;
import java.util.List;

public class CountryPagination extends Pagination implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<Country> countries;

    public CountryPagination(int pageNumber, int limit, int total, int offset, String orderBy, String order, List<PaginationLink> links, List<Country> countries) {
        super(pageNumber, limit, total, offset, orderBy, order, links);
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public String toString() {
        return "CountryPagination{" +
                "countries=" + countries +
                '}';
    }


}
