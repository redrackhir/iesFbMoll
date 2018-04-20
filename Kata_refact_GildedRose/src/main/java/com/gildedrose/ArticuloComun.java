package com.gildedrose;

import com.gildedrose.Item;

/**
 *
 * @author red rackhir
 */
public class ArticuloComun extends Item implements Updateable {

    public ArticuloComun(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality > 0) {
            quality--;
        }
        sellIn--;
    }

}
