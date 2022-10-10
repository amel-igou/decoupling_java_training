package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger("launcher");
    public static void main(String[] args){
        Simulation simulation;

        if (args.length == 1 && args[0].equals("-interactive")) {
            HumanPlayer humanPlayer = new HumanPlayer();
            simulation = new Simulation(humanPlayer);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (args.length == 2 && args[0].equals("-auto") && args[1].matches("\\d+")) {
            ComputerPlayer computerPlayer = new ComputerPlayer();
            simulation = new Simulation(computerPlayer);
            long number = Long.parseLong(args[1]);
            simulation.initialize(number);
            simulation.loopUntilPlayerSucceed(1000);
        }
        else {
            logger.log("Vous avez deux chois: si vous voulez jouer avec un humain vous devez choisir -interactive ");
            logger.log("Ou si vous voulez jouer avec un ordinateur vous devez choisir -auto et le deuxième paramétre doit être un numéro ");
        }
    }

}
