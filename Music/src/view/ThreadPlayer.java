/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import model.Collection;
import model.CreateListMusic;

/**
 *
 * @author klodjan
 */
public class ThreadPlayer implements Runnable {

    private org.jfugue.Player player = new org.jfugue.Player();
    public static Boolean pause = false;

    public ThreadPlayer() {
    }

    public void stopTrack() {

        this.player.close();

    }

    public void pauseTrack() {
        ThreadPlayer.pause = true;
        this.player.pause();
    }

    @Override
    public void run() {
        if (CreateListMusic.select) {
            try {
                this.player.playMidiDirectly(Collection.getplayMusic().get(0).getAbsoluteFile());
                String s = Collection.getplayMusic().get(0).getCanonicalPath();
                CollectionView.jTextArea1.append("\t\t\t" + (1 + ListMusicView.Track) + "            " + s.substring(s.lastIndexOf('/') + 1, s.length() - 4) + "\n");

            } catch (IOException ex) {
                Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            Collection.getplayMusic().clear();
        }
        if (CreateListMusic.defa) {

            for (int i = 0; i < Collection.getplayMusic().size(); i++) {
                if (Collection.getaddMusic().size() > 0 && CreateListMusic.prev) {
                    //this.pauseTrack();
                    i--;

                } else if (Collection.getaddMusic().size() > 0 && CreateListMusic.next) {
                    // this.pauseTrack();
                    i++;
                }

                try {
                    this.player.playMidiDirectly(Collection.getplayMusic().get(i).getAbsoluteFile());
                    String s = Collection.getplayMusic().get(i).getCanonicalPath();
                    CollectionView.jTextArea1.append("\t\t\t" + (1 + i) + "            " + s.substring(s.lastIndexOf('/') + 1, s.length() - 4) + "\n");
                } catch (IOException ex) {
                    Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Collection.getplayMusic().clear();
        }
        if (CreateListMusic.random) {
            Random rand = new Random();
            while (true) {
                System.out.print(Collection.getaddMusic().size());
                int n = rand.nextInt(Collection.getaddMusic().size()) + 1;
                try {
                    this.player.playMidiDirectly(Collection.getaddMusic().get(n).getAbsoluteFile());
                    String s = Collection.getplayMusic().get(0).getCanonicalPath();
                    CollectionView.jTextArea1.append("\t\t\t" + (1 + n) + "            "
                            + s.substring(s.lastIndexOf('/') + 1, s.length() - 4) + "\n");

                } catch (IOException ex) {
                    Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            //Collection.getplayMusic().clear();
        }
        if (CreateListMusic.replay) {
            while (true) {
                try {
                    this.player.playMidiDirectly(Collection.getplayMusic().get(0).getAbsoluteFile());
                    String s = Collection.getplayMusic().get(0).getCanonicalPath();
                    CollectionView.jTextArea1.append("\t\t\t" + (1 + ListMusicView.Track) + "            " + s.substring(s.lastIndexOf('/') + 1, s.length() - 4) + "\n");

                } catch (IOException ex) {
                    Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        if (CreateListMusic.replayall) {
            for (int i = 0; i < Collection.getplayMusic().size(); i++) {
                try {
                    this.player.playMidiDirectly(Collection.getplayMusic().get(i).getAbsoluteFile());
                    String s = Collection.getplayMusic().get(i).getCanonicalPath();
                    CollectionView.jTextArea1.append("\t\t\t" + (1 + i) + "            "
                            + s.substring(s.lastIndexOf('/') + 1, s.length() - 4) + "\n");
                } catch (IOException ex) {
                    Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(ThreadPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (i == Collection.getplayMusic().size() - 1) {
                    i = 0;
                }

            }
            Collection.getplayMusic().clear();
        }
        Collection.getplayMusic().clear();
    }
}
