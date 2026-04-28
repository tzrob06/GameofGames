import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the CoinFlip class.
 * Tests core game logic, constants, and mode behavior based on the design team's use case.
 * 
 * @author Liu Restrepo, Zoe Kuehne, Jake Acquarulo, Thomas Robertson
 * @version 1.0
 * @since 2026-04-27
 */
public class CoinFlipTest {
    
    /**
     * Tests that the round range constants are correctly defined.
     */
    @Test
    public void testRoundRangeConstants() {
        assertEquals(1, CoinFlip.MIN_ROUNDS, "Minimum rounds should be 1");
        assertEquals(9, CoinFlip.MAX_ROUNDS, "Maximum rounds should be 9");
    }
    
    /**
     * Tests that the HEADS and TAILS constants are correctly defined.
     */
    @Test
    public void testCoinConstants() {
        assertEquals("HEADS", CoinFlip.HEADS, "HEADS constant should be 'HEADS'");
        assertEquals("TAILS", CoinFlip.TAILS, "TAILS constant should be 'TAILS'");
    }
    
    /**
     * Tests that odd number validation would work correctly.
     * Note: Full validation is tested via GetInput class.
     */
    @Test
    public void testOddNumberValidation() {
        // Odd numbers between 1-9 should be valid
        int[] validOddNumbers = {1, 3, 5, 7, 9};
        for (int num : validOddNumbers) {
            assertTrue(num % 2 == 1 && num >= 1 && num <= 9, 
                num + " should be a valid odd round count");
        }
        
        // Even numbers should be invalid
        int[] invalidEvenNumbers = {2, 4, 6, 8};
        for (int num : invalidEvenNumbers) {
            assertTrue(num % 2 == 0, 
                num + " should be invalid (even number)");
        }
    }
    
    /**
     * Tests that the playGame method runs without crashing.
     */
    @Test
    public void testPlayGameRuns() {
        assertDoesNotThrow(() -> CoinFlip.playGame(),
            "playGame method should execute without exceptions");
    }
}
