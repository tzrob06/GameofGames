import java.util.Random;


//Guess the Number game
 public class GuessTheNumber {
    private static final int RANGE_GENERATION_MIN = 1;
    private static final int RANGE_GENERATION_MAX = 50;
    private static final Random random = new Random();
    
    public static void playGame() {
        int lowestInRange;
        int highestInRange;
        int correctNumber;
        int guessLimit;
        int guessCount;
        int guessNumber;
        
        boolean playAgain = true;
        
        while (playAgain) {
            System.out.println("\n");
            System.out.println("Welcome to the Guess the Number Game!\n");
            System.out.println("Rules: The computer will generate a random range and");
            System.out.println("pick a number within that range. You have a limited\n");
            System.out.println("number of guesses to find the correct number.");
            System.out.println("\n");
            
            lowestInRange = random.nextInt(RANGE_GENERATION_MAX) + RANGE_GENERATION_MIN;
            highestInRange = random.nextInt(RANGE_GENERATION_MAX - lowestInRange + 1) + lowestInRange;
            
            if (highestInRange == lowestInRange) {
                highestInRange = lowestInRange + 1;
            }
            
            correctNumber = random.nextInt(highestInRange - lowestInRange + 1) + lowestInRange;
            guessLimit = (highestInRange - lowestInRange) / 2;
            guessCount = 0;
            
            if (PlayGames.testMode) {
                System.out.println("[TEST MODE] Range: " + lowestInRange + " to " + highestInRange);
                System.out.println("[TEST MODE] Correct number: " + correctNumber);
                System.out.println("[TEST MODE] Guess limit: " + guessLimit);
            }
            
            System.out.println("I'm thinking of a number between " + lowestInRange + " and " + highestInRange + ".");
            System.out.println("You have " + guessLimit + " guesses.\n");
            
            boolean won = false;
            
            while (guessCount < guessLimit) {
                guessNumber = GetInput.getIntInRange(
                    "Enter your guess (" + lowestInRange + "-" + highestInRange + "): ", 
                    lowestInRange, highestInRange);
                
                guessCount++;
                
                if (guessNumber == correctNumber) {
                    System.out.println("\n");
                    System.out.println("Correct! The number was " + correctNumber + "!");
                    System.out.println("You guessed it in " + guessCount + " guesses.\n");
                    System.out.println("CONGRATULATIONS! You won Guess the Number!");
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
                System.out.println("Out of guesses! The number was " + correctNumber + ".");
                System.out.println("Computer wins Guess the Number!\n");
                PlayGames.updateScore(2);
            } else {
                PlayGames.updateScore(1);
            }
            
            String choice = GetInput.getStringOptions(
                "\nWould you like to play Guess the Number again? (Y/N): ", "Y", "N");
            if (choice.equals("N")) {
                playAgain = false;
            }
        }
    }
}
