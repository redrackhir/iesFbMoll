/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercGraph.actions;

import exercGraph.view.FrmMain;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author soib1a20
 */
public class actsMain {

    private FrmMain frame;

    public actsMain(FrmMain frame) {
        this.frame = frame;
        centerFrame();
        this.frame.setTitle("Execicis amb swing/awt (Graphical environment)");
    }

    void centerFrame() {
        Dimension scr = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((scr.width - frame.getSize().width) / 2, (scr.height - frame.getSize().height) / 2);
    }
}
