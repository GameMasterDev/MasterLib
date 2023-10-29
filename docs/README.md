<p align="center"> 
  <img src="https://img.shields.io/badge/Version-0.0.60_dev-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Author-GameMasterDev-blue?style=flat-square">
  <img src="https://img.shields.io/badge/Open%20Source-Yes-darkgreen?style=flat-square">
  <img src="https://img.shields.io/badge/Maintained%3F-Yes-lightblue?style=flat-square">
  <img src="https://img.shields.io/badge/Written%20In-Java-orange?style=flat-square">
</p>
<center><h1>MasterLib</h1></center>

## 📜 Description

MasterLib is a java library that contains many libraries with simplified usage, but if you want to fully manage the libraries<br>
i recommend to use them directly. This library is useful if you want to simplify your code.
This Project is under [MIT License](LICENSE)


## 🛠️ Simple Initialization

- Download the latest stable release present on github
- Next add this lib to your project
- Finally, write this on your main file and it's done !

```java
import com.gamemaster.masterlib.MasterLib;
import com.gamemaster.masterlib.logger.Logger;

public class MyMainClass {

  public static Logger logger = new Logger("MyLoggerName"); // We Create the logger

  public static void main(String[] args) {
    // Your Code
    MasterLib.init(logger.getLoggerName()); // This code initialize components, and specify the loggerName
    MasterLib.initJson("config.json"); // This code initialize the json manager and create a file "config.json".
    // Your Code
  }
}
```

## 📁 Documentation
- 🧷 ShortCut
  - [Integrated Logger](#integrated-logger)
  - [Error Handler](#error-handler)
  - [Discord RPC](#discord-rpc)
  - [Gson](#gson)

### Integrated Logger
The Logger is simple to use, you have to create a new Logger and set his name. Now you can log everything, you can <br>
change the color with `logger.log/warn/error("My Message", Color.YELLOW)` for example, but it's deprecated.

```java
import com.gamemaster.masterlib.logger.Logger;
import com.gamemaster.masterlib.utils.Color;

public class Main {

    public static Logger logger = new Logger("MyLoggerName"); // Here we set the Prefix: "[MyLoggerName] my log".
    
    public static void myFunction() {
        // Function Code
        logger.log("MyFunction was used"); // We log that the function was used.
        logger.log("MyFunction was used", Color.GREEN); // We log and change the log color for this time (Deprecated).
        // Function Code
    }
    
    public static void myFunction2() {
        // Function Code
        logger.warn("Warn Message about MyFunction2"); // We warn that it's a little problem about the function.
        logger.warn("Warn Message about MyFunction2", Color.YELLOW); // We log and change the log color for this time (Deprecated).
        // Function Code
    }
    
    public static void myFunction3() {
        // Function Code
        if(error == true) {
            logger.error("Error Message"); // We send the error in the function.
            logger.error("Error Message", Color.RED); // We send the error and change the log color for this time (Deprecated).
        }
        // Function Code
    }
}
```

### Error Handler

This package is to make the error feels cool (not really cool, an error it's bad), the package come with a converter: <br>
`ErrorConverter`, you need to convert your errors before using the handler.

```java
import com.gamemaster.masterlib.errors.ErrorConverter;
import com.gamemaster.masterlib.errors.ErrorHandler;
import com.gamemaster.masterlib.utils.Color;

public class MyClass {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println("Result: " + result); // Here we are causing an error, only to activate the catch function
        } catch (ArithmeticException e) {
            String error = ErrorConverter.convertError(e); // We convert the error
            ErrorHandler.show_error(error); // We show the error
            ErrorHandler.show_error(error, Color.RED); // We show the error with color red (Deprecated)
            
            ErrorHandler.save_error(error); // Here we save error into a log file.
        }
    }
}
```

### Discord RPC

This package isn't optimized but it's work, in a update i will optimize it.<br>
Example Code:

```java
import com.gamemaster.masterlib.rpc.DiscordRpc;

public class MyClass { 
    private static DiscordRpc discord;

    public static void main(String[] args) {
        
        discord = new DiscordRpc(app_id, details, String, state, LargeImageKey, LargeImageText, SmallImageKey, SmallImageText);
        // You can put at the maximum these arguments
        // Now the Discord RPC is launched
        // to stop it only write this:
        discord.destroyRPC();
        // and to get data or change it's simple: 
        String current_state = discord.getState(); // it's the same for all parameters, only change getState to getApplicationId() for example.
        discord.setState("New State"); // it's the same that before
    }
}
```

### Gson

We have implemented gson library, to initialize it you need to add this in your main function: <br>
`MasterLib.initJson("config.json)` here we say config.json it's the default file to create, you can change the file name.<br>
Here how it's work:

```java
import com.gamemaster.masterlib.MasterLib;
import com.gamemaster.masterlib.logger.Logger;
import com.gamemaster.masterlib.json.JsonManager;

public class MyClass {

    public static Logger logger = new Logger("LoggerName");

    public static void main(String[] args) {
        MasterLib.init(logger.getLoggerName()); // Default lib initialization
        MasterLib.initJson("config.json"); // Json Initialization
        
        JsonManager.createNewJsonFile("newJsonFile.json"); // Here we create a new json file
        JsonManager.writeIntoJson("filename.json", "data name", "data value"); // Here we write data into a specified json file
        JsonManager.deleteJsonFile("filename.json"); // Here we delete a json file
    }
}
```

## 🧰 Dependencies

- [Java](https://javadl.oracle.com/webapps/download/AutoDL?BundleId=249203_b291ca3e0c8548b5a51d5a5f50063037)
- [Discord RPC Library](../libs/java-discord-rpc-2.0.1-all.jar)
- [Gson](../libs/gson-2.8.0.jar)