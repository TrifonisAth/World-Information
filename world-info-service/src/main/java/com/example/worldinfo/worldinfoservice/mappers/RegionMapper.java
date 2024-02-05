package com.example.worldinfo.worldinfoservice.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegionMapper {
    @Select("SELECT name FROM regions")
    List<String> findAll();
}
