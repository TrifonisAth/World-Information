package com.example.worldinfo.worldinfoservice.entities;

public class Language {
    private final int languageId;
    private final String language;
    private final boolean isOfficial;

    public Language(int languageId, String language, boolean isOfficial) {
        this.languageId = languageId;
        this.language = language;
        this.isOfficial = isOfficial;
    }

    public int getLanguageId() {
        return languageId;
    }

    public String getLanguage() {
        return language;
    }

    public boolean getIsOfficial() {
        return isOfficial;
    }
}
