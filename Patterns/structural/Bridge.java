
public interface Logger {
    void log(String msg);
}

public class ConsoleLogger implements Logger {

    public void log(String msg) {
        System.out.println(msg);
    }
}

public class FileLogger implements Logger {
    String fileName;

    public FileLogger() {
        this.fileName = "log.txt";
    }

    public void log(String msg) {
        try(FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(msg);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

////////////////////////////////////////////

public enum TypeLog {
    CONSOLE,
    FILE
}

////////////////////////////////////////////

public interface LogMsg {
    void log(String msg, TypeLog type);
}

public class InfoLogMsg implements LogMsg {

    public void log(String msg, TypeLog type) {
        Logger logger;

        msg = "INFO: " + msg;
        switch (type) {
            case CONSOLE:
                logger = new ConsoleLogger();
                logger.log(msg);
            case FILE:
                logger = new FileLogger();
                logger.log(msg);
        }
        System.out.println(msg);
    }
}

public class ErrorLogMsg implements LogMsg {

    public void log(String msg, TypeLog type) {
        Logger logger;

        msg = "ERROR: " + msg;
        switch (type) {
            case CONSOLE:
                logger = new ConsoleLogger();
                logger.log(msg);
            case FILE:
                logger = new FileLogger();
                logger.log(msg);
        }
        System.out.println(msg);
    }
}

///////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        LogMsg loggerInfo = new InfoLogMsg();
        loggerInfo.log("Hi", TypeLog.CONSOLE);
    }
}


