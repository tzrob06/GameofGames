import java.util.Random;

/**
 * The CoinFlip class implements an interactive guessing game where the player
 * competes against the computer by predicting the outcome of a coin flip.
 * The game consists of an odd number of rounds chosen by the player.
 * The player or computer who wins more than half of the rounds wins the game.
 * 
 * <p>This game supports two modes:
 * <ul>
 *   <li><b>Player Mode:</b> Standard gameplay with no hidden information</li>
 *   <li><b>Test Mode:</b> Reveals the coin flip result before the player guesses</li>
 * </ul>
 * 
 * @author Liu Restrepo, Zoe Koehne, Jake Acquarulo, Thomas Robertson
 * @version 1.0
 * @since 2026-04-27
 */
public class CoinFlip {
    
    private static final int MIN_ROUNDS = 1;
    private static final int MAX_ROUNDS = 9;
    private static final Random random = new Random();
    
    public static void playGame() {
        int playerScore = 0;
        int computerScore = 0;
        int roundsToPlay = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            playerScore = 0;
            computerScore = 0;
            
            System.out.println("\n");
            System.out.println("==========================================");
            System.out.println("     Welcome to the COIN FLIP Game!");
            System.out.println("==========================================");
            System.out.println("\nRULES:");
            System.out.println("  • Guess whether the coin will show HEADS or TAILS");
            System.out.println("  • You will choose an odd number of rounds (1, 3, 5, 7, or 9)");
            System.out.println("  • The player who wins more than half of the rounds wins");
            System.out.println("\n==========================================\n");
            
            // Use getOddIntInput (exists in your GetInput.java)
            roundsToPlay = GetInput.getOddIntInput(
                "Enter number of rounds to play (odd number, 1-9): ", 
                MIN_ROUNDS, MAX_ROUNDS);
            
            int roundsToWin = (roundsToPlay / 2) + 1;
            System.out.println("\nFirst to win " + roundsToWin + " rounds wins!\n");
            
            while (playerScore < roundsToWin && computerScore < roundsToWin) {
                // Computer flips coin: 1 = HEADS, 2 = TAILS
                int computerFlip = random.nextInt(2) + 1;
                String coinResult = (computerFlip == 1) ? "HEADS" : "TAILS";
                
                // Use getCharInput with valid chars {'H', 'T'}
                char guess = GetInput.getCharInput(
                    "Call heads or tails (H for HEADS, T for TAILS): ", 
                    new char[]{'H', 'T'});
                
                String userGuess = (guess == 'H') ? "HEADS" : "TAILS";
                
                System.out.println("Coin shows: " + coinResult);
                
                if (userGuess.equals(coinResult)) {
                    playerScore++;
                    System.out.println("\n✓ Correct! Round goes to YOU!");
                } else {
                    computerScore++;
                    System.out.println("\n✗ Wrong! Round goes to COMPUTER!");
                }
                System.out.println("  Score: You " + playerScore + " - " + computerScore + " Computer\n");
                
                if (playerScore == roundsToWin) {
                    System.out.println("\n==========================================");
                    System.out.println("     YOU WON THE COIN FLIP GAME!");
                    System.out.println("==========================================");
                    System.out.println("Final Score: You " + playerScore + " - " + computerScore);
                } else if (computerScore == roundsToWin) {
                    System.out.println("\n==========================================");
                    System.out.println("     COMPUTER WON THE COIN FLIP GAME!");
                    System.out.println("==========================================");
                    System.out.println("Final Score: You " + playerScore + " - " + computerScore);
                }
            }
            
            // Use getYesNoInput (exists in your GetInput.java)
            char choice = GetInput.getYesNoInput("\nWould you like to play Coin Flip again? (Y/N): ");
            if (choice == 'N') {
                playAgain = false;
                System.out.println("\nReturning to Main Menu...\n");
            }
        }
    }
}
