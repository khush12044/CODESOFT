import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0; // Tracks rounds won
        boolean playAgain = true;

        System.out.println("===== Welcome to Guess the Number Game =====");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; // random number from 1 to 100
            int attemptsLeft = 7; // limit number of tries
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            // Gameplay loop
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed it right!");
                    guessedCorrectly = true;
                    score++; // increase score when round is won
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Too low! Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
            }

            // Ask for another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n===== Game Over =====");
        System.out.println("Your total rounds won: " + score);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
