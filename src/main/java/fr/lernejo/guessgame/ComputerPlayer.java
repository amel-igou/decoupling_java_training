package fr.lernejo.guessgame;

public class ComputePlayer implements Player {
    private long lastGuessMax = 100;
    private long lastGuessMin = 0;
    private long lastGuess = 100;

    @Override
    public long askNextGuess() {

        this.lastGuess = lastGuessMin + ((lastGuessMax - lastGuessMin) / 2);

        return this.lastGuess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            this.lastGuessMin = this.lastGuess + 1;
        } else {
            this.lastGuessMax = this.lastGuess - 1;
        }
    }

}
