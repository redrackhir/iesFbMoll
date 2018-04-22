package exr_gestionempleados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author soib1a20
 */
class RWObjectsFile {

    private String getCurDir() {
        return System.getProperty("user.dir") + "/";
    }

    static ArrayList<?> load(String fileName) {
        FileInputStream fos;
        ObjectInputStream oos;
        ArrayList<?> readedObject = null;
        try {
            fos = new FileInputStream(fileName);
            oos = new ObjectInputStream(fos);
            readedObject = (ArrayList<?>) oos.readObject();
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(RWObjectsFile.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("No se encuentra el archivo '" + fileName + "'");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RWObjectsFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readedObject;
    }

    static boolean save(String fileName, Object obj) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RWObjectsFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RWObjectsFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
