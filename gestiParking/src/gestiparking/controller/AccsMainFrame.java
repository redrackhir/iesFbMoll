/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiparking.controller;

import gestiparking.model.Parking;
import gestiparking.model.Vehiculo;
import gestiparking.view.FrmPlanta;
import gestiparking.view.MainFrame;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author red rackhir
 */
public class AccsMainFrame {

    private static Parking parking;
    //private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private MainFrame frame;

    public AccsMainFrame(MainFrame frame) {
        this.frame = frame;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        // 1 planta con 10 plazas
        parking = new Parking(1, 50);
    }

    public void showPlanta(int planta) {
        // Mostrar frame de Planta
        FrmPlanta p = new FrmPlanta(1, 10);
        p.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        p.setSize(400, 380);
        p.setVisible(true);

    }

    public void entraVehiculoAleatorio() {
        Vehiculo v = parking.vehicleEnter("");
        updateListVehiculos();
        updateInfoParking();
    }

    public void saleVehiculoAleatorio() {
        Vehiculo v = parking.vehicleLeave("");
        updateListVehiculos();
        updateInfoParking();
        //return v;
    }

    private void updateListVehiculos() {
        JList lista = frame.getListVehicles();
        DefaultListModel model = new DefaultListModel();
        for (Vehiculo v : parking.getVehiculos()) {
            model.addElement(v);
        }

        lista.removeAll();
        lista.setModel(model);
        lista.repaint();

    }

    private void updateInfoParking() {
        // Actualiza las etiquetas de texto
        frame.getjLabel2().setText("Vehículos en parking: " + parking.getVehiculos().size());
        frame.getjLabel3().setText("Entradas: " + parking.getEntradas());
        frame.getjLabel4().setText("Salidas: " + parking.getSalidas());
        frame.getjLabel5().setText("Plazas libres: " + parking.getPlacesFree());
        frame.getjLabel6().setText("Plazas ocupadas: " + parking.getPlacesOcupied());
        frame.getjLabel7().setText("TOTAL PLAZAS: " + parking.getCapacity());
    }

}
