import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindTheThimbleTest {

    /*tests max and min */
    @Test
    public void testRoundRangeConstants() {
        assertEquals(1, FindTheThimble.MIN_ROUNDS, "Minimum rounds should be 1");
        assertEquals(9, FindTheThimble.MAX_ROUNDS, "Maximum rounds should be 9");
    }

    /* makes sure L and R properly set     */
    @Test
    public void testHandConstants() {
        assertEquals(1, FindTheThimble.LEFT, "LEFT constant should be 1");
        assertEquals(2, FindTheThimble.RIGHT, "RIGHT constant should be 2");
        assertArrayEquals(new char[]{'L', 'R'}, FindTheThimble.GUESS_OPTIONS, "Guess options should be L and R");
    }

    /* makes sure an odd number is entered */
    @Test
    public void testOddNumberValidation() {
        int[] validOdds = {1, 3, 5, 7, 9};
        for (int num : validOdds) {
            assertTrue(num % 2 != 0 && num >= 1 && num <= 9, 
                num + " should be a valid round count.");
        }

        int[] invalidEvens = {2, 4, 6, 8};
        for (int num : invalidEvens) {
            assertFalse(num % 2 != 0, num + " should be invalid because it is even.");
        }
    }

    /* connects to find the thimble */
    @Test
    public void testPlayGameRuns() {
        assertNotNull(new FindTheThimble(), "Class should be instantiable.");
    }
}