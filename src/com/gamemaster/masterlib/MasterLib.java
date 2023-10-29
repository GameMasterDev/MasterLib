package com.gamemaster.masterlib;

import com.gamemaster.masterlib.errors.ErrorHandler;
import com.gamemaster.masterlib.json.JsonManager;
import com.gamemaster.masterlib.logger.Logger;

public class MasterLib {

    public static void init(String loggerName) {

        // Starting Components
        ErrorHandler.init(loggerName);

    }

    public static void initJson(String FileName) {
        JsonManager.init(FileName);
    }

}
