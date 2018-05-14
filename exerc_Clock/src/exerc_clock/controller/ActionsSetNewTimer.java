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
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
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
    private LocalTime countDown = LocalTime.of(0, 0);

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
        countDown = LocalTime.of(0, 0);
        countDown = countDown.plusHours(frame.getjSlider1().getValue());
        countDown = countDown.plusMinutes(frame.getjSlider2().getValue());
        countDown = countDown.plusSeconds(frame.getjSlider3().getValue());

        refreshTimerView();
    }

    private void checkTimer() {
        Color c = Color.black;
        if (countDown.get(ChronoField.MILLI_OF_DAY) <= 0 & isTimerRunning) {
            // Suena el timbre
            c = new Date().getSeconds() % 2 == 0 ? Color.cyan : Color.orange;
            frame.getjLabel1().setForeground(c);
            frame.getjLabel1().setText("Timer!!!");
        } else {
            countDown = countDown.minusSeconds(1);
            c = timer.isRunning() ? new Color(50, 200, 50) : Color.black;
            frame.getjLabel1().setForeground(c);
        }
        refreshTimerView();
    }

    private void refreshTimerView() {
        int hours = countDown.getHour();
        int minutes = countDown.getMinute();
        int seconds = countDown.getSecond();

        frame.getjLabel1().setText(String.format("%02d:%02d.%02d", hours, minutes, seconds));
    }

    public void startStopTimer() {
        isTimerRunning = !isTimerRunning;
        if (timer.isRunning()) {
            timer.stop();
            frame.getjButton1().setText("Start");
        } else {
            timer.start();
            frame.getjButton1().setText("Stop");
        }
        bloqControls();
    }

    private void bloqControls() {
        // Bloquea los sliders si esta el temporizador en marcha
        frame.getjSlider1().setEnabled(!isTimerRunning);
        frame.getjSlider2().setEnabled(!isTimerRunning);
        frame.getjSlider3().setEnabled(!isTimerRunning);
    }

}
