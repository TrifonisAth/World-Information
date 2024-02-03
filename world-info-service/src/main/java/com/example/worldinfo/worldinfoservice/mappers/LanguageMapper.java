package com.example.worldinfo.worldinfoservice.mappers;

import com.example.worldinfo.worldinfoservice.entities.Language;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LanguageMapper {
    @Select("SELECT l.language_id as languageId, language, cl.official as isOfficial " +
            "FROM countries c " +
            "JOIN country_languages cl ON c.country_id = cl.country_id " +
            "JOIN languages l ON cl.language_id = l.language_id " +
            "WHERE c.country_id = #{countryId}")
    List<Language> findLanguagesByCountryId(@Param("countryId") int countryId);
}
