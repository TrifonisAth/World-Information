package com.example.worldinfo.worldinfoservice.models.responses.error;

import java.io.Serializable;

public class Error implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int code;
    private final String message;
    private final String details;

    public Error(int code, String message, String details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
