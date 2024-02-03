package com.example.worldinfo.worldinfoservice.models.responses.menu;

import com.example.worldinfo.worldinfoservice.models.responses.actions.Action;

import java.io.Serializable;

public class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String description;
    private final Action action;

    public MenuItem(String name, String description, Action action) {
        this.name = name;
        this.description = description;
        this.action = action;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", action=" + action +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Action getAction() {
        return action;
    }
}
