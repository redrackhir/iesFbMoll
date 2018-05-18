/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_notepad;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author soib1a20
 */
public class ActsMainFrame {

    private MainFrameMdi frame;
    private String fileName = "NoTitle";
    private String extension = "txt";
    private final int MODE_LOAD = 0;
    private final int MODE_SAVE = 1;
    private String clipboard;
    private String findWord;
    private int lastWordPos = 0;
    private boolean findFirst = true;

    public ActsMainFrame(MainFrameMdi frame) {
        this.frame = frame;
        // center frame
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    public void openFile() {
        BufferedReader br = null;
        try {
            fileName = getFileChoose("Open file", MODE_LOAD);
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

    private String getFileChoose(String title, int mode) throws HeadlessException {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle(title);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fc.setFileFilter(filter);
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Word documents", "doc");
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Batch files", "bat");
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("All files", "*");
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
        extension = "";
        switch (retVal) {
            case JFileChooser.APPROVE_OPTION:
                if (mode == MODE_SAVE && !fc.getFileFilter().getDescription().contains("Todos")) {
                    FileNameExtensionFilter fExt = (FileNameExtensionFilter) fc.getFileFilter();
                    extension = "." + fExt.getExtensions()[0];
                }
                return fc.getSelectedFile().getAbsolutePath() + extension;
            default:
                return null;
        }
    }

    public void saveFile(String saveAs) {
        if (fileName.equalsIgnoreCase("noTitle")) {
            fileName = getFileChoose("Save file as", SAVE_DIALOG);
        }

        if (fileName == null) {
            return;
        }

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
        String retVal = getFileChoose("Save file as", MODE_SAVE);
        saveFile(retVal);
    }

    public void onClosingWindow() {
        if (frame.isTextChanged()) {
            String msg = "The document has been changed\nDo you save these changes ?";
            String title = "Save changes";
            if (JOptionPane.showConfirmDialog(frame, msg, title, WARNING_MESSAGE) == YES_OPTION) {
                saveFile(null);
            }
        }
    }

    public void cutWord() {
        JTextArea ta = frame.getjTextArea1();
        String text = ta.getText();
        String selected = ta.getSelectedText();
        int selStart = ta.getSelectionStart();
        int selEnd = ta.getSelectionEnd();

        clipboard = selected;

        String cuttedText = text.substring(0, selStart);
        cuttedText += text.substring(selEnd, text.length());
        frame.getjTextArea1().setText(cuttedText);

    }

    public void copyWord() {
        clipboard = frame.getjTextArea1().getSelectedText();
    }

    public void pasteWord() {
        JTextArea ta = frame.getjTextArea1();
        String text = ta.getText();
        int selStart = ta.getSelectionStart();

        String pastedText = text.substring(0, selStart)
                + clipboard + text.substring(selStart, text.length());
        ta.setText(pastedText);
        ta.setSelectionStart(selStart);
        ta.setSelectionEnd(selStart + clipboard.length());
    }

    public void deleteWord() {
        JTextArea ta = frame.getjTextArea1();
        String text = ta.getText();
        int selStart = ta.getSelectionStart();
        int selEnd = ta.getSelectionEnd();

        String cuttedText = text.substring(0, selStart);
        cuttedText += text.substring(selEnd, text.length());
        frame.getjTextArea1().setText(cuttedText);
    }

    void findWord() {
        findWord = JOptionPane.showInputDialog("Word to find ?");
        findNext();
    }

    void findNext() {
        if (findWord != null) {
            JTextArea ta = frame.getjTextArea1();
            String text = ta.getText();
            int selStart = text.indexOf(findWord, findFirst ? 0 : ta.getSelectionStart()
                    + findWord.length());
            int selEnd = selStart + findWord.length();
            if (selStart > -1) {
                lastWordPos = selStart + 1;
                ta.setSelectionStart(selStart);
                ta.setSelectionEnd(selEnd);
                ta.setSelectionColor(Color.yellow);
                ta.setSelectedTextColor(Color.black);
                findFirst = false;
            } else {
                JOptionPane.showMessageDialog(frame, "No matches found");
                findFirst=true;
            }
        }
    }

    void resetSelectionColors() {
        JTextArea ta = frame.getjTextArea1();
        ta.setSelectionColor(Color.blue);
        ta.setSelectedTextColor(Color.white);
    }

    void countWords() {
        JTextArea ta = frame.getjTextArea1();
        String txt = ta.getText().trim();
        int words = txt.split("\\s+").length; 

        String msg = String.format("There are %d words in the document", words); 
        JOptionPane.showMessageDialog(frame, msg);

    }

}
