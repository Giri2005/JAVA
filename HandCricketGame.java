import java.util.Random;
import java.util.Scanner;

public class HandCricketGame {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to Hand Cricket Game!");
        System.out.println("Toss Time - Choose Odd or Even");

        String tossChoice;
        while (true) {
            System.out.print("Enter your choice (Odd/Even): ");
            tossChoice = scanner.next().toLowerCase();
            if (tossChoice.equals("odd") || tossChoice.equals("even")) {
                break;
            }
            System.out.println("Invalid choice. Please choose Odd or Even.");
        }

        System.out.print("Enter your toss number (1-6): ");
        int userTossNumber = scanner.nextInt();
        int compTossNumber = random.nextInt(6) + 1;
        System.out.println("Computer toss number: " + compTossNumber);

        int tossSum = userTossNumber + compTossNumber;
        boolean userWonToss = (tossSum % 2 == 0 && tossChoice.equals("even")) ||
                              (tossSum % 2 != 0 && tossChoice.equals("odd"));

        boolean userBatsFirst;
        if (userWonToss) {
            System.out.println("You won the toss!");
            while (true) {
                System.out.print("Choose to Bat or Bowl first: ");
                String choice = scanner.next().toLowerCase();
                if (choice.equals("bat")) {
                    userBatsFirst = true;
                    break;
                } else if (choice.equals("bowl")) {
                    userBatsFirst = false;
                    break;
                } else {
                    System.out.println("Invalid choice. Choose Bat or Bowl.");
                }
            }
        } else {
            System.out.println("Computer won the toss!");
            userBatsFirst = random.nextBoolean();
            System.out.println("Computer chooses to " + (userBatsFirst ? "bowl" : "bat") + " first.");
        }

        int playerScore, computerScore;

        if (userBatsFirst) {
            System.out.println("You are batting first.");
            playerScore = playInnings(true, -1);
            System.out.println("Your innings ended. You scored: " + playerScore);
            System.out.println("Computer needs " + (playerScore + 1) + " runs to win.");
            computerScore = playInnings(false, playerScore);
        } else {
            System.out.println("Computer is batting first.");
            computerScore = playInnings(false, -1);
            System.out.println("Computer innings ended. It scored: " + computerScore);
            System.out.println("You need " + (computerScore + 1) + " runs to win.");
            playerScore = playInnings(true, computerScore);
        }

        System.out.println("Final Scores:");
        System.out.println("You: " + playerScore);
        System.out.println("Computer: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("You won the match!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer won the match!");
        } else {
            System.out.println("Match Drawn!");
        }

        scanner.close();
    }

    static int playInnings(boolean isUserPlaying, int target) {
        int score = 0;
        while (true) {
            int userInput, compInput;

            if (isUserPlaying) {
                System.out.print("Enter your shot (1-6): ");
                userInput = scanner.nextInt();
                while (userInput < 1 || userInput > 6) {
                    System.out.print("Invalid input. Enter a number between 1 and 6: ");
                    userInput = scanner.nextInt();
                }
                compInput = random.nextInt(6) + 1;
                System.out.println("Computer bowled: " + compInput);
            } else {
                compInput = random.nextInt(6) + 1;
                System.out.print("Enter your bowl (1-6): ");
                userInput = scanner.nextInt();
                while (userInput < 1 || userInput > 6) {
                    System.out.print("Invalid input. Enter a number between 1 and 6: ");
                    userInput = scanner.nextInt();
                }
                System.out.println("Computer played: " + compInput);
            }

            if (userInput == compInput) {
                System.out.println("Out!");
                break;
            } else {
                int run = isUserPlaying ? userInput : compInput;
                score += run;
                System.out.println("Current Score: " + score);
                if (target != -1 && score > target) {
                    break;
                }
            }
        }
        return score;
    }
}
