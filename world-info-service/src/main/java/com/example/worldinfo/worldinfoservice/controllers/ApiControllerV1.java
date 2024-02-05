package com.example.worldinfo.worldinfoservice.controllers;

import com.example.worldinfo.worldinfoservice.entities.Country;
import com.example.worldinfo.worldinfoservice.entities.CountryWithStats;
import com.example.worldinfo.worldinfoservice.entities.Language;
import com.example.worldinfo.worldinfoservice.mappers.CountryMapper;
import com.example.worldinfo.worldinfoservice.mappers.LanguageMapper;
import com.example.worldinfo.worldinfoservice.mappers.RegionMapper;
import com.example.worldinfo.worldinfoservice.mappers.StatsMapper;
import com.example.worldinfo.worldinfoservice.models.FilterSettings;
import com.example.worldinfo.worldinfoservice.models.responses.menu.ClientMenu;
import com.example.worldinfo.worldinfoservice.models.responses.pagination.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("api/v1")
@RestController
public class ApiControllerV1 {

    private final LanguageMapper languageMapper;
    private final CountryMapper countryMapper;
    private final StatsMapper statsMapper;
    private final RegionMapper regionMapper;

    public ApiControllerV1(LanguageMapper languageMapper, CountryMapper countryMapper, StatsMapper statsMapper, RegionMapper regionMapper) {
        this.languageMapper = languageMapper;
        this.countryMapper = countryMapper;
        this.statsMapper = statsMapper;
        this.regionMapper = regionMapper;
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
        List<Country> data = countryMapper.findAll(limit, offset, property, order);
        List<PaginationLink> links = getLinks("/countries", limit, offset, property, order);
        return new CountryPagination(
                offset / limit + 1,
                limit,
                countryMapper.getCountriesCount(),
                offset,
                property, order, links, data
        );
    }

    @GetMapping("countries/{countryId}/languages")
    public List<Language> getLanguagesByCountryId(@PathVariable int countryId) {
        countryId = validateInput(countryId, 1, 239);
        return languageMapper.findLanguagesByCountryId(countryId);
    }

    @GetMapping("countries/stats")
    public Pagination getCountriesWithGdp(
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "property", defaultValue = "name") String property,
            @RequestParam(value = "order", defaultValue = "ASC") String order
    ) {
        limit = validateInput(limit, 10, 100);
        offset = validateInput(offset, 0, 202);
        property = validateInput(property, PropertyWithStats.class);
        order = validateInput(order, Order.class);
        List<CountryWithStats> data = countryMapper.findAllMaxGdpPerCapital(limit, offset, property, order);
        List<PaginationLink> links = getLinks("/countries/stats", limit, offset, property, order);
        return new CountryWithStatsPagination(
                offset / limit + 1,
                limit,
                203,
                offset,
                property, order, links, data
        );
    }

    @GetMapping("countries/complete")
    public Pagination getCountriesComplete(
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "property") String property,
            @RequestParam(value = "order", defaultValue = "ASC") String order,
            @RequestParam(value = "from") int from,
            @RequestParam(value = "to") int to,
            @RequestParam(value = "regions") String regionStr
    ) {
        limit = validateInput(limit, 10, 100);
        offset = validateInput(offset, 0, 9513);
        property = validateInput(property, PropertyDummy.class);
        order = validateInput(order, Order.class);
        List<String> regions = new ArrayList<>();
        if (regionStr != null) {
            regions.addAll(Arrays.asList(regionStr.split(",")));
        }
        // TODO: The query of the mapper has to be fixed.
//        List<CountryComplete> data = countryMapper.findAllComplete(limit, offset, property, order);
        // TODO: Dummy data for now.
        List<CountryWithStats> data = countryMapper.findAllCompleteDummy(limit, offset, property, order, from, to, regions);
        int total = countryMapper.getDummyCount(limit, offset, property, order, from, to, regions);
        List<PaginationLink> links = getLinks(limit, offset, property, order, from, to, regionStr);
        return new CountryWithStatsPagination(
                offset / limit + 1,
                limit,
                total,
                offset,
                property, order, links, data
        );
//                return new CountryCompletePagination(
//                offset / limit + 1,
//                limit,
//                9513,
//                offset,
//                property, order, links, data
//        );
    }

    @GetMapping("filter/settings")
    public FilterSettings getFilterSettings() {
        int minYear = statsMapper.findMinYear();
        int maxYear = statsMapper.findMaxYear();
        List<String> regions = regionMapper.findAll();
        return new FilterSettings(minYear, maxYear, regions);
    }

    private<T extends Enum<T>> String validateInput(String variable, Class<T> enumClass) {
        for (T value : enumClass.getEnumConstants()) {
            if (value.name().equalsIgnoreCase(variable)) {
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


    private List<PaginationLink> getLinks(String resource, int limit, int offset, String property, String order) {
        List<PaginationLink> links = new ArrayList<>();
        int count = 239;
        if (resource.equals("/countries/stats")) {
            count = 203;
        }
        links.add(new PaginationLink("next", resource + "?limit=" + limit + "&offset=" + (offset + limit) + "&property=" + property + "&order=" + order));
        links.add(new PaginationLink("prev", resource + "?limit=" + limit + "&offset=" + (offset - limit) + "&property=" + property + "&order=" + order));
        links.add(new PaginationLink("first", resource + "?limit=" + limit + "&offset=0&property=" + property + "&order=" + order));
        links.add(new PaginationLink("last", resource + "?limit=" + limit + "&offset=" + (count - limit) + "&property=" + property + "&order=" + order));
        return links;
    }

    private List<PaginationLink> getLinks(int limit, int offset, String property, String order, int from, int to, String regionStr) {
        List<PaginationLink> links = new ArrayList<>();
        int count = 9514;
        links.add(new PaginationLink("next", "/countries/complete" + "?limit=" + limit + "&offset=" + (offset + limit) + "&property=" + property + "&order=" + order + "&from=" + from + "&to=" + to + "&region=" + regionStr));
        links.add(new PaginationLink("prev", "/countries/complete" + "?limit=" + limit + "&offset=" + (offset - limit) + "&property=" + property + "&order=" + order + "&from=" + from + "&to=" + to + "&region=" + regionStr));
        links.add(new PaginationLink("first", "/countries/complete" + "?limit=" + limit + "&offset=0&property=" + property + "&order=" + order + "&from=" + from + "&to=" + to + "&region=" + regionStr));
        links.add(new PaginationLink("last", "/countries/complete" + "?limit=" + limit + "&offset=" + (count - limit) + "&property=" + property + "&order=" + order + "&from=" + from + "&to=" + to + "&region=" + regionStr));
        return links;
    }

    private enum Order {
        ASC, DESC
    }

    private enum Property {
        NAME, AREA, COUNTRY_CODE2
    }

    private enum PropertyWithStats {
        NAME, COUNTRY_CODE3, YEAR, POPULATION, GDP, GDP_PER_CAPITA
    }

    private enum PropertyFull {
        NAME, CONTINENT, REGION, YEAR, POPULATION, GDP
    }

    private enum PropertyDummy {
        NAME, COUNTRY_CODE3, YEAR, POPULATION, GDP
    }
}
