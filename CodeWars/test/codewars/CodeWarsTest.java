package codewars;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author red rackhir
 */
public class CodeWarsTest {

    public CodeWarsTest() {
    }

    /**
     * Test of main method, of class CodeWars.
     */
    @Test
    public void testMain() {
        assertEquals("42 -9", CodeWars.HighAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    @Test
    public void findTest() {
        assertEquals(5, CodeWars.findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        assertEquals(-1, CodeWars.findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        assertEquals(5, CodeWars.findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        assertEquals(10, CodeWars.findIt(new int[]{10}));
        assertEquals(10, CodeWars.findIt(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        assertEquals(1, CodeWars.findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }
}
