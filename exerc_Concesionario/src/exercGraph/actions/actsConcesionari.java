package exercGraph.actions;

import exercGraph.view.FrmConcesionari;
import java.awt.Dimension;
import javax.swing.JRadioButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author soib1a20
 */
public class actsConcesionari {

    private FrmConcesionari frame;
    private final String ND = "no disponible";
    private String color = ND;
    private String motor = ND;
    private String pais = ND;

    public actsConcesionari(FrmConcesionari frame) {
        this.frame = frame;
        initComponents();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        frame.getLblColor().setText(this.color);
    }

    public String getMotor() {
        return motor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais() {
        this.pais = (String) frame.getCbxPais().getSelectedItem();
        frame.getLblPais().setText(this.pais);
    }

    public void setMotor() {
        int tipoMotor;
        tipoMotor = frame.getCbxGasolina().isSelected() ? 1 : 0;
        tipoMotor += frame.getCbxElectrico().isSelected() ? 2 : 0;
        switch (tipoMotor) {
            case 1:
                motor = "gasolina";
                break;
            case 2:
                motor = "100% eléctrico";
                break;
            case 3:
                motor = "híbrido";
                break;
            default:
                motor = ND;
        }
        frame.getLblMotor().setText(this.motor);
    }

    public void showResult() {
        // Mostrar panel de resultado
        frame.getjTabbedPane1().setSelectedIndex(3);
        String texto = "";
        if (color.equalsIgnoreCase(ND) || motor.equalsIgnoreCase(ND) || pais.equalsIgnoreCase(ND)) {
            texto = "Faltan datos por escoger!!";
        } else {
            String frmt = "Ha escogido un modelo de color %s, con motor %s y fabricado en %s.";
            texto = String.format(frmt, color, motor, pais);
        }
        frame.getLblResultado().setText(texto);
    }

    @Override
    public String toString() {
        return "color=" + color + ", motor=" + motor + ", pais=" + pais;
    }

    void centerFrame() {
        Dimension scr = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((scr.width - frame.getSize().width) / 2, (scr.height - frame.getSize().height) / 2);
    }

    private void initComponents() {
        centerFrame();
        frame.setTitle("Seleccione componentes del vehiculo");
        frame.getButtonGroupColor().clearSelection();
        frame.getRbRojo().setSelected(true);
    }

}
