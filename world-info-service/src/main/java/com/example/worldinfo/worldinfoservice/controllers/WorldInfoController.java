package com.example.worldinfo.worldinfoservice.controllers;

import com.example.worldinfo.worldinfoservice.entities.Country;
import com.example.worldinfo.worldinfoservice.entities.Language;
import com.example.worldinfo.worldinfoservice.mappers.CountryMapper;
import com.example.worldinfo.worldinfoservice.mappers.LanguageMapper;
import com.example.worldinfo.worldinfoservice.models.responses.menu.ClientMenu;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1")
@RestController
public class WorldInfoController {

    private final LanguageMapper languageMapper;
    private final CountryMapper countryMapper;

    public WorldInfoController(LanguageMapper languageMapper, CountryMapper countryMapper) {
        this.languageMapper = languageMapper;
        this.countryMapper = countryMapper;
    }

    @GetMapping("countries/{countryId}/languages")
    public List<Language> getLanguagesByCountryId(@PathVariable int countryId) {
        return languageMapper.findLanguagesByCountryId(countryId);
    }

    @GetMapping("menu")
    public ClientMenu getMenu() {
        return ClientMenu.createDefault();
    }

    @GetMapping("countries")
    public List<Country> getCountries(
            @RequestParam int limit,
            @RequestParam int offset,
            @RequestParam String property
    ) {
        return countryMapper.findAll(limit, offset, property);
    }

}
