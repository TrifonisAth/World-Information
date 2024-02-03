package com.example.worldinfo.worldinfoservice.models.responses.menu;

import com.example.worldinfo.worldinfoservice.models.responses.actions.Action;

import java.io.Serializable;
import java.util.*;

public class ClientMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String title;
    private final List<Option> options;

    private ClientMenu(String title, List<Option> options) {
        this.title = title;
        this.options = options;
    }

    public static ClientMenu createDefault() {
        List<Option> options = new ArrayList<>();

        Action act1 = new Action("ShowCountries",
                "http://localhost:8080/api/v1/countries",
                "GET",
                null);
        // TODO: Change later!.
        Action act2 = new Action("ShowLanguages",
                "http://localhost:8080/api/v1/languages",
                "GET",
                null);
        // TODO: Change later!.
        Action act3 = new Action("ShowCountryLanguages",
                "http://localhost:8080/api/v1/countries/1/languages",
                "GET",
                null);

        Set<Action> set1 = new HashSet<>();
        Set<Action> set2 = new HashSet<>();
        Set<Action> set3 = new HashSet<>();

        set1.add(act1);
        set2.add(act2);
        set3.add(act3);

        Option option1 = new Option("Display Countries list",
                "Displays the County's name, area and two letter country code in ordered list",
                set1);
        // TODO: Change later!.
        Option option2 = new Option("Display Languages list",
                "Displays the Language's name, country code and percentage of speakers in ordered list",
                set2);
        // TODO: Change later!.
        Option option3 = new Option("Display Country's Languages list",
                "Displays the Language's name, country code and percentage of speakers in ordered list",
                set3);

        options.add(option1);
        options.add(option2);
        options.add(option3);
        return new ClientMenu("Main Menu", options);
    }

    @Override
    public String toString() {
        return "ClientMenu{" +
                "title='" + title + '\'' +
                ", options=" + options +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public List<Option> getOptions() {
        return options;
    }
}
