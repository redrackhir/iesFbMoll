package com.gildedrose;

class GildedRose {
    ArticuloComun[] items;

    public GildedRose(ArticuloComun[] items) {
        this.items = items;
    }

    public void updateQuality() {
       for (ArticuloComun item:items) {
           item.updateQuality();
       }
    }
}