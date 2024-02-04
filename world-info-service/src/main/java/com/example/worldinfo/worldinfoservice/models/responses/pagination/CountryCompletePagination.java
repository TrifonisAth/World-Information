package com.example.worldinfo.worldinfoservice.models.responses.pagination;

import com.example.worldinfo.worldinfoservice.entities.CountryComplete;

import java.io.Serializable;
import java.util.List;

public class CountryCompletePagination extends Pagination implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<CountryComplete> countries;

    public CountryCompletePagination(int pageNumber, int limit, int total, int offset, String orderBy, String order, List<PaginationLink> links, List<CountryComplete> countries) {
        super(pageNumber, limit, total, offset, orderBy, order, links);
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "CountryCompletePagination{" +
                "countries=" + countries +
                '}';
    }

    public List<CountryComplete> getCountries() {
        return countries;
    }
}
