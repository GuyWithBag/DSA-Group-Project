import java.util.ArrayList;

public class Hangman {

    // Returns lives left
    public static HangmanResults start(Globals.Difficulty difficulty, Globals.GameMode gameMode) {

        int lives = 6;
        int points = 0;
        int attempts = 0;
        final ArrayList<Character> guesses = new ArrayList<>();

        if (difficulty == Globals.Difficulty.HARD) {
            lives = 4;
        }

        Word chosenWord = Assets.getRandomWord();

        boolean endGame = false;
        final char[] guessedLetters = new char[chosenWord.value.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        while (!endGame) {
            Sys.outln(Assets.stages[lives]);
            Sys.outln("\n" + String.valueOf(guessedLetters));
            Sys.outln("\n---------------------------------\nWord Description: \n" + chosenWord.description
                    + "\n-----------------------------\n");
            Sys.outln("\nGuessed Letters: " + String.valueOf(guesses));
            attempts++;
            String input = "";

            while (true) {
                if (gameMode == Globals.GameMode.INFINITE_MODE) {
                    Sys.outln("Type -1 to End Game");
                }
                Sys.out("\nGuess a letter: ");

                input = Sys.in();

                if (!input.isEmpty()) {
                    break;
                }

            }

            if (input.equals("-1")) {
                Sys.outln("aasdsadsadsadsadsadsa");
                Game.backToMenu();
                endGame = true;
                return new HangmanResults(0, 0, endGame, 0);
            }
            Sys.outln(input);

            final char guess = input.toLowerCase().charAt(0);
            guesses.add(guess);

            for (int index = 0; index < chosenWord.value.length(); index++) {
                char letter = chosenWord.value.charAt(index);
                if (guess == letter) {
                    guessedLetters[index] = letter;
                }
            }

            if (chosenWord.value.indexOf(guess) == -1) {
                lives--;
            }

            if (lives == 0) {
                Sys.outln("\nYou lose!");
                Sys.outln("\nThe Word is: " + chosenWord.value);
                endGame = true;
            }

            if (new String(guessedLetters).indexOf('_') == -1) {
                Sys.outln("\nYou Won!");
                points++;
                endGame = true;
            }

        }

        return new HangmanResults(lives, points, endGame, attempts);
    }
}