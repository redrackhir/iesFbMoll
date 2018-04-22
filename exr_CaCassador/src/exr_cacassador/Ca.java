/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_cacassador;

import java.util.ArrayList;

/**
 *
 * @author soib1a20
 */
public class Ca extends Animal implements Cassador {

    private Genere genere;
    private String rassa;
    private Ca pare = null;
    private Ca mare = null;
    private Ca parella = null;
    private boolean isPregnant;

    public Ca(String nom, int edat) {
        super(nom, edat);
        this.edatMax = 14;
        this.nivellAlimentacio = 2;
        this.genere = Tools.getRandomSuccess(50) ? Genere.MASCLE : Genere.FEMELLA;
    }

    @Override
    public void cassa() {
        if (edat < 2) {
            System.err.println(nom + " és massa petit per caçar.");
        } else {
            nivellAlimentacio += (int) ((Math.random() * 5) - 2);
            System.err.println(nom + " ha caçat algunes aus i una llebra.");
        }
    }

    public void aparella(Ca parella) {
        // El ca s'aparella si la parella es de genere contrari...
        // Amb un 65% de possibilitat de quedar fecundada...
        // El nº de cadells pot variar entre 2 i 8
        System.out.print(nom + " i " + parella.getNom() + " s'estan olorant");
        if (!parella.getGenere().equals(this.getGenere()) && this.genere == Genere.FEMELLA) {
            // Es femella y la parella mascle
            isPregnant = ((Math.random() * 100) < 65);
            if (isPregnant) {
                System.out.println(" i l'ha fecundat!!");
            } else {
                System.out.println(" però no hi ha hagut sort.");
            }
        } else {
            System.out.println(" i s'han fet amics.");
        }
    }

    public ArrayList<Ca> teCries() {
        ArrayList<Ca> cadells = new ArrayList<>();
        if (isPregnant) {
            // La camada pot tenir entre 2 i 8 cries
            for (int i = 0; i < Tools.getRandomNumBetween(2, 8); i++) {
                Ca cadell = new Ca(getRandomName(), 0);
                cadell.pare = this.parella;
                cadell.mare = this;
                cadells.add(cadell);
            }
            System.out.println(nom + " ha tingut " + cadells.size() + " cadells!! Ooohhh");
        }
        return cadells;
    }

    @Override
    public boolean esFelis() {
        return nivellAlimentacio > 3;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Ca getPare() {
        return pare;
    }

    public Ca getMare() {
        return mare;
    }

    public boolean isIsPregnant() {
        return isPregnant;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return super.toString() + " Ca{" + "genere=" + genere + ", raça=" + rassa
                + ", pare=" + pare + ", mare=" + mare + ", prenyada=" + isPregnant
                + ", parella=" + parella
                + '}';
    }

    private String getRandomName() {
        if (this.genere == Genere.MASCLE) {
            int max = NomsDeAnimals.nomsMascle.length;
            this.nom = NomsDeAnimals.nomsMascle[Tools.getRandomNumBetween(0, max)];
        } else {
            int max = NomsDeAnimals.nomsFemella.length;
            this.nom = NomsDeAnimals.nomsFemella[Tools.getRandomNumBetween(0, max)];
        }
        return nom;
    }

}
