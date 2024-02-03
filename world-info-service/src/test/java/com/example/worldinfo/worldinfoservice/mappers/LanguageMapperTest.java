package com.example.worldinfo.worldinfoservice.mappers;

import com.example.worldinfo.worldinfoservice.entities.Language;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LanguageMapperTest {
    @Autowired
    private LanguageMapper mapper;

    @Test
    void findLanguagesByCountryId() {
        short countryId = 1;
        List<Language> languages = mapper.findLanguagesByCountryId(countryId);
        assertFalse(languages.isEmpty());
        assertEquals(4, languages.size());
    }
}