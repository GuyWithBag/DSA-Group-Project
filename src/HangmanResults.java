public class HangmanResults {
    int livesLeft;
    int points;
    boolean gameEnded = false;
    int roundsPlayed = 0;

    public HangmanResults(int livesLeft, int points, boolean gameEnded, int roundsPlayed) {
        this.livesLeft = livesLeft;
        this.points = points;
        this.gameEnded = gameEnded;
        this.roundsPlayed = roundsPlayed;
    }

}
