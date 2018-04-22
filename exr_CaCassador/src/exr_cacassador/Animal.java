/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_cacassador;

/**
 *
 * @author soib1a20
 */
public abstract class Animal {

    String nom;
    int nivellAlimentacio = 0;
    int edat = 0;
    int edatMax;

    public Animal(String nom, int edatMax) {
        this.nom = nom;
        this.edatMax = edatMax;
    }

    public void menja(int aliment) {
        if (!esViu()) {
            malaNoticia();
            return;
        }
        this.nivellAlimentacio += aliment;
        System.err.println(nom + " ha menjat " + aliment + " unitats.");
    }

    public boolean esFelis() {
        if (!esViu()) {
            malaNoticia();
            return false;
        }
        return nivellAlimentacio > 0;
    }

    public boolean esViu() {
        return (nivellAlimentacio > 0 && edat <= edatMax);
    }

    public void envelleix() {
        if (!esViu()) {
            malaNoticia();
            return;
        }
        edat++;
        System.err.println(nom + " ha envellit 1 any!");
    }

    public int getEdat() {
        if (!esViu()) {
            return -1;
        }
        return edat;
    }

    @Override
    public String toString() {
        return "Animal{" + "nom=" + nom + ", nivellAlimentacio=" + nivellAlimentacio + ", edat=" + edat + ", edatMax=" + edatMax + '}';
    }

    private void malaNoticia() {
        System.err.println("Malauradament '" + nom + " ha mort! R.I.P.");
    }

}
