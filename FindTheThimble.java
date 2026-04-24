import java.util.Random;

public class FindTheThimble {
    // Literal values stored in final variables for easy maintenance 
    private static final int MIN_ROUNDS = 1;
    private static final int MAX_ROUNDS = 9;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final char[] GUESS_OPTIONS = {'L', 'R'};

    //coding the game
    public static void playGame() {
        Random random = new Random();
        int player1Score = 0; 
        int computerScore = 0; 

        // game rules
        System.out.println("\n Welcome to the Find the Thimble Game");
        System.out.println("Rules: You will play a best of match where you guess if the thimble is in the left or right hand.");
        System.out.println("\n If you guess correctly, you get a point.");
        System.out.println("Otherwise, the computer gets a point.");

        // number of rounds
        int totalRounds = GetInput.getOddIntInput("Pick an odd number of rounds to play up to (1 to 9): ", MIN_ROUNDS, MAX_ROUNDS);
        int roundsNeededToWin = (totalRounds / 2) + 1;  
        System.out.println("First to reach " + roundsNeededToWin + " points wins the game!");

        // actual gameplay
        while (player1Score < roundsNeededToWin && computerScore < roundsNeededToWin) {
            // 1 = Left, 2 = Right
            int thimbleLocation = random.nextInt(2) + 1; 
            
            // making test mode
            if (PlayGames.testMode) {
                String locationText = (thimbleLocation == LEFT) ? "LEFT" : "RIGHT";
                System.out.println("[TEST MODE] The thimble is in the " + locationText + " hand.");
            }

            // user answers
            char userGuess = GetInput.getCharInput("Guess if the thimble is on the left or right (L or R): ", GUESS_OPTIONS);
            int guessAsInt = (userGuess == 'L') ? LEFT : RIGHT;

            // point counting
            if (guessAsInt == thimbleLocation) {
                player1Score++;
                System.out.println("You Won this round!");
            } else {
                computerScore++;
                System.out.println("You Lost this round! The computer wins the point.");
            }

            System.out.println("Current Match Score - You: " + player1Score + " | Computer: " + computerScore);
        }

        // final score message
        if (player1Score > computerScore) {
            System.out.println("\nCongratulations! You won Find the Thimble!");
            PlayGames.updateScore(1); 
        } else {
            System.out.println("\nThe Computer won Find the Thimble. Better luck next time!");
            PlayGames.updateScore(2); 
        }
        System.out.println("Final Match Score - You: " + player1Score + " | Computer: " + computerScore);
    }
}