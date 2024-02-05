package com.example.worldinfo.worldinfoservice.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StatsMapper {
    @Select("SELECT MIN(year) FROM country_stats")
    int findMinYear();

    @Select("SELECT MAX(year) FROM country_stats")
    int findMaxYear();
}
