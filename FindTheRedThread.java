import java.util.Random;
/**
 * Handles the logic for the Find the Red Thread game.
 */
public class FindtheRedThread {

    public static void playGame() {
        int playerScore = 0;
        int computerScore = 0;
        boolean playAgain = true;
        Random rand = new Random();

        final int TOTAL_SPOOLS = 50;

        while (playAgain) {
            int remainingSpools = TOTAL_SPOOLS;
            boolean gameOver = false;
            int currentSpoolPosition = 1;

            System.out.println("\nWelcome to the Find the Red Thread Game");
            System.out.println("There are 50 spools. One of them is red. You are playing against the computer.");
            System.out.println("You will choose a number X between 1 and 10. Both you and the computer will pick X spools per turn.");
            System.out.println("If the red spool is picked, that player wins immediately.");

            int xChoice = GetInput.getIntInRange("Choose a number of spools to pull per turn (1-10): ", 1, 10);
            int redSpoolPosition = rand.nextInt(TOTAL_SPOOLS) + 1;

            if (PlayGames.testMode) {
                System.out.println("[TEST MODE] The red spool is hidden at position: " + redSpoolPosition);
            }

            while (!gameOver) {
                GetInput.pressEnter("\nRemaining spools: " + remainingSpools + ". Press ENTER to pick spools...");
                
                // player's  turn
                int spoolsPicked = Math.min(xChoice, remainingSpools);
                System.out.println("You picked " + spoolsPicked + " spools.");
                
                if (redSpoolPosition >= currentSpoolPosition && redSpoolPosition < currentSpoolPosition + spoolsPicked) {
                    System.out.println("You found the red thread! You Won!");
                    playerScore++;
                    PlayGames.updateScore(1);
                    gameOver = true;
                } else {
                    remainingSpools -= spoolsPicked;
                    currentSpoolPosition += spoolsPicked;
                    System.out.println("No red thread found.");
                }

                // cpu's turn
                if (!gameOver) {
                    spoolsPicked = Math.min(xChoice, remainingSpools);
                    System.out.println("The computer picks " + spoolsPicked + " spools.");

                    if (redSpoolPosition >= currentSpoolPosition && redSpoolPosition < currentSpoolPosition + spoolsPicked) {
                        System.out.println("The computer found the red thread! Computer Wins!");
                        computerScore++;
                        PlayGames.updateScore(2);
                        gameOver = true;
                    } else {
                        remainingSpools -= spoolsPicked;
                        currentSpoolPosition += spoolsPicked;
                        System.out.println("Computer did not find the red thread.");
                    }
                }
            }

            System.out.println("\nSession Score - You: " + playerScore + " | Computer: " + computerScore);
            String playAgainChoice = GetInput.getStringOptions("Would you like to play Find the Red Thread again? (Y/N): ", "Y", "N");
            
            if (playAgainChoice.equals("N")) {
                playAgain = false;
            }
        }
    }
}