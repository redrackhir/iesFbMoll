/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiparking.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author red rackhir
 */
public class Asiento implements java.io.Serializable {
    private static int id =0;
    private Date fecha;                 
    private String concepto;                                // concepto ticket
    //private ArrayList<Vehiculo> regVeh = new ArrayList<>(); // registro de E/S del vehiculo
    private String matricula;
    private double importe;

    public Asiento(Date fecha, String concepto, double importe, String matricula) {
        id++;
        this.fecha = fecha;
        this.concepto = concepto;
        this.importe = importe;
        this.matricula = matricula;
    }
    
    public String getShortDate() {
        return new SimpleDateFormat("dd/MM/yy.HH:mm").format(fecha);
    }

    @Override
    public String toString() {
        String formato = "%3d - %s - %-45s %2.2f";
        return String.format(formato, id, getShortDate(),concepto,importe);
    }
    
    
    
    
    
}
