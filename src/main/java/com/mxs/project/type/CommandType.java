package com.mxs.project.type;

import java.util.Arrays;

public enum CommandType {
    PROJECT("-proj"),
    DOMAIN("-dom"),
    POJO("-pojo"),
    MAPPER("-map"),
    CLIENT("-cli"),
    REPOSITORY("-rep"),
    USE_CASE("-uc"),
    FACADE("-fac"),
    CONTROLLER("-con"),
    LISTENER("-list"),
    PUBLISH("-pub"),
    UNIT_TEST("-ut"),
    INTEGRATION_TEST("-it");

    private String code;

    CommandType(String code) {
        this.code = code;
    }

    public static CommandType of(String code) {
        return Arrays.stream(values())
                .filter(pair -> pair.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid command type code: " + code));
    }
}
