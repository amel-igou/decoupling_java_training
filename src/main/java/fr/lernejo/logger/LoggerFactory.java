package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Logger logger = new ConsoleLogger();
        return logger;
    }
}
