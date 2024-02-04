package com.example.worldinfo.worldinfoservice.models.responses.menu;

import com.example.worldinfo.worldinfoservice.mappers.CountryMapper;
import com.example.worldinfo.worldinfoservice.models.responses.actions.Action;
import com.example.worldinfo.worldinfoservice.models.responses.actions.ActionParam;
import com.example.worldinfo.worldinfoservice.models.responses.actions.RangeActionParam;
import com.example.worldinfo.worldinfoservice.models.responses.actions.SelectActionParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.*;

public class ClientMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String title;
    private final List<MenuItem> menuItems;

    private ClientMenu(String title, List<MenuItem> menuItems) {
        this.title = title;
        this.menuItems = menuItems;
    }

    public static ClientMenu createDefault() {
        List<MenuItem> menuItems = new ArrayList<>();
        Action act1 = getAction1();
        Action act2 = getAction2();
        Action act3 = getAction3();

        MenuItem menuItem1 = getMenuItem1(act1);
        MenuItem menuItem2 = getMenuItem2(act2);
        MenuItem menuItem3 = getMenuItem3(act3);

        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        menuItems.add(menuItem3);
        return new ClientMenu("Main Menu", menuItems);
    }

    private static Action getAction1() {
        RangeActionParam act1Param1 = new RangeActionParam("limit", "integer", "Countries per page", 10, 50, 10);
        RangeActionParam act1Param2 = new RangeActionParam("offset", "integer", "Number of countries to skip", 0, 500, 1);
        SelectActionParam act1Param3 = new SelectActionParam("property", "string", "Property to order by", Arrays.asList("name", "area", "code"));
        List<ActionParam> act1Params = new ArrayList<>();
        act1Params.add(act1Param1);
        act1Params.add(act1Param2);
        act1Params.add(act1Param3);
        return new Action("ShowCountries",
                "/countries",
                "GET",
                act1Params);
    }

    // TODO: Change later!.
    private static Action getAction2(){
        return new Action("ShowCountriesGDP",
                "/countries/gdp",
                "GET",
                null
        );
    }

    // TODO: Change later!.
    private static Action getAction3(){
        return new Action("ShowContinents",
                "/continents",
                "GET",
                null
        );
    }

    private static MenuItem getMenuItem1(Action act1) {
        return new MenuItem("Display Countries list",
                "Displays the County's name, area and two letter country code in ordered list. "+
                        "The list is paginated. By clicking on a country, the user can see the country's spoken languages. " +
                        "By clicking on a column header, the user can sort the results by that column, ascending or descending.",
                act1);
    }

    // TODO: Change later!.
    private static MenuItem getMenuItem2(Action act2) {
        return new MenuItem("Display GDP list",
                "Displays the Language's name, country code and percentage of speakers in ordered list",
                act2);
    }

    // TODO: Change later!.
    private static MenuItem getMenuItem3(Action act3) {
        return new MenuItem("Display Continents list",
                "Displays the Language's name, country code and percentage of speakers in ordered list",
                act3);
    }

    @Override
    public String toString() {
        return "ClientMenu{" +
                "title='" + title + '\'' +
                ", menuItems=" + menuItems +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
