package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {


    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(player player) {
        this.player=player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess=numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long playernumber = player.askNextGuess();
        if (numberToGuess==playernumber){
            return true;
        }
        else {
            player.respond(playernumber>numberToGuess);
            return false;
        }


    }

    public void loopUntilPlayerSucceed(long maxValue) {
        //TODO implement me
        do {
            nextRound();
        } while (!nextRound());
    }
}


