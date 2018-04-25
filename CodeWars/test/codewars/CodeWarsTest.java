package codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CodeWarsTest {

    /* @Test
    public void testSimpleDirReduc() throws Exception {
    assertEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
    new String[]{"WEST"},
    CodeWars.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    
    assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
    new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
    CodeWars.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }*/
    @Test
    public void example() {
        assertEquals(0, Dinglemouse.deadAntCount("ant ant ant ant"));
        assertEquals(0, Dinglemouse.deadAntCount(null));
        assertEquals(2, Dinglemouse.deadAntCount("ant anantt aantnt"));
        assertEquals(1, Dinglemouse.deadAntCount("ant ant .... a nt"));
    }

    @Test
    public void test1() {
        String art[] = new String[]{"ZBAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[]{"A", "B"};
        assertEquals("(A : 0) - (B : 1140)",
                StockList.stockSummary(art, cd));
    }

}
