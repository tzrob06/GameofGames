import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EvenOddTest {
    
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
    public void testValidOddRoundsInput() {
        setInput("5\n5\nE\nN\n");
        EvenOdd.playGame();
        String output = testOutput.toString();
        assertTrue(output.contains("Playing best of 5 rounds"));
    }
    
    @Test
    public void testInvalidEvenRoundsInput() {
        setInput("4\n5\n5\nE\nN\n");
        EvenOdd.playGame();
        String output = testOutput.toString();
        assertTrue(output.contains("Invalid menu choice"));
    }
    
    @Test
    public void testInvalidRoundsOutOfRange() {
        setInput("0\n5\n5\nE\nN\n");
        EvenOdd.playGame();
        String output = testOutput.toString();
        assertTrue(output.contains("Invalid menu choice"));
    }
    
    @Test
    public void testInvalidGuessInput() {
        setInput("5\n5\nW\nE\nN\n");
        EvenOdd.playGame();
        String output = testOutput.toString();
        assertTrue(output.contains("Invalid choice"));
    }
}