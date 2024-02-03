package com.example.worldinfo.worldinfoservice.models.responses.actions;

import java.io.Serializable;
import java.util.List;

public class Action implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String uri;
    private final String method;
    private final List<ActionParam> params;

    public Action(String name, String uri, String method, List<ActionParam> params) {
        this.name = name;
        this.uri = uri;
        this.method = method;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public String getMethod() {
        return method;
    }

    public List<ActionParam> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                '}';
    }
}
