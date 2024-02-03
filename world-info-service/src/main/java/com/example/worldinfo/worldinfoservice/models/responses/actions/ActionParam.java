package com.example.worldinfo.worldinfoservice.models.responses.actions;

import java.io.Serializable;

public abstract class ActionParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String type;
    private final String description;

    public ActionParam(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ActionParam{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
