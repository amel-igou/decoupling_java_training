package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        return new ContextualLogger(
            name,
            new CompositeLogger(
                new ConsoleLogger(),
                new FilteredLogger(
                    new FileLogger("output.txt"),
                    message -> message.contains("Simulation")
                )
            )
        );
    }
}
