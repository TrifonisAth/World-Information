package com.example.worldinfo.worldinfoservice.entities;

import java.io.Serializable;

public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public boolean isOfficial() {
        return isOfficial;
    }


    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", language='" + language + '\'' +
                ", isOfficial=" + isOfficial +
                '}';
    }
}
