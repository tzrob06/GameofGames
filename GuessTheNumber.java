import java.util.Random;


//Guess the Number game
 
public class GuessTheNumber implements Game {
    private static final int RANGE_GENERATION_MIN = 1;
    private static final int RANGE_GENERATION_MAX = 50;
    
    private final Random random;
    private final boolean testMode;
    
    public GuessTheNumber(boolean testMode) {
        this.random = new Random();
        this.testMode = testMode;
    }
    
    @Override
    public String getGameName() {
        return "Guess the Number";
    }
    
    @Override
    public boolean play() {
        while (true) {
            System.out.println("\n");
            System.out.println("Welcome to the Guess the Number Game!\n");
            System.out.println("Rules: The computer will generate a random range and");
            System.out.println("pick a number within that range. You have a limited\n");
            System.out.println("number of guesses to find the correct number.");
            System.out.println("\n");
            
            // Computer generates random range
            int lowestInRange = random.nextInt(RANGE_GENERATION_MAX) + RANGE_GENERATION_MIN;
            int highestInRange = random.nextInt(RANGE_GENERATION_MAX - lowestInRange + 1) + lowestInRange;
            
            if (highestInRange == lowestInRange) {
                highestInRange = lowestInRange + 1;
            }
            
            int correctNumber = random.nextInt(highestInRange - lowestInRange + 1) + lowestInRange;
            int guessLimit = (highestInRange - lowestInRange) / 2;
            int guessCount = 0;
            
            if (testMode) {
                System.out.println("[TEST MODE] Range: " + lowestInRange + " to " + highestInRange);
                System.out.println("[TEST MODE] Correct number: " + correctNumber);
                System.out.println("[TEST MODE] Guess limit: " + guessLimit);
            }
            
            System.out.println("I'm thinking of a number between " + lowestInRange + " and " + highestInRange + ".");
            System.out.println("You have " + guessLimit + " guesses.\n");
            
            boolean won = false;
            
            // Guessing loop
            while (guessCount < guessLimit) {
                int guessNumber = GetInput.getIntInput(
                    "Enter your guess (" + lowestInRange + "-" + highestInRange + "): ", 
                    lowestInRange, highestInRange);
                
                guessCount++;
                
                if (guessNumber == correctNumber) {
                    System.out.println("\n");
                    System.out.println("Correct! The number was " + correctNumber + "!\n");
                    System.out.println("You guessed it in " + guessCount + " guesses.");
                    System.out.println("CONGRATULATIONS! You won Guess the Number!\n");
                    won = true;
                    break;
                } else if (guessNumber < correctNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                
                if (guessCount < guessLimit) {
                    System.out.println("Guesses remaining: " + (guessLimit - guessCount) + "\n");
                }
            }
            
            if (!won) {
                System.out.println("\n");
                System.out.println("Out of guesses! The number was " + correctNumber + ".\n");
                System.out.println("Computer wins Guess the Number!");
               
            }
            
            // Ask to play again
            char playAgain = GetInput.getYesNoInput(
                "\nWould you like to play Guess the Number again? (Y/N): ");
            if (playAgain == 'N') {
                return won;
            }
            
        }
    }
}