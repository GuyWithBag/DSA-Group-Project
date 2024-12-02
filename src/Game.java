public class Game {

    static int rounds = 0;
    static final GameStatistics statistics = new GameStatistics();

    static Globals.Difficulty chosenDifficulty = Globals.Difficulty.NORMAL;
    static Globals.GameState gameState = Globals.GameState.MENU;
    static Globals.GameMode chosenGameMode;

    public static void start(int rounds) {
        while (gameState != Globals.GameState.EXIT) {
            if (gameState == Globals.GameState.MENU) {
                menuLoop();
            } else if (gameState == Globals.GameState.GAMEPLAY) {
                gameplayLoop();
            }

        }

        Sys.outln("Game has ended. Thank you for playing!");

    }

    private static void menuLoop() {
        String introductionDisplay = "\nWelcome to\n" +
                Assets.logo +
                "\nTotal score: " + statistics.score +
                "\nTotal wins: " + statistics.winCount +
                "\nTotal losts: " + statistics.loseCount +
                "\nRounds played: " + statistics.roundsPlayed +
                "\nAttempts At Hangman: " + statistics.attemptsAtHangman +
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

        chosenGameMode = Sys.inputLoop(Globals.GameMode.class, "Choose a difficulty");

        if (chosenGameMode == Globals.GameMode.NORMAL) {

            chosenDifficulty = Sys.inputLoop(Globals.Difficulty.class, "Choose a difficulty");

            if (chosenDifficulty == Globals.Difficulty.EASY) {
                rounds = 1;
            } else if (chosenDifficulty == Globals.Difficulty.NORMAL) {
                rounds = 2;
            } else {
                rounds = 3;
            }
        } else {
            rounds = 99999;
        }
        stateToGameplay();

        statistics.gamesPlayed++;

    }

    private static void gameplayLoop() {
        for (int i = 0; i < rounds; i++) {
            if (chosenGameMode == Globals.GameMode.NORMAL) {
                Sys.outln("\nRound " + (i + 1) + " / " + rounds);

            } else {
                Sys.outln("\nRound " + (i + 1));

            }

            // int livesLeft = Hangman.start();
            HangmanResults results = Hangman.start(chosenDifficulty, chosenGameMode);
            statistics.score += results.points;
            statistics.roundsPlayed++;
            statistics.attemptsAtHangman += results.attempts;

            if (results.livesLeft == 0) {
                loseGame();
                break;
            } else if (results.gameEnded) {
                winGame();
            }
        }
    }

    public static void exitGame() {
        gameState = Globals.GameState.EXIT;
    }

    public static void backToMenu() {
        gameState = Globals.GameState.MENU;
    }

    private static void stateToGameplay() {
        gameState = Globals.GameState.GAMEPLAY;
    }

    private static void loseGame() {
        statistics.loseCount++;
        Sys.outln("You have ran out of lives.");
        backToMenu();
    }

    private static void winGame() {
        statistics.winCount++;
        Sys.outln("Congrats, you have won!");
        backToMenu();
    }

}
