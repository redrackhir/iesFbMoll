/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercGraph.actions;

import exercGraph.view.FrmLogin;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author soib1a20
 */
public class actsLogin {

    FrmLogin frame;
    JTextField tfUser;
    JTextField tfPassword;
    private final JLabel lblInfo;
    private final JLabel lblSendMail;

    public actsLogin(FrmLogin frame) {
        this.frame = frame;
        frame.setTitle("Ejemplo Login");
        tfUser = frame.getTfUser();
        tfPassword = frame.getTfPassword();
        lblInfo = frame.getLblInfo();
        lblInfo.setText("");
        lblSendMail = frame.getLblSendMail();
        lblSendMail.setVisible(false);
        lblSendMail.setText("Olvidé mi contraseña");
        centerFrame();
    }

    private void centerFrame() {
        Dimension scr = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((scr.width - frame.getSize().width) / 2, (scr.height - frame.getSize().height) / 2);
    }

    public void checkLogin() {
        // Comprobar login
        if (tfUser.getText().equalsIgnoreCase("redrackhir") && tfPassword.getText().equals("1234")) {
            lblInfo.setText("<html>Bienvenido " + tfUser.getText()+ "<br>En breves momentos será redirigido.</html>");
            lblInfo.getParent().revalidate();
            lblInfo.setForeground(new Color(50, 150, 50));
            lblSendMail.setVisible(false);
        } else {
            lblInfo.setText("Acceso denegado");
            lblInfo.setForeground(new Color(150, 50, 50));
            lblSendMail.setVisible(true);
        }
    }

    public void sendRecoverMail() {
        Object[] options = {"Ok"};
        JOptionPane.showOptionDialog(frame, "Se ha enviado un mensaje a tu cuenta de correo, revísalo.",
                "Resetear contraseña", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
    }
}
