package com.example.worldinfo.worldinfoservice.models.responses.actions;

import java.util.List;

public class SelectActionParam extends ActionParam{
    private final List<String> options;

    public SelectActionParam(String name, String type, String description, List<String> options) {
        super(name, type, description);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "SelectActionParam{" +
                "options=" + options +
                '}';
    }
}
