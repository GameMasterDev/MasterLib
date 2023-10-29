package com.gamemaster.masterlib.errors;

import java.io.IOException;

public class ErrorHandler {

    public static void init(String logger) {
        LogErrors.init(logger);
    }

    public static void save_error(String error) {
        LogErrors.write(error);
    }

    public static void show_error(String error) {
        LogErrors.console_error(error);
    }

    @Deprecated
    public static void show_error(String error, String color) {
        LogErrors.console_error(error, color);
    }

}
