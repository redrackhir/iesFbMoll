/*
 * Maquina.java
 * 
 * Copyright (c) 2018 red rackhir.
 * Maquina is distributed under GNU General Public License.
 * 
 */
package empresario.model;

import java.util.ArrayList;

/**
 *
 * @author red rackhir
 */
public class Maquina {

    private int uid;                    // Unique number identification
    private String name;
    private double prodXTurn;           // Production per turn (At full state)
    private double price;               // Price of the machine
    private int maintState;             // State of maintenance (%) 0 = Broken, 100 = Full production
    private boolean enabled = false;    // Machine is working or not
    private int beltCapacity;           // Capacity of products released before line full
    private int beltQty = 0;           // Capacity of products released before line full
    private double energyConsumption;   // Any doubt?
    private double energyConsumed = 0;   // Any doubt?
    private ArrayList<Product> prodConsumed;
    private ArrayList<Product> prodCreated;

    public Maquina(int uid, String name, double prodXTurn, double price, int maintState, int beltCapacity,
            double energyConsumption, ArrayList<Product> prodConsumed, ArrayList<Product> prodCreated) {
        this.uid = uid;
        this.name = name;
        this.prodXTurn = prodXTurn;
        this.price = price;
        this.maintState = maintState;
        this.beltCapacity = beltCapacity;
        this.energyConsumption = energyConsumption;
        this.prodConsumed = prodConsumed;
        this.prodCreated = prodCreated;
    }

    public void nextTurn() {
        if (!enabled) {
            System.out.println("Máquina '"+name+"' parada!");
            return;
        }
        // Products consumed and produced
        double produced = 0;
        if (beltQty + prodXTurn <= beltCapacity) {
            produced = beltQty += prodXTurn;
            consumedProducts(produced);
        } else {
            consumedProducts(produced);
            beltQty = beltCapacity;
            enabled = false;
        }
        // Energy consumed
        energyConsumed += energyConsumption;
        String txt = "Máquina '%s' ha producido: %s uds.\nHa consumido: ??";
        Object[] args = new Object[]{name,produced};
        System.out.println(String.format(txt,args));
    }

    public void enable() {
        energyConsumed = 0;
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }

    public double getProdXTurn() {
        return prodXTurn;
    }

    public void setProdXTurn(double prodXTurn) {
        this.prodXTurn = prodXTurn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUid() {
        return uid;
    }

    public int getBeltCapacity() {
        return beltCapacity;
    }

    public int getBeltQty() {
        return beltQty;
    }

    public double getEnergyConsumed() {
        return energyConsumed;
    }

    public ArrayList<Product> getProdConsumed() {
        return prodConsumed;
    }

    public ArrayList<Product> getProdCreated() {
        return prodCreated;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    public int getMaintState() {
        return maintState;
    }

    public void setMaintState(int maintState) {
        this.maintState = maintState;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String head = "Uid Machine                  prod.x turn   value state queue";
        System.out.println(head);
        String frmt = "[%2d] %-30s %3.1f %6.0f$  %3d%%   %3d";
        return String.format(frmt, uid, name, prodXTurn, price, maintState, beltQty);
    }

    private void consumedProducts(double produced) {
        // Subtract consumed products from stock
        for (Product item : prodConsumed) {
            // get product from stock
            Stock.updateConsumedProd(item, produced);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

}
