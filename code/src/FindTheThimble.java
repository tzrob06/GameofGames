import java.util.Random;
public class FindTheThimble {
    
    public static final int MIN_ROUNDS = 1;
    public static final int MAX_ROUNDS = 9;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final String LEFT_STR = "LEFT";
    public static final String RIGHT_STR = "RIGHT";
    public static final char[] GUESS_OPTIONS = {'L', 'R'};

    public static void playGame() {
        Random random = new Random();
        int player1Score = 0; 
        int computerScore = 0; 

        System.out.println("\n Welcome to the Find the Thimble Game");
        System.out.println("Rules: You will play a best of match where you guess if the thimble is in the left or right hand.");
        System.out.println("\n If you guess correctly, you get a point.");
        System.out.println("Otherwise, the computer gets a point.");

        int totalRounds = GetInput.getOddIntInput("Pick an odd number of rounds to play (1 to 9): ", MIN_ROUNDS, MAX_ROUNDS);
        int roundsNeededToWin = (totalRounds / 2) + 1;  
        System.out.println("First to reach " + roundsNeededToWin + " points wins the game!");

        while (player1Score < roundsNeededToWin && computerScore < roundsNeededToWin) {
            int thimbleLocation = random.nextInt(2) + 1; 
            
            if (PlayGames.testMode) {
                String locationText = (thimbleLocation == LEFT) ? LEFT_STR : RIGHT_STR;
                System.out.println("[TEST MODE] The thimble is in the " + locationText + " hand.");
            }

            char userGuess = GetInput.getCharInput("Guess (L for Left, R for Right): ", GUESS_OPTIONS);
            int guessAsInt = (userGuess == 'L') ? LEFT : RIGHT;

            if (guessAsInt == thimbleLocation) {
                player1Score++;
                System.out.println("Correct! Point for YOU.");
            } else {
                computerScore++;
                System.out.println("Wrong! Point for COMPUTER.");
            }

            System.out.println("Score - You: " + player1Score + " | Computer: " + computerScore + "\n");
        }

        if (player1Score > computerScore) {
            System.out.println("Congratulations! YOU WON the match!");
            PlayGames.updateScore(1); 
        } else {
            System.out.println("The COMPUTER won the match. Better luck next time!");
            PlayGames.updateScore(2); 
        }
        System.out.println("Final Score - You: " + player1Score + " | Computer: " + computerScore);
    }
}
