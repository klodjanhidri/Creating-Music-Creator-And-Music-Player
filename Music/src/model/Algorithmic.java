package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.regex.Pattern
import org.jfugue.Pattern;
import org.jfugue.Player;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Klodjan Hidri
 * @author Evagelia Petavraki
 */
public class Algorithmic extends Composition {

    private Pattern pattern = new Pattern();
    private Player player = new Player();
    private ArrayList<Integer> number = new ArrayList();
    private String  not;
    private int n;
    private playerThread pthread;
    private Thread threadPlyr;
    
    /*
     * kataskeuastria methodo gia thn 
     * dimiourgia tou antikeimenou Algorithm
     */

    public Algorithmic() {
    }

    /**
     * kataskeuastria methodo gia thn dimiourgia tou antikeimenou Algorithm me
     * parametrous
     *
     * @param s
     * @param instrument
     * @param composer
     * @param mode
     * @param nameOfComposition
     */
    public Algorithmic(String instrument, String composer, String mode, String nameOfComposition) {
        super(instrument, composer, mode, nameOfComposition);

    }

    public void exportFile(String a) {
        this.exportFile(new File(a));
    }

    /**
     * dieksagoume ena arxio
     *
     * @param a
     */
    public void exportFile(File file) {
        String filename = file.getName();
        String suffix = filename.substring(filename.lastIndexOf('.') + 1);
        suffix = suffix.toLowerCase();
        if (suffix.equals("mid")) {
            try {
                this.player.saveMidi(this.addNumbersInPattern(), file);
            } catch (IOException ex) {
                Logger.getLogger(Free.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Error: filename must end in .mid");
        }
    }

    /**
     * pernoume tous arithmous pou antistoixoun apo to kathe xaraktira kanontas
     * [pcharacter mod 128] kai ta topothetoume se ena arraylist
     *
     * @param rs
     * @return number
     */
    public ArrayList<Integer> takeNumbers() throws IOException {

        for (int i = 0; i < super.getInfo().length(); i++) {
            n = super.getInfo().charAt(i) % 128;
            this.number.add(n);

        }


        return this.number;
    }

    /**
     * topothetish twn arithmwn sto pattern
     *
     * @return pattern
     */
    public Pattern addNumbersInPattern() throws IOException {

        this.takeNumbers();

        for (int i = 0; i < this.number.size(); i++) {
            if (not == null) {
                not = "I[" + super.getInstrument() + "] ";
            } else {
                not += "[" + this.number.get(i) + "] ";
            }
        }
        this.setInformation(not);
        this.pattern.add(not);
        return this.pattern;
    }

    /**
     * paizoume tis notes pou epilektikan apo tous arithmous
     */
    public void playMusic() {
        if (pthread == null) {
            pthread = new playerThread();
        } else {
            pthread = null;
            pthread = new playerThread();
        }
        if (threadPlyr == null) {
            threadPlyr = new Thread(pthread);
        } else {
            threadPlyr = null;
            threadPlyr = new Thread(pthread);
        }
        try {
            pthread.setPattern(this.addNumbersInPattern());
        } catch (IOException ex) {
            Logger.getLogger(Algorithmic.class.getName()).log(Level.SEVERE, null, ex);
        }
        threadPlyr.start();
    }

    /**
     * stamatame thn mousiki
     */
    public void stopMusic() {
        //thread.start();
        threadPlyr.stop();
        this.pthread.stopTrack();

    }
}
