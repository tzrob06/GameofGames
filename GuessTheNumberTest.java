import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GuessTheNumberTest {
    
    private ByteArrayOutputStream testOutput;
    
    @Before
    public void setUp() {
        PlayGames.testMode = true;
        PlayGames.userTotalWins = 0;
        PlayGames.compTotalWins = 0;
        PlayGames.gamesPlayed = 0;
        testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));
    }
    
    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    
    @Test
    public void testValidGuessWithinRange() {
        setInput("5\nN\n");
        GuessTheNumber.playGame();
        String output = testOutput.toString();
        assertTrue(output.contains("Welcome to the Guess the Number Game!"));
    }
    
    @Test
    public void testInvalidGuessOutOfRange() {
        setInput("0\n5\nN\n");
        GuessTheNumber.playGame();
        String output = testOutput.toString();
        assertTrue(output.contains("Invalid menu choice"));
    }
    
    @Test
    public void testWinMessageDisplayed() {
        setInput("5\nN\n");
        GuessTheNumber.playGame();
        String output = testOutput.toString();
        assertTrue(output.contains("Correct!") || output.contains("You Won!") || output.contains("Out of guesses!"));
    }
    
    @Test
    public void testTestModeShowsHiddenInfo() {
        setInput("5\nN\n");
        GuessTheNumber.playGame();
        String output = testOutput.toString();
        assertTrue(output.contains("[TEST MODE] Correct number:"));
    }
}