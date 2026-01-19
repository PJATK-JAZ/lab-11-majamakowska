package com.westeros.diagnostics.services.contract;

import lombok.Data;

@Data
public class Diagnostics {
    private boolean isSuccess;
    private String name;
    private String errorMessage;
    private String description;

    public static Diagnostics Success(String name, String description) {
        Diagnostics d = new Diagnostics();
        d.setSuccess(true);
        d.setName(name);
        d.setDescription(description);
        return d;
    }

    public static Diagnostics Failure(String name, String errorMessage) {
        Diagnostics d = new Diagnostics();
        d.setSuccess(false);
        d.setName(name);
        d.setErrorMessage(errorMessage);
        return d;
    }
}
