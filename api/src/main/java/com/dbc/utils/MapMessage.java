package com.dbc.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedHashMap;

public class MapMessage extends LinkedHashMap<String, Boolean> {
    private static final long serialVersionUID = -5410799397055048515L;
    private static final String __duplicatedOperation = "__duplicatedOperation";

    /*
    * success
    */
    public MapMessage setSuccess(Boolean v) {
        put("success", v);
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return get("success");
    }
}
