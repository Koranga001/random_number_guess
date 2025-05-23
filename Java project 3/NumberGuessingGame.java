import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int guessCount = 0;
        int maxTries = 7;
        boolean isGuessed = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxTries + " attempts to guess it correctly.");

        while (guessCount < maxTries) {
            System.out.print("Enter your guess: ");
            int guess;

            // Input validation
            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            guessCount++;

            if (guess == targetNumber) {
                System.out.println(" Congratulations! You guessed the correct number in " + guessCount + " tries.");
                isGuessed = true;
                break;
            } else if (guess < targetNumber) {
                System.out.println("🔼 Too low! Try a higher number.");
            } else {
                System.out.println("🔽 Too high! Try a lower number.");
            }

            System.out.println("Attempts left: " + (maxTries - guessCount));
        }

        if (!isGuessed) {
            System.out.println(" Sorry! You've used all your attempts. The correct number was: " + targetNumber);
        }

        System.out.println("🎮 Thank you for playing!");
        scanner.close();
    }
}
