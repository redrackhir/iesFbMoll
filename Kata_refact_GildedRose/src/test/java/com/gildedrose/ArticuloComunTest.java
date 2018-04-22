package com.gildedrose;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author red rackhir
 */
public class ArticuloComunTest {

    public ArticuloComunTest() {
    }

    /**
     * Test of updateQuality method, of class ArticuloComun.
     */
    @Test
    public void testUpdateQuality() {
        System.out.println("updateQuality");
        // TODO review the generated test code and remove the default call to fail.
        GildedRose rck;
        NewItem[] items = new NewItem[]{new NewItem("+5 Dexterity Vest", 0, 0)};

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        System.out.println(items[0]);
        assertEquals("+5 Dexterity Vest", items[0].name);
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);

    }

}
