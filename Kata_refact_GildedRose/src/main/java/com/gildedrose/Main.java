package com.gildedrose;

/**
 *
 * @author red rackhir
 */
public class Main {

    static GildedRose miTienda;
    static NewItem[] items;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        items = new NewItem[]{new ArticuloBrie("Aged Brie", 10, 3),
            new ArticuloBrie("Aged Brie from Winterfell", 3, 5),
            new NewItem("Elixir of Moongoose", 3, 5),
            new ArticuloBackstage("Backstage pass for 7Eleven", 11, 8),
            new ArticuloConjured("Conjured wand of new Age", 3, 5),
            new ArticuloSulfuras("Sulfuras, Hand of Ragnaros", 3, 5)};

        miTienda = new GildedRose(items);

        decay(5);

    }

    public static void decay(int days) {
        System.out.println("Item name                    sell qlty");
        for (int i = 0; i < days; i++) {
            miTienda.updateQuality();
            //                  123456789 123456789 123456789 123 456789 
            System.out.println("\n--------------- Day " + String.format("%2d", i) + " ---------------");
            showStatus();
        }
    }

    public static void showStatus() {
        for (NewItem item : items) {
            System.out.println(item);
        }
    }

}
