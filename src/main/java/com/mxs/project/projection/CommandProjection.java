package com.mxs.project.projection;

public interface CommandProjection {
    default void log(String[] input) {
        System.out.println(String.join(" ", input));
    }
}
