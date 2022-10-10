package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements player {
    private final Logger logger = LoggerFactory.getLogger("Player");
    @Override
    public long askNextGuess() {
        logger.log("Entrer votre choix");
        Scanner scan=new Scanner(System.in);
        return scan.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        Logger logger = LoggerFactory.getLogger("HumanPlayer");
        if (lowerOrGreater)
            logger.log("plus grand");
        else {
            logger.log("plus petit");
        }
    }
}

