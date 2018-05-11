/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_clock.controller;

import exerc_clock.view.FrmMain;
import exerc_clock.view.FrmSetNewAlarm;
import exerc_clock.view.FrmSetNewTimer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author soib1a20
 */
public class ActionsMain {

    private Timer timerCurrent;
    private Timer timerTemp;
    private Timer timerChrono;
    private FrmMain frame;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public ActionsMain(FrmMain frame) {
        this.frame = frame;
        initComponents();
    }

    void centerFrame() {
        Dimension scr = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((scr.width - frame.getSize().width) / 2, (scr.height - frame.getSize().height) / 2);
    }

    void refreshCurrentTime() {
        frame.getjLabel1().setText(sdf.format(new Date()));
    }

    private void initComponents() {
        centerFrame();
        this.frame.setTitle("Execicis amb swing/awt (Graphical environment)");
        // reset labels
        frame.getjLabel1().setText("");
        // init time counter
        timerCurrent = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshCurrentTime();
            }
        });
        timerCurrent.start();

    }

    public void showSetNewAlarm() {
        FrmSetNewAlarm frm = new FrmSetNewAlarm();
        frm.setVisible(true);
    }

    public void showSetNewTimer() {
        FrmSetNewTimer frm = new FrmSetNewTimer();
        frm.setVisible(true);
    }
}
