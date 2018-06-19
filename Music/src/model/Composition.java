package model;
/*                                                                                                                              
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import view.FreeView;
import view.SelectModeMusic;
//import org.jfugue.*;

/**
 *
 * @author Klodjan Hidri
 * @author Evagelia Petavraki
 */
public abstract class Composition {

    public boolean choose = false;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private String notes;
    private String instrument;
    private String nameOfComposition;
    private String composer;
    private String mode, info, tmp;
    private String information = null;
    // JFileChooser fc=new JFileChooser("C:/home");
    private JFrame frame = new JFrame();

    public Composition() {
    }

    /**
     * Kataskeuastria methodo gia thn dimiourgeia enos composition me notes
     * ,organo ,sunthetis ,kai to eidos mousikis algorithmic ,atonal h free
     *
     * @param notes
     * @param instrument
     * @param composer
     * @param mode
     */
    public Composition(String instrument, String composer, String mode, String nameOfComposition) {
        this.instrument = instrument;
        this.composer = composer;
        this.mode = mode;
        this.nameOfComposition = nameOfComposition;

    }

    public Composition(String notes, String instrument, String composer,
            String mode, String nameOfComposition) {
        this.instrument = instrument;
        this.mode = mode;
        this.nameOfComposition = nameOfComposition;
        this.composer = composer;
        this.notes = notes;
    }

    /**
     * anoigoume ena arxio apo to UI kai epistrefoume tis notes
     *
     * @param file
     * @return ena string apo notes
     */
    public Boolean openFile(String filepath) throws FileNotFoundException, IOException {


        BufferedReader inputStream = null;
        inputStream = new BufferedReader(new FileReader(filepath));
        while (inputStream.ready()) {
            if (tmp == null) {
                tmp = inputStream.readLine();
            } else {
                tmp += inputStream.readLine();
            }
        }

        this.choose = true;
        this.setInfo(tmp);

        return choose;

    }

    /**
     * Dimiourgeia enos arxiou me notes
     */
    public void newFile() {
        SelectModeMusic a = new SelectModeMusic();
        a.setVisible(true);

    }

    /**
     * apothikeusi enos arxiou me tis notes
     *
     * @param a
     */
    public void saveFile(String name) throws IOException {
        saveFile(new File(name));
    }

    public void saveFile(File file) throws IOException {
        if (this.saveAsFile(file) == true) {
            try {
                fw = new FileWriter(file.getAbsoluteFile());
            } catch (IOException ex) {
                Logger.getLogger(FreeView.class.getName()).log(Level.SEVERE, null, ex);
            }
            bw = new BufferedWriter(fw);
            this.bw.write(this.getNotes());

            bw.close();
        } else {
            System.out.print("Nothing");
        }

    }

    /**
     * apothikeusi enos arxiou me to onoma pou thelei o xristis
     *
     * @param a
     */
    public void saveAsFile(String name) {
        saveAsFile(new File(name));
    }

    public Boolean saveAsFile(File file) {


        try {
            fw = new FileWriter(file.getAbsoluteFile());
        } catch (IOException ex) {
            Logger.getLogger(FreeView.class.getName()).log(Level.SEVERE, null, ex);
        }
        bw = new BufferedWriter(fw);
        try {
            bw.write(this.getInfo());
        } catch (IOException ex) {
            Logger.getLogger(FreeView.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(FreeView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    abstract void exportFile(String a);

    /**
     * dieksagoume ena arxio
     *
     * @param a
     */
    abstract void exportFile(File file);

    public void Quit() {
        System.exit(0);


    }

    /**
     * epistrofi tou organou pou epelekse o xristis
     *
     * @return to organo
     */
    public String getInstrument() {
        if (this.instrument == null) {
            this.instrument = "Piano";
        }
        return this.instrument;

    }

    /**
     * epilogi tou organou pou epelekse o xristis sto menu
     *
     * @param x
     */
    public void setInstrument(String instrument) {

        this.instrument = instrument;

    }

    /**
     * plirofories gia thn leitourgia tou composition programatos
     */
    public void help() {
    }

    /**
     * epistrofi tou mode
     *
     * @return mode
     */
    public String getMode() {
        return this.mode;
    }

    /**
     * epilogi tou mode apo ton xristi mesw tou UI
     *
     * @param mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     *
     * @param notes
     */
    public void setInfo(String inf) {
        if (info == null) {
            this.info = inf;
        } else {
            this.info += inf;
        }

    }

    public String getInfo() {
        return this.info;

    }

    public void setInformation(String a) {
        this.information = a;

    }

    public String getInformation() {
        return this.information;
    }

    public void setNotes(String notes) {
        if (this.notes == null) {
            this.notes = notes;
        } else {
            this.notes += notes;
        }
    }

    public String getNotes() {
        System.out.println(this.notes);
        return this.notes;
    }

    public void setnameOfComposition(String nameOfComposition) {
        this.nameOfComposition = nameOfComposition;
    }

    public String getnameOfComposition() {
        return this.nameOfComposition;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getComposer() {
        return this.composer;
    }

    /**
     * 2 methodi abstract pou prepei na ilopoiithoun apo tis 3 upoklaseis tou
     * Composition Free Atonal Algorithmic
     */
    abstract void playMusic();

    abstract void stopMusic();
}
