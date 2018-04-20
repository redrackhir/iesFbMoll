/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyparkingconsole;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author red rackhir
 */
class Vehiculo implements Serializable {

    private String matricula;
    private Date horaEntrada;
    private Date horaSalida;

    public Vehiculo(String matricula, Date horaEntrada) {
        this.matricula = matricula;
        this.horaEntrada = horaEntrada;
    }

    public String getMatricula() {
        return matricula;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }
    
    public String getFechaHoraEntradaStr() {
        return new SimpleDateFormat("dd/MM/yy - HH:mm:ss").format(horaEntrada);
    }
    
    public String getHoraEntradaStr() {
        return new SimpleDateFormat("HH:mm:ss").format(horaEntrada);
    }

    public String getHoraSalidaStr() {
        return new SimpleDateFormat("HH:mm:ss").format(horaSalida);
    }

    public long getMinutes() {
        /*String horaEntrada = "11/03/14 09:29:58";
        String horaSalida = "11/03/14 09:33:43";*/

        // Custom date format
        //SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");

        /*Date d1 = null;
        Date d2 = null;
        try {
        d1 = format.parse(horaEntrada);
        d2 = format.parse(horaSalida);
        } catch (ParseException e) {
        e.printStackTrace();
        }*/
        // Get msec from each, and subtract.
        long diff = horaSalida.getTime() - horaEntrada.getTime();
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        //long diffHours = diff / (60 * 60 * 1000);
        /*System.out.println("Time in seconds: " + diffSeconds + " seconds.");
        System.out.println("Time in minutes: " + diffMinutes + " minutes.");
        System.out.println("Time in hours: " + diffHours + " hours.");*/
        
        //return diffMinutes;
        return diffSeconds;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return String.format("%10s # %s",matricula, getFechaHoraEntradaStr());
    }
    
    

}
