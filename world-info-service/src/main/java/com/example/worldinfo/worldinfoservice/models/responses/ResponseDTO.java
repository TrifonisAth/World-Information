package com.example.worldinfo.worldinfoservice.models.responses;

import com.example.worldinfo.worldinfoservice.models.responses.actions.Action;

import java.io.Serializable;
import java.util.List;

public class ResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Object data;
    private final List<Action> actions;

    public ResponseDTO(Object data, List<Action> actions) {
        this.data = data;
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "data=" + data +
                ", actions=" + actions +
                '}';
    }

    public Object getData() {
        return data;
    }

    public List<Action> getActions() {
        return actions;
    }
}
