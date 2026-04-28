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
    
    /** Minimum number of rounds that can be played. */
    private static final int MIN_ROUNDS = 1;
    
    /** Maximum number of rounds that can be played. */
    private static final int MAX_ROUNDS = 9;
    
    /** Represents the HEADS outcome of a coin flip. */
    private static final String HEADS = "HEADS";
    
    /** Represents the TAILS outcome of a coin flip. */
    private static final String TAILS = "TAILS";
    
    /** Random number generator for simulating coin flips. */
    private static final Random random = new Random();
    
    /**
     * Plays the Coin Flip game following the design team's use case specification.
     * 
     * Use case steps implemented:
     * 1. Initialise player and computer scores to 0
     * 2. Display welcome menu with rules
     * 3. Prompt user for odd number of rounds (1-9)
     * 4. Validate input (odd, between 1-9)
     * 5. Computer generates random 1=HEADS, 2=TAILS
     * 6. Prompt user to guess "H" or "T"
     * 7. Repeat until valid input
     * 8. If user correct → increment player score, check if won game
     * 9. If computer correct → increment computer score, check if won game
     * 10. If no winner → randomise again and re-prompt
     */
    public static void playGame() {
        // Step 1: Add 2 integer variables for player's score and computer's score, set to 0
        int playerScore = 0;
        int computerScore = 0;
        int roundsToPlay = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            // Reset scores for new game session
            playerScore = 0;
            computerScore = 0;
            
            // Step 2: Print welcome menu with rules
            System.out.println("\n");
            System.out.println("==========================================");
            System.out.println("     Welcome to the COIN FLIP Game!");
            System.out.println("==========================================");
            System.out.println("\nRULES:");
            System.out.println("  • Guess whether the coin will show HEADS or TAILS");
            System.out.println("  • You will choose an odd number of rounds (1, 3, 5, 7, or 9)");
            System.out.println("  • The player who wins more than half of the rounds wins the game");
            System.out.println("  • First to win the game earns a point in the overall Game of Games");
            System.out.println("\n==========================================\n");
            
            // Step 3: Prompt user to pick odd number of rounds between 1 and 9
            while (true) {
                roundsToPlay = GetInput.getIntInRange(
                    "Enter number of rounds to play (odd number, 1-9): ", 
                    MIN_ROUNDS, MAX_ROUNDS);
                
                // Step 4: Repeatedly prompt if even or out of range
                if (roundsToPlay % 2 == 0) {
                    System.out.println("ERROR: Please enter an ODD number (1, 3, 5, 7, or 9).\n");
                } else {
                    break;
                }
            }
            
            int roundsToWin = (roundsToPlay / 2) + 1;
            System.out.println("\nFirst to win " + roundsToWin + " rounds wins the game!\n");
            
            // Step 5-10: Main game loop - play rounds until someone wins
            while (playerScore < roundsToWin && computerScore < roundsToWin) {
                // Step 5: Computer makes random number between 1 and 2
                // 1 represents HEADS, 2 represents TAILS
                int computerFlip = random.nextInt(2) + 1;
                String coinResult = (computerFlip == 1) ? HEADS : TAILS;
                
                // Test Mode: reveal the result before guess
                if (PlayGames.testMode) {
                    System.out.println("[TEST MODE] Coin will show: " + coinResult);
                }
                
                // Step 6: Prompt user to guess between heads or tails ("H" or "T")
                String guess = GetInput.getStringOptions(
                    "Call heads or tails (H for HEADS, T for TAILS): ", "H", "T");
                
                // Convert "H" or "T" to full word for comparison
                String userGuess = guess.equals("H") ? HEADS : TAILS;
                
                System.out.println("Coin shows: " + coinResult);
                
                // Step 8 & 9: Determine winner of the round
                if (userGuess.equals(coinResult)) {
                    // Step 8: User is correct
                    playerScore++;
                    System.out.println("\n✓ Correct! Round goes to YOU!");
                    System.out.println("  Score: You " + playerScore + " - " + computerScore + " Computer");
                } else {
                    // Step 9: Computer is correct
                    computerScore++;
                    System.out.println("\n✗ Wrong! Round goes to COMPUTER!");
                    System.out.println("  Score: You " + playerScore + " - " + computerScore + " Computer");
                }
                
                // Step 8 & 9 continued: Check if someone has won the game
                if (playerScore == roundsToWin) {
                    System.out.println("\n");
                    System.out.println("==========================================");
                    System.out.println("     YOU WON THE COIN FLIP GAME!");
                    System.out.println("==========================================");
                    System.out.println("Final Score: You " + playerScore + " - " + computerScore + " Computer");
                    PlayGames.updateScore(1); // Player wins overall point
                } else if (computerScore == roundsToWin) {
                    System.out.println("\n");
                    System.out.println("==========================================");
                    System.out.println("     COMPUTER WON THE COIN FLIP GAME!");
                    System.out.println("==========================================");
                    System.out.println("Final Score: You " + playerScore + " - " + computerScore + " Computer");
                    PlayGames.updateScore(2); // Computer wins overall point
                } else {
                    System.out.println(); // Empty line for readability before next round
                }
            }
            
            // Step: Ask to play again or return to main menu
            String choice = GetInput.getStringOptions(
                "\nWould you like to play Coin Flip again? (Y/N): ", "Y", "N");
            if (choice.equals("N")) {
                playAgain = false;
                System.out.println("\nReturning to Main Menu...\n");
            }
        }
    }
}
