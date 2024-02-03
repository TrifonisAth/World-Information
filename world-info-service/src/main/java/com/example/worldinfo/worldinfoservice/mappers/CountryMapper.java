package com.example.worldinfo.worldinfoservice.mappers;

import com.example.worldinfo.worldinfoservice.entities.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CountryMapper {
    @Select("SELECT *, country_code2 AS countryCodeTwoLetters, country_code3 AS countryCodeThreeLetters FROM countries")
    List<Country> findAll();
}
