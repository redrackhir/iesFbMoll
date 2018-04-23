/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresario.model;

/**
 *
 * @author red rackhir
 */
public class Product {

    private int uid;
    private String name;
    private double qty;
    private String measureType;
    private double consumeQty;      // Qty consumed to produce 1 unit of...

    public Product(int uid, String name, int qty, String measureType, double consumeQty) {
        this.uid = uid;
        this.name = name;
        this.qty = qty;
        this.measureType = measureType;
        this.consumeQty = consumeQty;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getConsumeQty() {
        return consumeQty;
    }

    @Override
    public String toString() {
        return "[" + uid + "] " + name + " " + qty + " " + measureType;
    }

}
