package com.gildedrose;

/**
 *
 * @author red rackhir
 */
public class ArticuloBrie extends NewItem implements Updateable {

    public ArticuloBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn--;
        if (sellIn >= 0) {
            quality++;
        } else {
            quality += 2;
        }
        if (quality > 50) {
            quality = 50;
        }
    }

}
