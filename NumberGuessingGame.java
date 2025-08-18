import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        int numberToGuess = rand.nextInt(100) + 1;
        int attempts = 0;
        int guess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100:");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess > numberToGuess) {
                System.out.println("Too high! Try a lower number.");
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Congratulations! You guessed it in " + attempts + " attempts.");
            }

        } while (guess != numberToGuess);

        scanner.close();
    }
}
