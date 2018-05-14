/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_clock.controller;

import exerc_clock.view.FrmSetNewChrono;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author soib1a20
 */
public class ActionsSetNewChrono {

    private FrmSetNewChrono frame;
    private boolean isChronoRunning = false;
    private Timer timer;
    private LocalTime crono = LocalTime.of(0, 0);

    public ActionsSetNewChrono(FrmSetNewChrono frame) {
        this.frame = frame;
        initComponents();

    }

    private void initComponents() {
        frame.setTitle("Cronómetro");
        frame.getjButton1().setText("Iniciar");
        frame.getjLabel1().setText("00:00:00.00");
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkChrono();
            }

        });
    }

    public void setChronoTime(ChangeEvent evt) {
        crono = LocalTime.of(0, 0);
//        countDown = countDown.plusHours(frame.getjSlider1().getValue());
//        countDown = countDown.plusMinutes(frame.getjSlider2().getValue());
//        countDown = countDown.plusSeconds(frame.getjSlider3().getValue());

        refreshChronoView();
    }

    private void checkChrono() {
        Color c = Color.black;
        crono = crono.plus(100, ChronoUnit.MILLIS);

        c = timer.isRunning() ? new Color(50, 200, 50) : Color.black;
        frame.getjLabel1().setForeground(c);
        refreshChronoView();
    }

    private void refreshChronoView() {
        int hours = crono.getHour();
        int minutes = crono.getMinute();
        int seconds = crono.getSecond();
        int millis = crono.getNano()/100000000;

        frame.getjLabel1().setText(String.format("%02d:%02d:%02d.%1d", hours, minutes, seconds, millis));
    }

    public void startStopChrono() {
//        isChronoRunning = !isChronoRunning;
        if (timer.isRunning()) {
            timer.stop();
            frame.getjButton1().setText("Start");
        } else {
            timer.start();
            frame.getjButton1().setText("Stop");
        }
        isChronoRunning = timer.isRunning();
    }

}
