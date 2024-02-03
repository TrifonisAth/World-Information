package com.example.worldinfo.worldinfoservice.models.responses.menu;

import com.example.worldinfo.worldinfoservice.models.responses.actions.Action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Option implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String description;
    private final Set<Action> actions;

    public Option(String name, String description, Set<Action> actions) {
        this.name = name;
        this.description = description;
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Option{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", actions=" + actions +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Action> getActions() {
        return actions;
    }
}
