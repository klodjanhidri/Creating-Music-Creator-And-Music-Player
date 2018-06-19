/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.swing.*;
import model.Collection;
import model.CreateListMusic;

/**
 *
 * @author klodjan
 */
public class ListMusicView extends JFrame {

    private static String commands = null;
    private JPanel panel = new JPanel();
    private String tmp = "Select the music you want:";
    private JButton showItButton = new JButton("Select");
    private CreateListMusic a = new CreateListMusic();
    //public   ArrayList<JRadioButton>listmusic=new ArrayList();
    JRadioButton[] aa = new JRadioButton[100];
    final ButtonGroup group = new ButtonGroup();
    public static int Track;

    public ListMusicView() {
        // System.out.print(Collection.getaddMusic());
        JPanel box = new JPanel();

        this.setSize(200, 900);
        JLabel label = new JLabel(tmp);

        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.add(label);
        panel = new JPanel(new BorderLayout());
        for (int j = 0; j < Collection.getaddMusic().size(); j++) {
            String s = Collection.getaddMusic().get(j).getAbsolutePath();
            this.aa[j] = new JRadioButton(s.substring(s.lastIndexOf('/') + 1, s.length() - 4));
            this.aa[j].setActionCommand(Collection.getaddMusic().get(j).getAbsolutePath());

        }
        for (int i = 0; i < Collection.getaddMusic().size(); i++) {
            box.add(this.aa[i]);
            group.add(aa[i]);
        }

        panel.add(box, BorderLayout.PAGE_START);

        this.showItButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                commands = group.getSelection().getActionCommand();
                ListMusicView.setCommand(commands);
                System.out.print(commands);
                if (CollectionView.c == 2) {
                    try {

                        a.selectMusicfromList(new File(commands));
                        ListMusicView.Track = Collection.getaddMusic().indexOf(new File(commands));
                        CollectionView.c = 0;
                    } catch (IOException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidMidiDataException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (CollectionView.c == 1) {
                    try {
                        a.replayMusic(new File(commands));
                        ListMusicView.Track = Collection.getaddMusic().indexOf(new File(commands));

                        CollectionView.c = 0;
                    } catch (IOException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidMidiDataException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (CollectionView.c == 3) {
                    try {
                        a.removeMusic(new File(commands));
                        CollectionView.c = 0;

                    } catch (IOException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidMidiDataException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (CollectionView.c == 4) {
                    CollectionView.c = 0;
                    try {
                        a.upper(new File(commands));
                    } catch (IOException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidMidiDataException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (CollectionView.c == 5) {
                    CollectionView.c = 0;
                    try {
                        a.lower(new File(commands));
                    } catch (IOException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidMidiDataException ex) {
                        Logger.getLogger(ListMusicView.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });


        panel.add(showItButton, BorderLayout.PAGE_END);
        this.add(panel);

    }

    public static void setCommand(String a) {
        ListMusicView.commands = a;

    }

    public static String getCommand() {
        return commands;

    }
}
