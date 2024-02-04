package com.example.worldinfo.worldinfoservice.mappers;

import com.example.worldinfo.worldinfoservice.entities.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface CountryMapper {
    @Select("SELECT *, country_code2 AS countryCodeTwoLetters, country_code3 AS countryCodeThreeLetters " +
            "FROM countries "+
            "ORDER BY ${property} " + "${order} " +
            "LIMIT #{limit} OFFSET #{offset}"
    )
    List<Country> findAll(@PathVariable int limit, @PathVariable int offset, @PathVariable String property, @PathVariable String order);

    @Select("SELECT COUNT(*) FROM countries")
    int getCountriesCount();
}
