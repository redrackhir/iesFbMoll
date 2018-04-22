/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_electrodomestico;

/**
 *
 * @author soib1a20
 */
public enum Eficiencia {
    A(100), B(80), C(60), D(40), E(20), F(10);
    public int value;

    Eficiencia(int numVal) {
        this.value = numVal;
    }
}
