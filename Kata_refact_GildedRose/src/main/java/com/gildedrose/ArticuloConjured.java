package com.gildedrose;

/**
 *
 * @author red rackhir
 */
public class ArticuloConjured extends NewItem implements Updateable {

    public ArticuloConjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn--;
        quality -= 2;
        if (quality < 0) {
            quality = 0;
        }
    }

}
