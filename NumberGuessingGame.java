import java.util.Random;
 import java.util.Scanner;
 public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;
    private static int score = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number between 1 and 100.");
        System.out.println("You will play " + MAX_ROUNDS + " rounds.");
        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attemptsLeft = MAX_ATTEMPTS;
            boolean hasGuessedCorrectly = false;
            System.out.println("\nRound " + round + ":");
            System.out.println("Guess the number!");
            while (attemptsLeft > 0 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    attemptsLeft++; // Do not count this attempt
                    continue;
                }
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number!");
                    hasGuessedCorrectly = true;
                    int points = calculatePoints(attemptsLeft);
                    score += points;
                    System.out.println("You earned " + points + " points this round.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Wrong Guess , Guess a Higher number");
                } else {
                    System.out.println("Wrong Guess , Guess a Lower number");
                }
                if (attemptsLeft > 0 && !hasGuessedCorrectly) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + 
                numberToGuess);
            }
        }
        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }
    private static int calculatePoints(int attemptsLeft) {
        return attemptsLeft * 10; // 10 points for each attempt left
    }
 }