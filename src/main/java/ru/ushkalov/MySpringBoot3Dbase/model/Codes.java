package ru.ushkalov.MySpringBoot3Dbase.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Codes {
    SUCCESS("success"),
    ERROR("error");

    private String code;


    Codes(String code) {
        this.code = code;
    }
    @JsonValue
    public String getCode() {
        return code;
    }


    @Override
    public String toString() {
        return code;
    }
}
