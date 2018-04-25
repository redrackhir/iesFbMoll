/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresario.model;

import java.util.ArrayList;

/**
 *
 * @author red rackhir
 */
public class Stock {

    private static ArrayList<Product> stock = new ArrayList<>();

    public Stock() {
    }
    
    public ArrayList<Product> getAll() {
        return stock;
    }

    public static void addProduct(Product p) {
        stock.add(p);
    }
    
    public static Product get(int index) {
        return stock.get(index);
    }
    
    public static void showStock() {
        for (Product item:stock) {
            System.out.println(item.toString());
        }
    }

    static void updateConsumedProd(Product item, double produced) {
        double qty = item.getQty() - (item.getConsumeQty() * produced);
        item.setQty(qty);
    }
}
