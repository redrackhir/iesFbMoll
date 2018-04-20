package com.gildedrose;

/**
 *
 * @author red rackhir
 */


public class ArticuloSulfuras extends ArticuloComun implements Updateable {
    
    public ArticuloSulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    
    @Override
    public void updateQuality() {
        // Do nothing
    }
    
}
