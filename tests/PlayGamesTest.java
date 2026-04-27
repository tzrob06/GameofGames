import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PlayGamesTest {

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

    // Corresponds to Group 4 TestDesign: Main Menu Sunny Day Path
    @Test
    void inputThreeShouldEnterGuessTheNumberGame() {
        StringBuilder inputBuilder = new StringBuilder("N\n3\n");
        for(int i = 0; i < 20; i++) {
            inputBuilder.append("1\n"); 
        }
        inputBuilder.append("N\n6\n"); 
        
        System.setIn(new ByteArrayInputStream(inputBuilder.toString().getBytes()));

        try {
            PlayGames.main(new String[]{});
        } catch (NoSuchElementException e) {
            
        }

        String output = outputStreamCaptor.toString();
        
        assertTrue(output.contains("Welcome to the Guess the Number Game"));
    }

    // Corresponds to Group 4 TestDesign: Main Menu Rainy Day Path
    @Test
    void inputEightShouldPromptUserToReenterInput() {
        String simulatedInput = "N\n8\n6\n"; 
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        PlayGames.main(new String[]{});
        String output = outputStreamCaptor.toString();
        
        assertTrue(output.contains("Invalid choice. Please enter an integer between 1 and 6."));
    }
}
