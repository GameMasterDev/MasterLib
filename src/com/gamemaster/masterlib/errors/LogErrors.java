package com.gamemaster.masterlib.errors;

//import com.gamemaster.masterlib.logger.Logger;

import com.gamemaster.masterlib.logger.Logger;
import com.gamemaster.masterlib.utils.Color;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class LogErrors {

    private static Logger logger = new Logger("Error Handler Logger");

    private static String logFileName = "error_logs.log";
    private static FileHandler fileHandler;

    public static void init() {
        try {
            fileHandler = new FileHandler(logFileName, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addFileHandler(String.valueOf(fileHandler));
        } catch (SecurityException | IOException e) {
            logger.error("Error while initializing LogErrors: " + e.getMessage());
        }
    }

    public static void write(String error) {

        if (fileHandler != null) {
            logger.error(error);
        } else {
            System.err.println("Error handler is not initialized.");
        }
    }

    public static void console_error(String error) {
        System.out.println("---------------------------------------");
        System.out.println("There was an error !");
        System.out.println("Full Error: ");
        System.out.println(error);
        System.out.println("---------------------------------------");
    }

    @Deprecated
    public static void console_error(String error, String color) {
        System.out.println(color + "---------------------------------------");
        System.out.println("There was an error !");
        System.out.println("Full Error: ");
        System.out.println(error);
        System.out.println("---------------------------------------" + Color.RESET);
    }

}
