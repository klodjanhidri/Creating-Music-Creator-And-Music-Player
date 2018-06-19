package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfugue.Player;
import org.jfugue.Pattern;
import view.AtonalView;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Klodjan Hidri
 * @author Evagelia Petavraki
 */
public class AtonalComposition extends Composition implements Symmetry {

    private Pattern patern = new Pattern();
    int c = 0;
    private Player player = new Player();
    private static AtonalRow atonal = new AtonalRow();
    private ArrayList<String> qq = new ArrayList();
    private boolean finishCompose = false, start = true;
    private String notes_2 = null;
    private playerThread pthread;
    private Thread threadPlyr;
    /*
     * kataskeuastria methodo gia thn 
     * dimiourgia tou antikeimenou Algorithm
     */

    public AtonalComposition() {
    }

    /**
     * kataskeuastria methodo gia thn dimiourgia tou antikeimenou Algorithm
     *
     * @param atonalRow
     * @param instrument
     * @param composer
     * @param mode
     * @param nameOfComposition
     */
    public AtonalComposition(ArrayList<AtonalRow> atonalRow, String instrument,
            String composer, String mode, String nameOfComposition) {
    }

    

    public void ComposeAtonalMusic() throws SymmetryActionOnNonValidAtonalRow {
        for (int i = 0; i < AtonalRow.actions.size(); i++) {

            if (AtonalRow.actions.get(i) == "DoNothing") {
                this.doNothing();
            }
            if (this.atonal.getActions().get(i).equals("Retrogate")) {
                this.retrograde();
            }
            if (this.atonal.getActions().get(i).equals("Transpose")) {
                this.transpose(1);
            }
            if (this.atonal.getActions().get(i).equals("Reflect")) {
                this.reflect(0);
            }
        }
        this.finishCompose = true;

    }

    private void setDoubleNotes(ArrayList<String> a) {

        for (int i = 0; i < a.size(); i++) {
           
            super.setNotes(a.get(i));
        }

        c++;
        System.out.println("klo"+super.getNotes());
    }

    private String getDoubleNotes() {
        return this.notes_2;

    }

    /**
     * diplasiasmos twn notwn atonalrow na kanoume kamia energia panw tous
     *
     * @throws SymmetryActionOnNonValidAtonalRow
     */
    public void doNothing() throws SymmetryActionOnNonValidAtonalRow {

        this.setDoubleNotes(this.atonal.getRows());
    }

    /**
     * diplasiasmos twn notwn atonalrow kanontas shift kata x
     *
     * @param x
     * @throws SymmetryActionOnNonValidAtonalRow
     */
    public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow {
        ArrayList<String> q1 = new ArrayList(), q2 = new ArrayList();

        for (int ii = this.atonal.getRows().size() - 1; ii >= 0; ii--) {
            q1.add(this.atonal.getRows().get(ii));
        }
        for (int i = x - 1; i >= 0; i--) {
            q2.add(q1.get(i));
        }
        for (int j = q1.size() - 1; j >= x; j--) {
            q2.add(q1.get(j));
        }
        this.setDoubleNotes(q2);
    }

    /**
     * diplasiasmos twn notwn atonalrow grafontas tous anapoda
     *
     * @throws SymmetryActionOnNonValidAtonalRow
     */
    public void retrograde() throws SymmetryActionOnNonValidAtonalRow {

        ArrayList<String> q1 = new ArrayList();
        for (int i = this.atonal.getRows().size() - 1; i >= 0; i--) {
            q1.add(this.atonal.getRows().get(i));
        }
        this.setDoubleNotes(q1);


    }

