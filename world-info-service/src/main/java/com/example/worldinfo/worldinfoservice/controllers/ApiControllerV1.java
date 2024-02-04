package com.example.worldinfo.worldinfoservice.controllers;

import com.example.worldinfo.worldinfoservice.entities.Country;
import com.example.worldinfo.worldinfoservice.entities.Language;
import com.example.worldinfo.worldinfoservice.mappers.CountryMapper;
import com.example.worldinfo.worldinfoservice.mappers.LanguageMapper;
import com.example.worldinfo.worldinfoservice.models.responses.menu.ClientMenu;
import com.example.worldinfo.worldinfoservice.models.responses.pagination.CountryPagination;
import com.example.worldinfo.worldinfoservice.models.responses.pagination.Pagination;
import com.example.worldinfo.worldinfoservice.models.responses.pagination.PaginationLink;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("api/v1")
@RestController
public class ApiControllerV1 {

    private final LanguageMapper languageMapper;
    private final CountryMapper countryMapper;

    public ApiControllerV1(LanguageMapper languageMapper, CountryMapper countryMapper) {
        this.languageMapper = languageMapper;
        this.countryMapper = countryMapper;
    }

    @GetMapping("countries/{countryId}/languages")
    public List<Language> getLanguagesByCountryId(@PathVariable int countryId) {
        countryId = validateInput(countryId, 1, 239);
        return languageMapper.findLanguagesByCountryId(countryId);
    }

    @GetMapping("menu")
    public ClientMenu getMenu() {
        return ClientMenu.createDefault();
    }

    @GetMapping("countries")
    public Pagination getCountries(
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "property", defaultValue = "name") String property,
            @RequestParam(value = "order", defaultValue = "ASC") String order
    ) {
        limit = validateInput(limit, 10, 100);
        offset = validateInput(offset, 0, 238);
        property = validateInput(property, Property.class);
        order = validateInput(order, Order.class);
        return getPagination("/countries", limit, offset, property, order);
    }

    private<T extends Enum<T>> String validateInput(String variable, Class<T> enumClass) {
        for (T value : enumClass.getEnumConstants()) {
            if (value.name().equalsIgnoreCase(variable)) {
                System.out.println("VAR: " + variable + " ENUM: " + value.name());
                return variable;
            }
        }
        return enumClass.getEnumConstants()[0].name().toLowerCase();
    }

    private int validateInput(int value, int min, int max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        }
        return value;
    }

    private Pagination getPagination(String resource, int limit, int offset, String property, String order) {
        List<Country> data = new ArrayList<>(countryMapper.findAll(limit, offset, property, order));
        List<PaginationLink> links = getLinks(resource, limit, offset, property, order);
        return new CountryPagination(
                offset / limit + 1,
                limit,
                countryMapper.getCountriesCount(),
                offset,
                property, order, links, data
        );
    }

    private List<PaginationLink> getLinks(String resource, int limit, int offset, String property, String order) {
        List<PaginationLink> links = new ArrayList<>();
        // TODO: Add logic to handle edge cases. offset + limit > total, offset - limit < 0
        links.add(new PaginationLink("next", resource + "?limit=" + limit + "&offset=" + (offset + limit) + "&property=" + property + "&order=" + order));
        links.add(new PaginationLink("prev", resource + "?limit=" + limit + "&offset=" + (offset - limit) + "&property=" + property + "&order=" + order));
        links.add(new PaginationLink("first", resource + "?limit=" + limit + "&offset=0&property=" + property + "&order=" + order));
        links.add(new PaginationLink("last", resource + "?limit=" + limit + "&offset=" + (countryMapper.getCountriesCount() - limit) + "&property=" + property + "&order=" + order));
        return links;
    }

    private enum Order {
        ASC, DESC
    }

    private enum Property {
        NAME, AREA, CODE
    }
}
