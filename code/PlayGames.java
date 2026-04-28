/*
 * Driver loop that displays the menu and controls the overall progress.
 */
public class PlayGames {
    public static int userTotalWins = 0;
    public static int compTotalWins = 0;
    public static int gamesPlayed = 0;
    public static boolean testMode = false;

    public static void main(String[] args) {
        // Prompt for Test Mode at startup
        String modeChoice = GetInput.getStringOptions("Enable Test Mode to see hidden information? (Y/N): ", "Y", "N");
        if (modeChoice.equals("Y")) {
            testMode = true;
            System.out.println("Test Mode ENABLED.\n");
        }

        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("\nWelcome to the Game of Games! Select a game to play or quit to see the final score.");
            System.out.println("1. Find the Thimble");
            System.out.println("2. Coin Flip");
            System.out.println("3. Guess the Number");
            System.out.println("4. Even and Odd");
            System.out.println("5. Find the Red Thread");
            System.out.println("6. Quit Games");

            int choice = GetInput.getIntInRange("Enter your choice (1-6): ", 1, 6);

            switch (choice) {
                case 1:
                    FindTheThimble.playGame();
                    break;
                case 2:
                    CoingFlip.playGame();
                    break;
                case 3:
                    GuessTheNumber.playGame();
                    break;
                case 4:
                    EvenOdd.playGame();
                    break;
                case 5:
                    FindtheRedThread.playGame();
                    break;
                case 6:
                    displayFinalResults();
                    keepPlaying = false;
                    break;
            }
        }
    }

    /**
     * Updates the global scoreboard after each game concludes.
     */
    public static void updateScore(int winner) {
        gamesPlayed++;
        if (winner == 1) {
            userTotalWins++;
        } else if (winner == 2) {
            compTotalWins++;
        }
        
        System.out.println("\n--- Current Scoreboard ---");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Your Total Wins: " + userTotalWins);
        System.out.println("Computer Total Wins: " + compTotalWins);
    }

    /**
     * Displays final scoreboard after the exiting the game loop
     */
    private static void displayFinalResults() {
        System.out.println("\n--- FINAL SCOREBOARD ---");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Your Total Wins: " + userTotalWins);
        System.out.println("Computer Total Wins: " + compTotalWins);

        if (userTotalWins > compTotalWins) {
            System.out.println("You won the Game of Games!");
        } else if (compTotalWins > userTotalWins) {
            System.out.println("The Computer won the Game of Games!");
        } else {
            System.out.println("The Game of Games ended in a tie!");
        }
    }
}