    /**
     * diplasiasmos twn notwn atonalrow kanontas reflect kata x
     *
     * @param x
     * @throws SymmetryActionOnNonValidAtonalRow
     */
    public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow {
        ArrayList<String> b5 = new ArrayList(), b1 = new ArrayList(), b2 = new ArrayList(), b3 = new ArrayList(), b4 = new ArrayList();

        for (int ii = 0; ii < this.atonal.getRows().size(); ii++) {
            b1.add(this.atonal.getRows().get(ii));
        }

        int mesi = b1.size() / 2;
        int tmp = (x + mesi) % b1.size();
        if (x < mesi) {

            b2.add(this.atonal.getRows().get(x));
            b2.add(this.atonal.getRows().get(tmp));


            for (int i = x + 1; i < tmp + x; i++) {
                b3.add(b1.get(i));
            }
            for (int i = tmp + x + 1; i < b1.size(); i++) {
                b4.add(b1.get(i));
            }
            for (int iii = 0; iii < x; iii++) {
                b4.add(b1.get(iii));
            }

            b5.add(b2.get(0));
            for (int bb = b4.size() - 1; bb >= 0; bb--) {
                b5.add(b4.get(bb));
            }
            b5.add(b2.get(1));
            for (int bbb = b3.size() - 1; bbb >= 0; bbb--) {
                b5.add(b3.get(bbb));
            }

            this.setDoubleNotes(b5);
            System.out.println(b2 + "b2\n " + b3 + "b3\n" + b4 + "b4");
            System.out.println(b5 + "b5");
        }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++        
        if (x > mesi) {
            b2.add(this.atonal.getRows().get(x));
            b2.add(this.atonal.getRows().get(tmp));

            for (int i = tmp + 1; i < x - 1; i++) {
                b3.add(b1.get(i));
            }
            for (int i = x + 1; i < b1.size(); i++) {
                b4.add(b1.get(i));
            }
            for (int iii = 0; iii < tmp; iii++) {
                b4.add(b1.get(iii));
            }
            b5.add(b2.get(0));
            for (int bb = b4.size() - 1; bb >= 0; bb--) {
                b5.add(b4.get(bb));
            }
            b5.add(b2.get(1));
            for (int bbb = b3.size() - 1; bbb >= 0; bbb--) {
                b5.add(b3.get(bbb));
            }

            this.setDoubleNotes(b5);
            System.out.println(b2 + "b2\n " + b3 + "b3\n" + b4 + "b4");
            System.out.println(b5 + "b5");

        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (x == mesi) {
            b2.add(this.atonal.getRows().get(x));
            b2.add(this.atonal.getRows().get(tmp));

            for (int i = x + 1; i < tmp - 1; i++) {
                b3.add(b1.get(i));
            }
            for (int i = tmp + 1; i < b1.size(); i++) {
                b4.add(b1.get(i));
            }

            b5.add(b2.get(0));
            for (int bb = b4.size() - 1; bb >= 0; bb--) {
                b5.add(b4.get(bb));
            }
            b5.add(b2.get(1));
            for (int bbb = b3.size() - 1; bbb >= 0; bbb--) {
                b5.add(b3.get(bbb));
            }

            this.setDoubleNotes(b5);
            System.out.println(b2 + "b2\n " + b3 + "b3\n" + b4 + "b4");
            System.out.println(b5 + "b5RE");

        }
    }

    /**
     * topothetish twn notwn sto pattern
     *
     * @return pattern
     */
    public Pattern addNotesInPattern() {
        if (this.finishCompose) {
            if (choose == true) {
                this.patern.add(super.getInfo());

            } else if (choose == false) {

                this.notes_2 = "I[" + super.getInstrument() + "] " + super.getNotes();
                super.setInformation(this.notes_2);
                this.patern.add(this.notes_2);
            }

        }
        return this.patern;
    }
    public void exportFile(String a){
        this.exportFile(new File(a));
    }
    
    /**
     * dieksagoume ena arxio 
     * @param a 
     */
    public void exportFile(File file){
        try {
            this.player.saveMidi(this.addNotesInPattern(), file);
        } catch (IOException ex) {
            Logger.getLogger(Free.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * paizoume tis notes pou epilektikan apo to ksilofono
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
       
           this.pthread.setPattern(this.addNotesInPattern());
       
        threadPlyr.start();
       
    }

    /**
     * stamatame thn mousiki
     */
    public void stopMusic() {
        this.threadPlyr.stop();
        this.pthread.stopTrack();
    }
}
