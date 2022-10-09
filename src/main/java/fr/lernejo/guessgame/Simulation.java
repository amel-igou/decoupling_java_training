package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("Simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long nbr = this.player.askNextGuess();
        if (nbr < this.numberToGuess)
            player.respond(true);
        if (nbr > this.numberToGuess)
            player.respond(false);
        return nbr == this.numberToGuess;
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        int iter = 0;
        LocalDateTime time = LocalDateTime.now();
        logger.log("Devinez le nombre entre 0 et 100");
        while (!nextRound() && iter < maxIterations) {
            iter++;
        }
        Duration diff = Duration.between(time, LocalDateTime.now());
        logger.log(String.format("%02d:%02d.%03d", diff.toMinutesPart(), diff.toSecondsPart(), diff.toMillisPart()));
        if (iter >= maxIterations)
            logger.log("Bouuh tu a perdu");
        else
            logger.log("Félicitations tu as trouvé !");
    }
}
