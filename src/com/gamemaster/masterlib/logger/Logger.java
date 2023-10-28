package com.gamemaster.masterlib.logger;

import com.gamemaster.masterlib.utils.Color;
import com.gamemaster.masterlib.utils.interfaces.Note;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Logger {

    private static String loggerName;
    private static String defaultColor;
    private static FileHandler fileHandler;

    /**
     * @param LoggerName Name to show before any log
     */
    @Note("To create the logger")
    public Logger(String LoggerName) {

        // Stocking Data
        loggerName = LoggerName;
        defaultColor = null;

    }

    @Note("Log")
    public void log(String log) {
        System.out.println("[" + loggerName + "] " + log);
    }

    @Note("Log with Color")
    @Deprecated
    public void log(String log, String color) {
        if(color != null) {
            if(color != Color.BLACK | color != Color.BLUE | color != Color.CYAN | color != Color.RED | color != Color.GREEN | color != Color.PURPLE | color != Color.WHITE | color != Color.YELLOW) {
                warn("You have set a incorrect color when you used the \'log(String log, String color);\' function, use Color Interface integred on the lib please.");
                log(log);
            } else {
                System.out.println(color + "[" + loggerName + "] " + log + Color.RESET);
            }
        }
    }

    @Note("Log a Warn")
    public void warn(String warn) {
        System.out.println("[" + loggerName + "/WARN] " + warn);
    }

    @Note("Log a Warn with color")
    @Deprecated
    public void warn(String warn, String color) {
        if(color != null) {
            if(color != Color.BLACK | color != Color.BLUE | color != Color.CYAN | color != Color.RED | color != Color.GREEN | color != Color.PURPLE | color != Color.WHITE | color != Color.YELLOW) {
                warn("You have set a incorrect color when you used the \'warn(String warn, String color);\' function, use Color Interface integred on the lib please.");
                warn(warn);
            } else {
                System.out.println(color + "[" + loggerName + "/WARN] " + warn + Color.RESET);
            }
        }

    }

    @Note("Log an Error")
    public void error(String error) {
        System.out.println("[" + loggerName + "/ERROR] " + error);
    }

    @Note("Log an Error with color")
    @Deprecated
    public void error(String error, String color) {
        if(color != null) {
            if(color != Color.BLACK | color != Color.BLUE | color != Color.CYAN | color != Color.RED | color != Color.GREEN | color != Color.PURPLE | color != Color.WHITE | color != Color.YELLOW) {
                error("You have set a incorrect color when you used the \'error(String error, String color);\' function, use Color Interface integred on the lib please.");
                error(error);
            } else {
                System.out.println(color + "[" + loggerName + "/ERROR] " + error + Color.RESET);
            }
        }
    }

    public void addFileHandler(String fileName) {
        try {
            fileHandler = new FileHandler(fileName);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logToFile(String message) {
        if (fileHandler != null) {
            fileHandler.publish(new java.util.logging.LogRecord(java.util.logging.Level.INFO, message));
        } else {
            System.err.println("File handler is not initialized.");
        }
    }

    /**
     * @return logger name set when creating new logger
     */
    @Note("Maybe useful")
    public String getLoggerName() {
        return loggerName;
    }

    /**
     * @return logger default color
     */
    @Note("Maybe useful")
    public String getDefaultColor() {
        return "\\" + defaultColor;
    }

}
