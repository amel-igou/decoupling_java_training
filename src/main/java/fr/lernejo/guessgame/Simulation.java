package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final player player;
    private long numberToGuess;


    public Simulation(player player) {
        this.player = player;
        //TODO implement me
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
        //TODO implement me
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long number = player.askNextGuess();

        if (number==numberToGuess){
            logger.log("Vous avez deviné le bon numéro");
            return true;
        }

        player.respond(number<numberToGuess);
        return false;
    }

    public void loopUntilPlayerSucceed(long maxIter) {
        long i = 0;
        long start = System.currentTimeMillis();
        boolean response;

        do{
            response = this.nextRound();
            if (i>=maxIter)
                break;
            i++;
        }while(!response);

        long end = System.currentTimeMillis();
        long gameTime = end - start;
        long minutes = gameTime / 60000;
        gameTime %= 60000;
        long seconds = gameTime / 1000;
        gameTime %= 1000;
        long milliseconds = gameTime;
        logger.log(String.format("%02d:%02d.%d", minutes, seconds, milliseconds));
        if (response)
            logger.log("Félicitations tu as trouvé !");
        else
            logger.log("Bouuh tu a perdu");

    }

}
