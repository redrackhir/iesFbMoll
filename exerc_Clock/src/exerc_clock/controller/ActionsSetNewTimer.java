/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_clock.controller;

import exerc_clock.view.FrmSetNewTimer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import static javafx.util.Duration.hours;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author soib1a20
 */
public class ActionsSetNewTimer {

    private FrmSetNewTimer frame;
    private boolean isTimerRunning = false;
    private Timer timer;
    private Timestamp timestamp;

    public ActionsSetNewTimer(FrmSetNewTimer frame) {
        this.frame = frame;
        initComponents();

    }

    private void initComponents() {
        frame.setTitle("Nueva timera");
        frame.getjButton1().setText("Iniciar");
        frame.getjLabel1().setText("00:00.00");
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkTimer();
            }

        });
    }

    public void setTimerTime(ChangeEvent evt) {
        int hours = 0, mins = 0, secs = 0;
        if (evt.getSource().equals(frame.getjSlider1())) {
            hours = frame.getjSlider1().getValue();
        }
        if (evt.getSource().equals(frame.getjSlider2())) {
            mins = frame.getjSlider2().getValue();
        }
        if (evt.getSource().equals(frame.getjSlider3())) {
            secs = frame.getjSlider3().getValue();
        }
        timestamp.setHo
        
        checkTimer();
    }

    private void checkTimer() {
        Date hora = new Date();
        Color c = Color.black;
        if (hora.getHours() == hours && hora.getMinutes() == mins && timer.isRunning()) {
            if (hora.getSeconds() >= secs && hora.getSeconds() <= secs + 10) {
                c = hora.getSeconds() % 2 == 0 ? Color.cyan : Color.orange;
            }
            // Suena la timera
            frame.getjLabel1().setForeground(c);
            frame.getjLabel1().setText("Timer!!!");
        } else {
            c = timer.isRunning() ? new Color(50, 200, 50) : Color.black;
            frame.getjLabel1().setForeground(c);
            frame.getjLabel1().setText(String.format("%02d:%02d.%02d", hours, mins, secs));
        }
    }

    public void startTimer() {
        isTimerRunning = !isTimerRunning;
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }

}
