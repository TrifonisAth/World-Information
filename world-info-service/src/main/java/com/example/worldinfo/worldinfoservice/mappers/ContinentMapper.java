package com.example.worldinfo.worldinfoservice.mappers;

import com.example.worldinfo.worldinfoservice.entities.Continent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContinentMapper {
    @Select("SELECT * FROM continents")
    List<Continent> findAll();
}
