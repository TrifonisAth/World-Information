package com.example.worldinfo.worldinfoservice.mappers;

import com.example.worldinfo.worldinfoservice.entities.Country;
import com.example.worldinfo.worldinfoservice.entities.CountryComplete;
import com.example.worldinfo.worldinfoservice.entities.CountryWithStats;
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



    @Select(
            "SELECT *, " +
            "   country_code2 AS countryCodeTwoLetters, " +
            "   country_code3 AS countryCodeThreeLetters " +
            "FROM countries c " +
                    "JOIN " +
                    "(SELECT country_id, year, population, gdp, MAX(gdp/population) AS gdp_per_capita " +
                    "FROM country_stats " +
                    "GROUP BY country_id)" +
                    "cs " +
                    "ON c.country_id = cs.country_id " +
                    "ORDER BY ${property} " +  "${order} " +
                    "LIMIT #{limit} OFFSET #{offset}"
    )
    List<CountryWithStats> findAllMaxGdpPerCapital(@PathVariable int limit, @PathVariable int offset, @PathVariable String property, @PathVariable String order);

    @Select(
            "SELECT *, " +
                    "   country_code2 AS countryCodeTwoLetters, " +
                    "   country_code3 AS countryCodeThreeLetters " +
                    "FROM countries c " +
                    "JOIN " +
                    "(SELECT country_id, year, population, gdp " +
                    "FROM country_stats " +
                    ")" +
                    "cs " +
                    "ON c.country_id = cs.country_id " +
                    "ORDER BY ${property} " +  "${order} " +
                    "LIMIT #{limit} OFFSET #{offset}"
    )
    List<CountryWithStats> findAllCompleteDummy(@PathVariable int limit, @PathVariable int offset, @PathVariable String property, @PathVariable String order);


    @Select("SELECT " +
            "    c.name AS continent, " +
            "    r.name AS region, " +
            "    co.name AS country, " +
            "    cs.year, " +
            "    cs.population, " +
            "    cs.gdp " +
            "FROM " +
            "    continents c " +
            "JOIN regions r ON c.continent_id = r.continent_id " +
            "JOIN countries co ON r.region_id = co.region_id " +
            "JOIN (" +
            "    SELECT " +
            "        country_id, " +
            "        year, " +
            "        population, " +
            "        gdp " +
            "    FROM " +
            "        country_stats " +
            "    ORDER BY " +
            "        year DESC " +
            ") cs ON co.country_id = cs.country_id " +
            "ORDER BY country ASC ")
    List<CountryComplete> findAllComplete(@PathVariable int limit, @PathVariable int offset, @PathVariable String property, @PathVariable String order);

    @Select("SELECT COUNT(*) FROM countries")
    int getCountriesCount();
}
