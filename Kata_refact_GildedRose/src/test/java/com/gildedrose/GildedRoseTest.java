package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void decay_1_quality_each_day() {
        NewItem[] items = new NewItem[]{new NewItem("+5 Dexterity Vest", 10, 20),
            new NewItem("Elixir of the Mongoose", 10, 20)};
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();

        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

}
