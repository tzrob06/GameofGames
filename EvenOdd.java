import java.util.Random;


//Even Odd game
public class EvenOdd implements Game {
    private static final char EVEN = 'E';
    private static final char ODD = 'O';
    private static final char[] VALID_CHOICES = {EVEN, ODD};
    private static final int MIN_ROUNDS = 1;
    private static final int MAX_ROUNDS = 9;
    private static final int COMPUTER_NUMBER_MIN = 1;
    private static final int COMPUTER_NUMBER_MAX = 5;
    private static final int PLAYER_NUMBER_MIN = 1;
    private static final int PLAYER_NUMBER_MAX = 10;
    
    private final Random random;
    private final boolean testMode;
    
    public EvenOdd(boolean testMode) {
        this.random = new Random();
        this.testMode = testMode;
    }
    
    @Override
    public String getGameName() {
        return "Even and Odd";
    }
    
    @Override
    public boolean play() {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("Welcome to the Even Odd Game!");
            System.out.println("========================================");
            System.out.println("Rules: You will play best of an odd number of rounds (1-9).");
            System.out.println("You pick a number, computer picks a number (1-5).");
            System.out.println("You guess if the sum will be Even (E) or Odd (O).");
            System.out.println("First to majority wins!");
            System.out.println("========================================\n");
            
            
            int totalRounds = GetInput.getOddIntInput(
                "Enter an odd number of rounds to play (1-9): ", MIN_ROUNDS, MAX_ROUNDS);
            
            System.out.println("\nPlaying best of " + totalRounds + " rounds.");
            
            int playerScore = 0;
            int computerScore = 0;
            int roundsNeededToWin = (totalRounds / 2) + 1;
            
            // Play rounds
            for (int round = 1; round <= totalRounds; round++) {
                
                if (playerScore >= roundsNeededToWin || computerScore >= roundsNeededToWin) {
                    break;
                }
                
                System.out.println("\n--- Round " + round + " of " + totalRounds + " ---");
                
                
                int playerNumber = GetInput.getIntInput(
                    "Pick a number (1-10): ", PLAYER_NUMBER_MIN, PLAYER_NUMBER_MAX);
                
                
                int computerNumber = random.nextInt(COMPUTER_NUMBER_MAX) + COMPUTER_NUMBER_MIN;
                
                if (testMode) {
                    System.out.println("[TEST MODE] Computer's number: " + computerNumber);
                }
                
                // Player guesses even or odd
                char evenOddGuess = GetInput.getCharInput(
                    "Will the sum be (E)ven or (O)dd? ", VALID_CHOICES);
                
                int sum = playerNumber + computerNumber;
                boolean sumIsEven = (sum % 2 == 0);
                
                System.out.println("\nYour number: " + playerNumber);
                System.out.println("Computer's number: " + computerNumber);
                System.out.println("Sum: " + sum + " (" + (sumIsEven ? "Even" : "Odd") + ")");
                
                if ((evenOddGuess == EVEN && sumIsEven) || (evenOddGuess == ODD && !sumIsEven)) {
                    System.out.println("Correct! You win this round!");
                    playerScore++;
                } else {
                    System.out.println("Wrong! Computer wins this round!");
                    computerScore++;
                }
                
                System.out.println("Score - You: " + playerScore + " | Computer: " + computerScore);
                
                // Check for overall winner
                if (playerScore >= roundsNeededToWin) {
                    System.out.println("\n========================================");
                    System.out.println("CONGRATULATIONS! You won Even Odd!");
                    System.out.println("Final Score - You: " + playerScore + " | Computer: " + computerScore);
                    System.out.println("========================================");
                    
                    char playAgain = GetInput.getYesNoInput(
                        "\nWould you like to play Even Odd again? (Y/N): ");
                    if (playAgain == 'Y') {
                        playerScore = 0;
                        computerScore = 0;
                        round = 0;  // Will be incremented to 1 in loop
                        continue;
                    }
                    return true;
                } else if (computerScore >= roundsNeededToWin) {
                    System.out.println("\n========================================");
                    System.out.println("Computer wins Even Odd!");
                    System.out.println("Final Score - You: " + playerScore + " | Computer: " + computerScore);
                    System.out.println("========================================");
                    
                    char playAgain = GetInput.getYesNoInput(
                        "\nWould you like to play Even Odd again? (Y/N): ");
                    if (playAgain == 'Y') {
                        playerScore = 0;
                        computerScore = 0;
                        round = 0;
                        continue;
                    }
                    return false;
                }
            }
            
            
            boolean playerWon = playerScore > computerScore;
            char playAgain = GetInput.getYesNoInput(
                "\nWould you like to play Even Odd again? (Y/N): ");
            if (playAgain == 'Y') {
                continue;
            }
            return playerWon;
        }
    }
}