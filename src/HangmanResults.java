public class HangmanResults {
    int livesLeft;
    int points;
    boolean gameEnded = false;
    int attempts = 0;

    public HangmanResults(int livesLeft, int points, boolean gameEnded, int attempts) {
        this.livesLeft = livesLeft;
        this.points = points;
        this.gameEnded = gameEnded;
        this.attempts = attempts;
    }

}
