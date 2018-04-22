/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiparking.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author red rackhir
 */
public class ReadWriteObjs {

    private static String workPath = System.getProperty("user.dir");
    private static final String FILENAME_VEHICLES = "Vehicles_";

    public ReadWriteObjs() {
        try {
            this.workPath = new java.io.File(".").getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(ReadWriteObjs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveArray(ArrayList array, String filename) {
        String current;
        try {
            /*current = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + current);*/

            FileOutputStream fos = new FileOutputStream(workPath + "\\" + filename + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(array);
            oos.close();
        } catch (IOException ex) {
            //Logger.getLogger(ReadWriteObjs.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage() + ex.getStackTrace());
        }

    }

    public static ArrayList loadArray(ArrayList destArray, String fromFile) {
        try {
            FileInputStream fis = new FileInputStream(workPath + "\\" + fromFile + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            destArray = (ArrayList) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ReadWriteObjs.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se encuentra el archivo '" + fromFile + "'");
        } catch (IOException ex) {
            Logger.getLogger(ReadWriteObjs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadWriteObjs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return destArray;
    }

    public static ArrayList loadVehiclesPlanta(int nivel) {
        ArrayList<Vehiculo> destArray = new ArrayList<>();
        String fileName = workPath + "\\" + FILENAME_VEHICLES + nivel + ".ser";

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            destArray = (ArrayList) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ReadWriteObjs.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se encuentra el archivo '" + fileName + "'");
        } catch (IOException ex) {
            Logger.getLogger(ReadWriteObjs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadWriteObjs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return destArray;
    }
}
