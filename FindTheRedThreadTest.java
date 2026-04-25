import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FindtheRedThreadTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        PlayGames.testMode = false;
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    // Corresponds to Group 4 TestDesign: Find The Red Thread Sunny Day Path
    @Test
    void inputTwoShouldAcceptValidSpoolPull() {
        
        StringBuilder inputBuilder = new StringBuilder("2\n"); 
        for(int i = 0; i < 30; i++) {
            inputBuilder.append("\n"); 
        }
        inputBuilder.append("N\n"); 
        
        System.setIn(new ByteArrayInputStream(inputBuilder.toString().getBytes()));

        FindtheRedThread.playGame();
        String output = outputStreamCaptor.toString();
        
        assertTrue(output.contains("You picked 2 spools"));
    }

    @Test
    void inputValidNumberWhereUserDoesNotWinImmediately() {
        StringBuilder inputBuilder = new StringBuilder("5\n"); 
        for(int i = 0; i < 15; i++) {
            inputBuilder.append("\n");
        }
        inputBuilder.append("N\n");
        
        System.setIn(new ByteArrayInputStream(inputBuilder.toString().getBytes()));

        FindtheRedThread.playGame();
        String output = outputStreamCaptor.toString();
        
        assertTrue(output.contains("You picked 5 spools"));
    }


    // Corresponds to Group 4 TestDesign: Find the Red Thread Rainy Day Path
    @Test
    void inputZeroShouldReturnErrorMessageForRedThread() {
        StringBuilder inputBuilder = new StringBuilder("0\n2\n"); 
        for(int i = 0; i < 30; i++) {
            inputBuilder.append("\n"); 
        }
        inputBuilder.append("N\n"); 
        
        System.setIn(new ByteArrayInputStream(inputBuilder.toString().getBytes()));

        FindtheRedThread.playGame();
        String output = outputStreamCaptor.toString();
        
        assertTrue(output.contains("Invalid choice. Please enter an integer between 1 and 10"));
    }
}