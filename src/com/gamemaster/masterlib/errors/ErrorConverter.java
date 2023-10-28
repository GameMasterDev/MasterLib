package com.gamemaster.masterlib.errors;

public class ErrorConverter {

    public static String convertError(Exception e) {
        String error = e.toString();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            error += "\n\tat " + element.toString();
        }
        return error;
    }

}
