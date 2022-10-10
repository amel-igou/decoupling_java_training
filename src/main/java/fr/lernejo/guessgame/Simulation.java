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

        boolean  Manou;
        //TODO implement me
        int i = 0;
        long start=System.currentTimeMillis();
        do {
            Manou= this.nextRound();

            if (i>=maxValue)
                break;
            i++;
        } while (!Manou);
        long end = System.currentTimeMillis();

        long gameTime = end - start;
        long minutes = gameTime / 60000;
        gameTime %= 60000;
        long seconds = gameTime / 1000;
        gameTime %= 1000;
        long milliseconds = gameTime;
        logger.log(String.format("%02d:%02d.%d", minutes, seconds, milliseconds));
        if(Manou)
            logger.log("Félicitation tu as gagné");
        else
            logger.log("Oups tu as perdu");

    }
}




