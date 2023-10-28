package com.gamemaster.masterlib.logger;

import com.gamemaster.masterlib.utils.Color;

public class Logger {

    private static String loggerName;
    private static String defaultColor;

    public Logger(String LoggerName) {

        // Stocking Data
        loggerName = LoggerName;
        defaultColor = null;

    }

    /**
     * @param LoggerName Name to show before any log
     * @param Default_Color Use Color interface included in the lib
     * @deprecated Colors could not work on terminal of windows 10
     */
    public Logger(String LoggerName, String Default_Color) {

        // Stocking Data
        loggerName = LoggerName;
        defaultColor = Default_Color;

    }

}
