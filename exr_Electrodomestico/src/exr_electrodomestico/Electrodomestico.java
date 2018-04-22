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
public class Electrodomestico {

    private final double DEF_PRECIO_BASE = 100f;
    private final Color DEF_COLOR = Color.BLANCO;
    private final Eficiencia DEF_EFICIENCIA = Eficiencia.F;
    private final int DEF_PESO = 5;

    String marca;
    String modelo;
    double precioBase;
    double precioFinal;
    Color color;
    Eficiencia eficiencia;
    int peso;

    public Electrodomestico() {
        this.color = DEF_COLOR;
        this.precioBase = DEF_PRECIO_BASE;
        this.eficiencia = DEF_EFICIENCIA;
        this.peso = DEF_PESO;
        //TODO: Comprobar eficiencia y precios
        adjustPrice();
    }

    public Electrodomestico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Electrodomestico(double precioBase, int peso) {
        this();
        this.precioBase = precioBase;
        this.peso = peso;
        adjustPrice();
    }

    public Electrodomestico(double precioBase, int peso, String color, String eficiencia) {
        this();
        this.color = comprobarColor(color);
        this.precioBase = precioBase;
        this.eficiencia = comprobarConsumoEnergetico(eficiencia);
        this.peso = peso;
        adjustPrice();
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public double getPrecio() {
        return precioBase;
    }

    public Color getColor() {
        return color;
    }

    public Eficiencia getEficiencia() {
        return eficiencia;
    }

    public int getPeso() {
        return peso;
    }

    private Eficiencia comprobarConsumoEnergetico(String letra) {
        letra = letra.toUpperCase();
        for (Eficiencia e : Eficiencia.values()) {
            if (e.name().equals(letra)) {
                return Eficiencia.valueOf(letra);
            }
        }
        return Eficiencia.F;
    }

    private Color comprobarColor(String color) {
        color = color.toUpperCase();
        for (Color e : Color.values()) {
            if (e.name().equals(color)) {
                return Color.valueOf(color);
            }
        }
        return Color.BLANCO;
    }

    private void adjustPrice() {
        // Reajustar por tipo de eficiencia
        precioFinal = precioBase + eficiencia.value;
        // y por peso
        int plusPeso = 0;
        if (peso > 0 && peso < 20) {
            plusPeso = 10;
        } else if (peso > 19 && peso < 50) {
            plusPeso = 50;
        } else if (peso > 49 && peso < 80) {
            plusPeso = 80;
        } else if (peso > 79) {
            plusPeso = 100;
        }
        precioFinal += plusPeso;
    }

    @Override
    public String toString() {
        return "Electrod. {" + marca + " - " + modelo + ", color " + color + ". PVD: " + precioBase + "€. PVP: " + precioFinal
                + ". Cat." + eficiencia + ". " + peso + "Kg.} ";
    }

}
