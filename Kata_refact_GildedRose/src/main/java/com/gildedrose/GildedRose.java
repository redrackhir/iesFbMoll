package com.gildedrose;

class GildedRose {

    NewItem[] items;

    public GildedRose(NewItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (NewItem item : items) {
            item.updateQuality();
        }
    }
}
