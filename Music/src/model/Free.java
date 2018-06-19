package model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.*;
import org.jfugue.Player;
import org.jfugue.Pattern;
import javax.sound.midi.MidiSystem;
import view.AtonalView;
import view.FreeView;

/**
 *
 * @author Klodjan Hidri
 * @author Evagelia Petavraki
 */
public class Free extends Composition {

    private playerThread pthread;
    private Thread threadPlyr;
    private Player player = new Player();
    private Pattern pattern = new Pattern();
    public String tmp = null;

    /**
     * Kataskeuastria methodo gia thn dimiourgeia mias free mousikis
     */
    public Free() {
    }

    /**
     * Kataskeuastria methodo gia thn dimiourgeia mias free mousikis me
     *
     * @param notes
     * @param instrument
     * @param composer
     * @param mode
     */
    public Free(String notes, String instrument, String composer, String mode, String nameOfComposition) {
        super(notes, instrument, composer, mode, nameOfComposition);
    }

    /**
     * topothetish twn notwn sto pattern
     *
     * @return pattern
     */
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
        System.out.print(suffix);
        if (suffix.equals("mid")) {
            try {
                this.player.saveMidi(this.addNotesInPattern(), file);
            } catch (IOException ex) {
                Logger.getLogger(Free.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Error: filename must end in .mid");
        }

    }

    public Pattern addNotesInPattern() {
        if (choose == true) {
            this.pattern.add(super.getInfo());

        } else if (choose == false) {

            tmp = "I[" + super.getInstrument() + "] " + super.getNotes();

            this.pattern.add(this.tmp);
        }
        super.setInformation(tmp);
        return this.pattern;
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
        pthread.setPattern(this.addNotesInPattern());
        threadPlyr.start();
    }

    /**
     * stamatame thn mousiki
     */
    @Override
    public void stopMusic() {
        threadPlyr.stop();
        this.pthread.stopTrack();
    }
}
