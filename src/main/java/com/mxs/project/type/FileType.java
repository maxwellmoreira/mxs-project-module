package com.mxs.project.type;

import java.util.Arrays;

public enum FileType {

    JAVA("java"),
    XML("xml");

    private String code;

    FileType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static FileType of(String code) {
        return Arrays.stream(values())
                .filter(pair -> pair.code.equals(code))
                .findAny().orElseThrow(() -> new IllegalArgumentException("Invalid file type code: " + code));
    }
}
