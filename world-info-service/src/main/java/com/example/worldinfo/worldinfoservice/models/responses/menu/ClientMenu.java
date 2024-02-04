package com.example.worldinfo.worldinfoservice.models.responses.menu;

import com.example.worldinfo.worldinfoservice.models.responses.actions.Action;
import com.example.worldinfo.worldinfoservice.models.responses.actions.ActionParam;
import com.example.worldinfo.worldinfoservice.models.responses.actions.RangeActionParam;
import com.example.worldinfo.worldinfoservice.models.responses.actions.SelectActionParam;

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
        Action act1 = getPaginationAction("ShowCountries", "/countries", Arrays.asList("name", "area", "country_code2"));
        Action act2 = getPaginationAction("ShowCountriesStats", "/countries/stats", Arrays.asList("name", "country_code3", "year", "population", "gdp", "gdp_per_capita"));
//      TODO: Uncomment later, when the query is ready.
//        Action act3 = getPaginationAction("ShowAll", "/countries/complete", Arrays.asList("continent", "region", "country", "year", "population", "gdp"));
        Action act3 = getPaginationAction("ShowAll", "/countries/complete", Arrays.asList("name", "country_code3", "year", "population", "gdp", "gdp_per_capita"));
        MenuItem menuItem1 = getMenuItem1(act1);
        MenuItem menuItem2 = getMenuItem2(act2);
        MenuItem menuItem3 = getMenuItem3(act3);

        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        menuItems.add(menuItem3);
        return new ClientMenu("Main Menu", menuItems);
    }

    private static Action getPaginationAction(String name, String uri, List<String> properties) {
        RangeActionParam act1Param1 = new RangeActionParam("limit", "integer", "Countries per page", 10, 50, 10);
        RangeActionParam act1Param2 = new RangeActionParam("offset", "integer", "Number of countries to skip", 0, 500, 1);
        SelectActionParam act1Param3 = new SelectActionParam("property", "string", "Property to order by", properties);
        SelectActionParam act1Param4 = new SelectActionParam("order", "string", "Order", Arrays.asList("ASC", "DESC"));
        List<ActionParam> act1Params = new ArrayList<>();
        act1Params.add(act1Param1);
        act1Params.add(act1Param2);
        act1Params.add(act1Param3);
        act1Params.add(act1Param4);
        return new Action(name,
                uri,
                "GET",
                act1Params);
    }

    private static MenuItem getMenuItem1(Action act1) {
        return new MenuItem("Display Countries list",
                "Displays the County's name, area and two letter country code in ordered list. "+
                        "The list is paginated. By clicking on a country, the user can see the country's spoken languages. " +
                        "By clicking on a column header, the user can sort the results by that column, ascending or descending.",
                act1);
    }

    private static MenuItem getMenuItem2(Action act2) {
        return new MenuItem("Display Countries Stats table",
                "Displays the Country's stats based on the year with the highest GDP per capita. " +
                        "The list is paginated. By clicking on a column header, the user can sort the results by that column, ascending or descending.",
                act2);
    }

    // TODO: Change later!.
    private static MenuItem getMenuItem3(Action act3) {
        return new MenuItem("Display All Countries Stats table with Continents and Regions",
                "Displays every year's stats for every country." +
                        "The list is paginated. By clicking on a column header, the user can sort the results by that column, ascending or descending.",
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
