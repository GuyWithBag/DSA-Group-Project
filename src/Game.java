public class Game {

    int rounds = 0;
    final GameStatistics statistics = new GameStatistics();

    Globals.Difficulty chosenDifficulty;
    Globals.GameState gameState = Globals.GameState.CONTINUE;

    private Game(int rounds) {
        this.rounds = rounds;
    }

    public static Game start(int rounds) {
        Game game = new Game(rounds);

        while (game.gameState == Globals.GameState.CONTINUE) {
            game.gameLoop();
        }

        Sys.outln("Game has ended. Thank you for playing!");

        return game;
    }

    private void gameLoop() {
        String introductionDisplay = "\nWelcome to\n" +
                Assets.logo +
                "\nTotal score: " + statistics.score +
                "\nTotal wins: " + statistics.winCount +
                "\nTotal losts: " + statistics.loseCount +
                "\nRounds played: " + statistics.roundsPlayed +
                "\nGames played: " + statistics.gamesPlayed +
                "\n";
        Globals.MenuOptions chosenOption = Sys.inputLoop(Globals.MenuOptions.class, introductionDisplay);

        if (chosenOption == Globals.MenuOptions.EXIT) {
            exitGame();
            return;
        } else if (chosenOption == Globals.MenuOptions.SHOW_ME_A_RANDOM_WORD) {
            Sys.outln("\n" + Assets.getRandomWord().value + "\n");
            return;
        }

        statistics.gamesPlayed++;

        chosenDifficulty = Sys.inputLoop(Globals.Difficulty.class, "Choose a difficulty");

        if (chosenDifficulty == Globals.Difficulty.EASY) {
            rounds = 1;
        } else if (chosenDifficulty == Globals.Difficulty.NORMAL) {
            rounds = 2;
        } else {
            rounds = 3;
        }

        for (int i = 0; i < rounds; i++) {
            Sys.outln("\nRound " + (i + 1) + " / " + rounds);
            // int livesLeft = Hangman.start();
            HangmanResults results = Hangman.start(chosenDifficulty);
            statistics.score += results.points;
            statistics.roundsPlayed += results.roundsPlayed;

            if (results.livesLeft == 0) {
                loseGame();
                break;
            } else if (results.gameEnded) {
                winGame();
            }
        }

        return;
    }

    private void exitGame() {
        gameState = Globals.GameState.EXIT;
    }

    private void loseGame() {
        statistics.loseCount++;
        Sys.outln("You have ran out of lives.");
    }

    private void winGame() {
        statistics.winCount++;
        Sys.outln("Congrats, you have won!");
    }

}
