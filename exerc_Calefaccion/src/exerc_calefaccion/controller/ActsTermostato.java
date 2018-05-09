/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_calefaccion.controller;

import exerc_calefaccion.Utils;
import exerc_calefaccion.model.FuenteCalor;
import exerc_calefaccion.model.Habitacion;
import exerc_calefaccion.model.LectorTemperatura;
import exerc_calefaccion.view.FrmTermostato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author red rackhir
 */
public class ActsTermostato {

    private FrmTermostato frame;
    private Timer timer;
    private boolean isRunning = false;

    private final Habitacion habitacion;
    private final LectorTemperatura lectorTemp;
    private final FuenteCalor fuenteCalor;

    public ActsTermostato(FrmTermostato frame, Habitacion habitacion,
            LectorTemperatura lectorTemp, FuenteCalor fuenteCalor) {
        this.frame = frame;
        this.habitacion = habitacion;
        this.lectorTemp = lectorTemp;
        this.fuenteCalor = fuenteCalor;
        initComponents();
    }

    private void initComponents() {
        frame.setTitle(habitacion.getNombre());
        frame.getIconLabel().setText("");
        frame.getIconLabel().setEnabled(false);
        //Utils.centrarFrame(frame);
        // temporizador para refresco de info
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerTickEvent();
            }
        });
        timer.start();
    }

    private void timerTickEvent() {
        // Encender/apagar caldera en funcion de la temperatura
        regulaTemp();
        refrescaInfo();
    }

    private void regulaTemp() {
        float temp = lectorTemp.leer(habitacion);
        float sel = frame.getTempSeleccionada();
        if (isRunning & temp < sel) {
            fuenteCalor.encender(habitacion);
        } else {
            fuenteCalor.apagar(habitacion);
        }
    }

    public void refrescaInfo() {
        frame.getTempLabel().setText(String.format("%2.1f", lectorTemp.leer(habitacion)));
        frame.getIconLabel().setEnabled(fuenteCalor.isEncendido());
        frame.getInfoLabel().setText(String.format("Seleccionado: %s ºC", frame.getTempSeleccionada()));
    }

    public void startStop() {
        isRunning = !isRunning;
    }

    public void showDetails() {
        Object[] options = {"Ok"};
        String sms = "Elemento calefactor: " + fuenteCalor.getNombre()
                + "\nSensor temperatura: " + lectorTemp.getNombre();
        JOptionPane.showOptionDialog(frame, sms, "Información", 0,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
}
