/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_notepad;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author soib1a20
 */
public class ActsMainFrame {

    private MainFrameMdi frame;
    private String fileName = "";
    private final int MODE_LOAD = 0;
    private final int MODE_SAVE = 1;

    public ActsMainFrame(MainFrameMdi frame) {
        this.frame = frame;
    }

    public void openFile() {
        BufferedReader br = null;
        try {
            fileName = getFileChoose(MODE_LOAD);
            if (fileName == null) {
                return;
            }
            //
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName)));
            String line, content = "";
            while ((line = br.readLine()) != null) {
                content = content.concat(line).concat("\r\n");
            }
            frame.getjTextArea1().setText(content);
            frame.setTitle(fileName + " - Java NotePad");
        } catch (IOException ex) {
            Logger.getLogger(ActsMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Logger.getLogger(ActsMainFrame.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ActsMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String getFileChoose(int mode) throws HeadlessException {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione archivo");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fc.setFileFilter(filter);
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Documentos de Word", "doc");
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Archivos de proceso por lotes", "bat");
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Todos los archivos", "*");
        fc.addChoosableFileFilter(filter);
        int retVal;
        //
        switch (mode) {
            case 0: // load
                retVal = fc.showOpenDialog(frame);
                break;
            default: // save

                retVal = fc.showSaveDialog(frame);
        }
        //
        switch (retVal) {
            case JFileChooser.APPROVE_OPTION:
                return fc.getSelectedFile().getAbsolutePath();
            default:
                return null;
        }
    }

    public void saveFile(String customName) {
        String fileName = customName == null ? this.fileName : customName;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));

            bw.write(frame.getjTextArea1().getText());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ActsMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ActsMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ActsMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void saveFileAs() {
        String retVal = getFileChoose(MODE_SAVE);
        saveFile(retVal);
    }

}
