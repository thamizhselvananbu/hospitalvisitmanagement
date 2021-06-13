package com.allm.hospitals;


public final class ValidatorUtils {

    private ValidatorUtils() {
        //nothing to initialize
    }

    public static boolean notNull(final Object object) {
        return object != null;
    }

    public static boolean notEmpty(final String value) {
        return value != null;
    }
}
