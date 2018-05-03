/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author soib1a20
 */
public class Tienda {

    private static Tienda instance = null;
    //private static Map<String, GildedRose> tiendas = new HashMap<>();

    private Tienda() {
    }

    public static Tienda getInstance() {
        if (instance == null) {
            instance = new Tienda();
        }
        return instance;
    }

    /*public static void addShop(String name, GildedRose shop) {
    Map<String,GildedRose> nuevo = new HashMap<>(){name,shop};
    tiendas.add(new HashMap<String,GildedRose>(name,shopName);
    }
    
    public static String[] getShops() {
    String retVal = "";
    for (GildedRose shop : tiendas) {
    retVal += shop.toString() + ";";
    }
    return retVal.split(";");
    }*/

}
