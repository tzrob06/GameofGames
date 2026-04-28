import java.util.Random;


//Even Odd game
public class EvenOdd {
    private static final char EVEN = 'E';
    private static final char ODD = 'O';
    private static final char[] VALID_CHOICES = {EVEN, ODD};
    private static final int MIN_ROUNDS = 1;
    private static final int MAX_ROUNDS = 9;
    private static final int COMPUTER_NUMBER_MIN = 1;
    private static final int COMPUTER_NUMBER_MAX = 5;
    private static final int PLAYER_NUMBER_MIN = 1;
    private static final int PLAYER_NUMBER_MAX = 10;
    private static final Random random = new Random();
    
    public static void playGame() {
        int playerScore;
        int computerScore;
        int rounds;
        
        boolean playAgain = true;
        
        while (playAgain) {
            playerScore = 0;
            computerScore = 0;
            
            System.out.println("\n");
            System.out.println("Welcome to the Even Odd Game!\n");
            System.out.println("Rules: You will play best of an odd number of rounds (1-9).");
            System.out.println("You pick a number, computer picks a number (1-5).\n");
            System.out.println("You guess if the sum will be Even (E) or Odd (O).");
            System.out.println("First to majority wins!\n");
            
            
            rounds = GetInput.getOddIntInput(
                "Enter an odd number of rounds to play (1-9): ", MIN_ROUNDS, MAX_ROUNDS);
            
            System.out.println("\nPlaying best of " + rounds + " rounds.");
            
            int roundsNeededToWin = (rounds / 2) + 1;
            
            for (int round = 1; round <= rounds; round++) {
                if (playerScore >= roundsNeededToWin || computerScore >= roundsNeededToWin) {
                    break;
                }
                
                System.out.println("\n--- Round " + round + " of " + rounds + " ---");
                
                int playerNumber = GetInput.getIntInRange(
                    "Pick a number (1-10): ", PLAYER_NUMBER_MIN, PLAYER_NUMBER_MAX);
                
                int computerNumber = random.nextInt(COMPUTER_NUMBER_MAX) + COMPUTER_NUMBER_MIN;
                
                if (PlayGames.testMode) {
                    System.out.println("[TEST MODE] Computer's number: " + computerNumber);
                }
                
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
                
                if (playerScore >= roundsNeededToWin) {
                    System.out.println("\n");
                    System.out.println("CONGRATULATIONS! You won Even Odd!");
                    System.out.println("Final Score - You: " + playerScore + " | Computer: " + computerScore);
                    System.out.println("\n");
                    PlayGames.updateScore(1);
                    
                    String choice = GetInput.getStringOptions(
                        "\nWould you like to play Even Odd again? (Y/N): ", "Y", "N");
                    if (choice.equals("N")) {
                        playAgain = false;
                    }
                    break;
                } else if (computerScore >= roundsNeededToWin) {
                    System.out.println("\n");
                    System.out.println("Computer wins Even Odd!");
                    System.out.println("Final Score - You: " + playerScore + " | Computer: " + computerScore);
                    System.out.println("\n");
                    PlayGames.updateScore(2);
                    
                    String choice = GetInput.getStringOptions(
                        "\nWould you like to play Even Odd again? (Y/N): ", "Y", "N");
                    if (choice.equals("N")) {
                        playAgain = false;
                    }
                    break;
                }
            }
        }
    }
}
