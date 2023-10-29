package com.gamemaster.masterlib.json;

import com.gamemaster.masterlib.errors.ErrorConverter;
import com.gamemaster.masterlib.errors.ErrorHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.management.DescriptorKey;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_PATH = "default.json";

    @Deprecated
    public static void init(String filename) {
        createNewJsonFile(filename);
    }

    public static void createNewJsonFile(String File_Name) {

        try {
            File file = new File(File_Name);
            if (file.createNewFile()) {
                return;
            } else {
                return;
            }
        } catch (IOException e) {
            String error = ErrorConverter.convertError(e);
            ErrorHandler.show_error(error);
        }

    }

    public static void deleteJsonFile(String file_path) {

        File file = new File(file_path);
        if(file.delete()) {
            return;
        } else {
            ErrorHandler.show_error("Failed to delete the json file");
        }

    }

    public static void writeIntoJson(String file_name, String data_name, String data_value) {
        String file_path = file_name != null ? file_name : FILE_PATH;
        DataObject data = new DataObject(data_name, data_value);
        try (FileWriter writer = new FileWriter(file_path)) {
            gson.toJson(data, writer);
            return;
        } catch (IOException e) {
            String error = ErrorConverter.convertError(e);
            ErrorHandler.show_error(error);
        }
    }

}
