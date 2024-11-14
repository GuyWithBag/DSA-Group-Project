import java.util.ArrayList;

public class Hangman {

    // Returns lives left
    public static HangmanResults start(Globals.Difficulty difficulty) {

        int lives = 6;
        int points = 0;
        int roundsPlayed = 0;
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
            Sys.out("\nGuess a letter: ");
            roundsPlayed++;
            String input = "";

            while (true) {
                input = Sys.in();
                if (!input.isEmpty()) {
                    break;
                }
            }

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
                endGame = true;
            }

        }

        return new HangmanResults(lives, points, endGame, roundsPlayed);
    }
}