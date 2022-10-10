package fr.lernejo.logger;

    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private final String className;
    private final Logger otherLogger;

    public ContextualLogger(String className, Logger otherLogger) {

        this.className = className;
        this.otherLogger = otherLogger;
    }

    @Override
    public void log(String message) {
//        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        otherLogger.log(LocalDateTime.now().format(formatter) + " " + className + " " + message);
        //* String newMessage = "[" + now.format(formatter) + "] {" + this.className + "}" + message;
       //* this.otherLogger.log(newMessage);
    }
}
