/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafitxers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soib1a20
 */
public class RWTextFile {

    public String readFile(String fileName) {
        String data;
        String line = "";
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);
            while ((data = bf.readLine()) != null) {
                // lee los datos
                line += data;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RWTextFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RWTextFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }
}
