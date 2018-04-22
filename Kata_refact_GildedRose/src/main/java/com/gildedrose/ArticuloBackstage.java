package com.gildedrose;

/**
 *
 * @author red rackhir
 */
public class ArticuloBackstage extends NewItem implements Updateable {

    public ArticuloBackstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn--;
        if (sellIn > 10) {
            quality++;
            return;
        }
        if (sellIn < 0) {
            quality = 0;
            return;
        }
        if (sellIn < 10) {
            quality += 2;
        }
        if (sellIn < 5) {
            quality++;
        }
    }
}
