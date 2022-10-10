package fr.lernejo.guessgame;

    import fr.lernejo.logger.Logger;
    import fr.lernejo.logger.LoggerFactory;

    import java.security.SecureRandom;

public class ComputerPlayer implements player {
    private final Logger logger = LoggerFactory.getLogger("ComputerPlayer");

    @Override
    public long askNextGuess() {
        SecureRandom random = new SecureRandom();
        return random.nextInt(100);
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            logger.log("le numéro entré est plus petit");
        else
            logger.log("le numéro entré est plus grand");
    }
}



