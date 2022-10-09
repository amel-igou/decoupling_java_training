package fr.lernejo.guessgame;

import java.security.SecureRandom;

    public class Launcher {

        private static void error() {
            System.out.println("Vous pouvez utiliser les arguments :");
            System.out.println("-interactive");
            System.out.println("-auto <nombre>");
        }

        public static void main(String[] args) {
            Player p1;
            long max = Long.MAX_VALUE;

            if (args.length == 1) {
                p1 = new HumanPlayer();
            } else if (args.length == 2 && args[0].equals("-auto")) {
                try {
                    Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    error();
                    return;
                }

                p1 = new ComputePlayer();
                max = Integer.parseInt(args[1]);
            } else {
                error();
                return;
            }

            Simulation sim = new Simulation(p1);
            SecureRandom random = new SecureRandom();
            // long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
            long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

            sim.initialize(randomNumber);
            sim.loopUntilPlayerSucceed(max);
        }
    }






}
