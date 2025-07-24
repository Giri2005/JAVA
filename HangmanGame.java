import java.util.Scanner;

public class HangmanGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = {"java", "hangman", "console", "coding", "object"};
        String word = words[(int)(Math.random() * words.length)];
        char[] guessed = new char[word.length()];
        for (int i = 0; i < guessed.length; i++) {
            guessed[i] = '_';
        }

        int attempts = 6;
        boolean wordGuessed = false;

        System.out.println("Welcome to Hangman Game!");
        System.out.println("Guess the word:");

        while (attempts > 0 && !wordGuessed) {
            System.out.print("Word: ");
            for (char c : guessed) {
                System.out.print(c + " ");
            }
            System.out.println("\nAttempts left: " + attempts);
            System.out.print("Guess a letter: ");
            char guess = sc.next().toLowerCase().charAt(0);

            boolean correct = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess && guessed[i] == '_') {
                    guessed[i] = guess;
                    correct = true;
                }
            }

            if (!correct) {
                attempts--;
                System.out.println("Wrong guess!");
            } else {
                System.out.println("Correct guess!");
            }

            wordGuessed = true;
            for (char c : guessed) {
                if (c == '_') {
                    wordGuessed = false;
                    break;
                }
            }
            System.out.println();
        }

        if (wordGuessed) {
            System.out.print("Congratulations! You guessed the word: ");
            for (char c : guessed) {
                System.out.print(c);
            }
        } else {
            System.out.println("Out of attempts! The word was: " + word);
        }

        sc.close();
    }
}
