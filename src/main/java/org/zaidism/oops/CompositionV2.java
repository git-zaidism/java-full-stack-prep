package org.zaidism.oops;


// Component interface
interface Formatter {
    String format(String message);
}

// Two implementations
class JsonFormatter implements Formatter {
    @Override
    public String format(String message) {
        return "{\"message\":\"" + message + "\"}";
    }
}

class PlainTextFormatter implements Formatter {
    @Override
    public String format(String message) {
        return "LOG: " + message;
    }
}

// Container class using composition
class Logger {
    private final Formatter formatter;  // Logger has-a Formatter

    public Logger(Formatter formatter) {
        this.formatter = formatter;      // inject desired implementation
    }

    public void log(String message) {
        String output = formatter.format(message);  // delegate formatting
        System.out.println(output);
    }
}

// Demonstration
public class CompositionV2 {
    public static void main(String[] args) {
        // Use JSON formatting
        Logger jsonLogger = new Logger(new JsonFormatter());
        jsonLogger.log("Application started");

        // Switch to plain-text formatting without modifying Logger
        Logger plainLogger = new Logger(new PlainTextFormatter());
        plainLogger.log("Application started");
    }
}
