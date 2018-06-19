/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.View;
import model.*;
import org.jfugue.Player;

/**
 *
 * @author klodjan
 */
public class AtonalView extends JFrame implements ActionListener {

    public static ArrayList<String> list = new ArrayList();
    public static AtonalComposition aa = new AtonalComposition();
    public static AtonalRow aaa = new AtonalRow();
    private Player players = new Player();
    private static String instrumentStr, notes = null,actions;
    private int argument;
    private static String composerStr, compostionStr, name, name1, fil;
    final static String modeStr = "Atonal";
    private Boolean finish, count = false;
    Color c;
    private JButton button = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JButton button4 = new JButton();
    private JButton button5 = new JButton();
    private JButton button6 = new JButton();
    private JButton button7 = new JButton();
    private JButton button8 = new JButton();
    private JButton button9 = new JButton();
    private JButton button10 = new JButton();
    private JButton button11 = new JButton();
    private JButton button12 = new JButton();
    private JButton button13 = new JButton("Do Nothing");
    private JButton button14 = new JButton("Retrogate");
    private JButton button15 = new JButton("Transpose");
    private JButton button16 = new JButton("Reflect");
    public static ImageIcon iconPlay = new ImageIcon("/home/klodjan/Desktop/play.png");
    private static ImageIcon iconstop = new ImageIcon("/home/klodjan/Desktop/a.png");
    public static JButton button17 = new JButton(iconPlay);
    private JButton button18 = new JButton(iconstop);
    private JPanel panel;
    private JPanel panels;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Composition");
    private JMenu menu1 = new JMenu("Instrument");
    private JMenu menu2 = new JMenu("Help");
    private JMenuItem menuItem1 = new JMenuItem("Open");
    private JMenuItem menuItem11 = new JMenuItem("New");
    private JMenuItem menuItem12 = new JMenuItem("Save");
    private JMenuItem menuItem13 = new JMenuItem("Save As");
    private JMenuItem menuItem14 = new JMenuItem("Export");
    private JMenuItem menuItem15 = new JMenuItem("Quit");
    private JMenuItem menuItem122 = new JMenuItem("Piano");
    private JMenuItem menuItem123 = new JMenuItem("Guitar");
    private JMenuItem menuItem124 = new JMenuItem("Flute");
    private JMenuItem menuItem125 = new JMenuItem("Other...");
    private JMenuItem menuItem9 = new JMenuItem("About");
    private JLabel mode = new JLabel("Mode:Atonal");
    private JLabel composition1;
    private JLabel composition = new JLabel("Composition:");
    private JLabel composer1 = new JLabel("Mode:");
    private JLabel composer = new JLabel("Composer:");
    private JLabel instrument = new JLabel("Instrument:");
    private JTextArea Composition = new JTextArea();
    private JTextArea Composer = new JTextArea();
    private JTextArea Mode = new JTextArea();
    private JTextArea Instrument = new JTextArea();
    private JTextArea integer = new JTextArea();
    private JTextArea calc = new JTextArea();
    private JTextArea calc1 = new JTextArea();
    private JScrollPane scroll = new JScrollPane(Composer);
    JFrame frame = new JFrame();
    private int counter = 0, countr = 0;

    public AtonalView() {
        panel = this.createPanel();
        this.menuBar = this.createMenuBar();
        this.menu = this.createMenu();
        this.menu1 = this.createMenu1();
        this.menu2 = this.createMenu2();

        name1 = JOptionPane.showInputDialog("Give the name of Composer");
        name = JOptionPane.showInputDialog("Give the name of Composition");
        this.calc.setEditable(false);
        this.composition1 = new JLabel("Composition:" + name + " by " + name1);
        this.composition1.setBounds(590, 0, 600, 20);
        this.panel.add(this.composition1);
        this.calc1.setBounds(540, 0, 640, 20);
        this.mode.setBounds(400, 0, 340, 20);
        panel.add(mode);

        Composer.setEditable(false);
        scroll.setBounds(0, 480, 880, 200);
        scroll.setVisible(true);
       scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      
        this.panel.add(this.scroll);
        this.button = this.addC_NoteListener();
        this.button2 = this.addCdiesiNoteListener();
        this.button3 = this.addD_NoteListener();
        this.button4 = this.addDdiesiNoteListener();
        this.button5 = this.addE_NoteListener();
        this.button6 = this.addF_NoteListener();
        this.button7 = this.addFdiesi_NoteListener();
        this.button8 = this.addG_NoteListener();
        this.button9 = this.addGdiesi_NoteListener();
        this.button10 = this.addA_NoteListener();
        this.button11 = this.addAdiesi_NoteListener();
        this.button12 = this.addB_NoteListener();
        this.button17 = this.addPlayListener();

        this.add(panel);
    }

    private Boolean count() {
        if (counter == 12) {
            this.count = true;
        } else if (counter < 12) {
            this.count = false;
        }
        return this.count;
    }

    public JPanel createPanel() {
        this.panel = new JPanel();
        this.setSize(900, 800);
        panel.setLayout(null);
        panel.setBounds(900, 800, 200, 100);

        return this.panel;
    }

    public JMenuBar createMenuBar() {
        menuBar.add(menu);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.setBounds(0, 0, 230, 20);
        panel.add(menuBar);
        return this.menuBar;
    }

    public JMenu createMenu() {
        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FileDialog chooser = new FileDialog(frame,
               "Open File Song", FileDialog.LOAD);
          chooser.setVisible(true);
           String filepath = chooser.getDirectory() + File.separator + chooser.getFile();
                try {
                    aa.openFile(filepath);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FreeView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FreeView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuItem11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                aa.newFile();
            }
        });

        menu.add(this.menuItem1);

        menu.add(this.menuItem11);

        this.menuItem12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    aa.saveFile(fil);
                } catch (IOException ex) {
                    Logger.getLogger(FreeView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        menu.add(this.menuItem12);

        this.menuItem13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FileDialog chooser = new FileDialog(frame,
                        "Save File as", FileDialog.SAVE);
                chooser.setVisible(true);
                if (chooser.getFile() != null) {
                    fil = chooser.getDirectory() + File.separator + chooser.getFile();
                    aa.saveAsFile(fil);
                }

            }
        });
        menu.add(this.menuItem13);

        
        this.menuItem14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FileDialog chooser = new FileDialog(frame,
                        "Export File as .midi", FileDialog.SAVE);
                chooser.setVisible(true);
                if (chooser.getFile() != null) {
                   String midi = chooser.getDirectory() + File.separator + chooser.getFile();
                    aa.exportFile(midi);
                }

            }
        });
        menu.add(this.menuItem14);
        
        this.menuItem15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AtonalView.aa.Quit();
            }
        });
        menu.add(this.menuItem15);
        return this.menu;

    }

    public JMenu createMenu1() {
        this.menuItem122.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AtonalView.aa.setInstrument("Piano");
            }
        });
        menu1.add(this.menuItem122);

        this.menuItem123.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AtonalView.aa.setInstrument("Guitar");

            }
        });
        menu1.add(this.menuItem123);

        this.menuItem124.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                AtonalView.aa.setInstrument("Flute");
            }
        });
        menu1.add(this.menuItem124);
        this.menuItem125.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Organ a = new Organ();
                a.setVisible(true);
            }
        });
        menu1.add(this.menuItem125);
        return this.menu1;
    }

    public JMenu createMenu2() {
        menu2.add(this.menuItem9);
        return this.menu2;
    }

    public JButton addC_NoteListener() {


        button.setBounds(85, 100, 60, 300);
        button.setBackground(Color.RED);
        JLabel cc = new JLabel("C");
        this.button.setLayout(null);
        cc.setBounds(27, 135, 30, 30);
        this.button.add(cc);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                counter++;

                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "C");
                AtonalView.aa.setNotes("C ");
                AtonalView.aaa.setInit12Notes("C ");
                button.setBackground(Color.gray);
                button.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }

                JLabel c = new JLabel();

                c.setBounds(21, 195, 30, 30);
                c.setText("" + counter);
                button.add(c);

            }
        });

        this.panel.add(button);

        return this.button;
    }

    public JButton addCdiesiNoteListener() {
        button2.setBounds(150, 105, 58, 290);
        button2.setBackground(new Color(255, 69, 0));
        JLabel cc = new JLabel("C#");
        this.button2.setLayout(null);
        cc.setBounds(19, 130, 30, 30);
        this.button2.add(cc);



        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                counter++;
                button2.setBackground(Color.gray);
                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "C#");
                AtonalView.aa.setNotes("C# ");
                AtonalView.aaa.setInit12Notes("C# ");
                JLabel c = new JLabel();
                // button2.setLayout(null);
                c.setBounds(21, 192, 30, 30);
                c.setText("" + counter);
                button2.add(c);
                button2.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
            }
        });



        panel.add(button2);
        return this.button2;
    }

    public JButton addD_NoteListener() {

        this.button3.setBounds(212, 110, 56, 280);
        this.button3.setBackground(new Color(255, 127, 0));
        JLabel cc = new JLabel("D");
        this.button3.setLayout(null);
        cc.setBounds(24, 125, 30, 30);
        this.button3.add(cc);
        panel.add(button3);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                counter++;
                button3.setBackground(Color.gray);
                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "D");
                AtonalView.aa.setNotes("D ");
                AtonalView.aaa.setInit12Notes("D ");
                JLabel c = new JLabel();
                c.setBounds(21, 189, 30, 30);
                c.setText("" + counter);
                button3.add(c);
                button3.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
            }
        });

        return this.button3;
    }

    public JButton addDdiesiNoteListener() {
        this.button4.setBounds(271, 115, 54, 270);
        this.button4.setBackground(new Color(255, 165, 0));
        JLabel cc = new JLabel("D#");
        this.button4.setLayout(null);
        cc.setBounds(17, 120, 30, 30);
        this.button4.add(cc);
        panel.add(button4);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                counter++;

                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "D#");
                AtonalView.aa.setNotes("D# ");
                AtonalView.aaa.setInit12Notes("D# ");
                button4.setBackground(Color.gray);
                JLabel c = new JLabel();
                //button4.setLayout(null);
                c.setBounds(21, 186, 30, 30);
                c.setText("" + counter);
                button4.add(c);
                button4.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
            }
        });


        return this.button4;
    }

    /**
     * Ftiaxnoume ena koumpi me onoma E prin efarmostei to action sto koumpi
     * elegxete to mode kai istera kanoume to action kai topothetoume to gramma
     * E sto string notes
     */
    public JButton addE_NoteListener() {
        this.button5.setBounds(328, 120, 52, 260);
        this.button5.setBackground(Color.YELLOW);
        JLabel cc = new JLabel("E");
        this.button5.setLayout(null);
        cc.setBounds(21, 115, 30, 30);
        this.button5.add(cc);
        panel.add(button5);
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                counter++;
                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "E");
                AtonalView.aa.setNotes("E ");
                AtonalView.aaa.setInit12Notes("E ");
                button5.setBackground(Color.gray);
                JLabel c = new JLabel();
                // button5.setLayout(null);
                c.setBounds(21, 183, 30, 30);
                c.setText("" + counter);
                button5.add(c);
                button5.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }


            }
        });
        return this.button5;
    }

    public JButton addF_NoteListener() {
        this.button6.setBounds(383, 125, 50, 250);
        this.button6.setBackground(new Color(9, 249, 17));
        JLabel cc = new JLabel("F");
        this.button6.setLayout(null);
        cc.setBounds(20, 110, 30, 30);

        this.button6.add(cc);
        panel.add(button6);
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                counter++;
                button6.setBackground(Color.gray);

                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "F");
                AtonalView.aa.setNotes("E ");
                AtonalView.aaa.setInit12Notes("F ");
                JLabel c = new JLabel();
                // button6.setLayout(null);
                c.setBounds(21, 180, 30, 30);
                c.setText("" + counter);
                button6.add(c);
                button6.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
            }
        });
        return this.button6;
    }

    public JButton addFdiesi_NoteListener() {
        this.button7.setBounds(436, 130, 48, 240);

        this.button7.setBackground(new Color(0, 255, 127));
        JLabel cc = new JLabel("F#");
        this.button7.setLayout(null);
        cc.setBounds(15, 105, 30, 30);
        this.button7.add(cc);

        panel.add(button7);
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                counter++;
                button7.setBackground(Color.gray);
                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "F#");
                AtonalView.aa.setNotes("F# ");
                AtonalView.aaa.setInit12Notes("F# ");
                JLabel c = new JLabel();
                //button7.setLayout(null);
                c.setBounds(21, 177, 30, 30);
                c.setText("" + counter);
                button7.add(c);
                button7.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
            }
        });
        return this.button7;
    }

    public JButton addG_NoteListener() {
        this.button8.setBounds(487, 135, 46, 230);
        this.button8.setBackground(new Color(0, 255, 255));
        JLabel cc = new JLabel("G");
        this.button8.setLayout(null);
        cc.setBounds(18, 101, 30, 30);

        this.button8.add(cc);
        panel.add(button8);
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                counter++;
                button8.setBackground(Color.gray);
                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "G");
                AtonalView.aa.setNotes("G ");
                AtonalView.aaa.setInit12Notes("G ");
                JLabel c = new JLabel();
                //button8.setLayout(null);
                c.setBounds(21, 174, 30, 30);
                c.setText("" + counter);
                button8.add(c);
                button8.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
            }
        });

        return this.button8;
    }

    public JButton addGdiesi_NoteListener() {
        this.button9.setBounds(536, 140, 44, 220);
        this.button9.setBackground(new Color(0, 127, 255));
        JLabel cc = new JLabel("G#");
        this.button9.setLayout(null);
        cc.setBounds(12, 96, 30, 30);
        this.button9.add(cc);

        panel.add(button9);

        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                counter++;
                button9.setBackground(Color.gray);
                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "G#");
                AtonalView.aa.setNotes("G# ");
                AtonalView.aaa.setInit12Notes("G# ");
                JLabel c = new JLabel();
                //button9.setLayout(null);
                c.setBounds(21, 171, 30, 30);
                c.setText("" + counter);
                button9.add(c);
                button9.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
            }
        });
        return this.button9;
    }

    public JButton addA_NoteListener() {

        this.button10 = new JButton();
        this.button10.setBounds(583, 145, 42, 210);
        this.button10.setBackground(new Color(36, 24, 130));
        JLabel cc = new JLabel();
        this.button10.setLayout(null);
        cc.setBounds(17, 99, 15, 15);
        cc.setText("A");

        this.button10.add(cc);

        panel.add(button10);

        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                counter++;

                button10.setBackground(Color.gray);
                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "A");
                AtonalView.aa.setNotes("A ");
                AtonalView.aaa.setInit12Notes("A ");
                JLabel c = new JLabel();
                // button10.setLayout(null);
                c.setBounds(21, 168, 30, 30);
                c.setText("" + counter);
                button10.add(c);
                button10.setEnabled(false);
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
            }
        });
        return this.button10;
    }

    public JButton addAdiesi_NoteListener() {


        this.button11.setBounds(628, 150, 40, 200);
        this.button11.setBackground(new Color(139, 0, 139));

        JLabel cc = new JLabel("A#");
        this.button11.setLayout(null);
        cc.setBounds(10, 86, 30, 30);
        //cc.setText();
        cc.setEnabled(true);
        cc.setVisible(true);
        this.button11.add(cc);
        panel.add(button11);

        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                counter++;
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "A#");
                AtonalView.aa.setNotes("A# ");
                AtonalView.aaa.setInit12Notes("A# ");
                button11.setBackground(Color.gray);
                JLabel c = new JLabel();
                // button11.setLayout(null);
                c.setBounds(20, 165, 30, 30);
                c.setText("" + counter);
                button11.add(c);
                button11.setEnabled(false);
            }
        });
        return this.button11;
    }

    public JButton addB_NoteListener() {

        this.button12.setBounds(671, 155, 38, 190);
        this.button12.setBackground(new Color(255, 0, 255));
        this.button12.setLayout(null);
        JLabel cc = new JLabel();
        cc.setBounds(15, 91, 15, 15);
        cc.setText("B");
        this.button12.add(cc);
        panel.add(button12);
        button12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                counter++;
                count();
                if (count == true) {
                    button13 = addDoNothingListener();
                    button14 = addRetrogateListener();
                    button15 = addTransposeListener();
                    button16 = addReflectListener();
                }
                String j;
                if (AtonalView.aa.getInstrument() == null) {
                    j = "Piano";
                } else {
                    j = AtonalView.aa.getInstrument();
                }
                players.play("I[" + j + "] " + "B");
                AtonalView.aa.setNotes("B ");
                AtonalView.aaa.setInit12Notes("B ");
                button12.setBackground(Color.gray);
                JLabel c = new JLabel();
                // button12.setLayout(null);
                c.setBounds(20, 163, 30, 30);
                c.setText("" + counter);
                button12.add(c);
                button12.setEnabled(false);
            }
        });
        return this.button12;
    }

    public JButton addDoNothingListener() {

        this.button13.setBounds(50, 410, 190, 50);
        this.button13.setBackground(new Color(255, 192, 203));
        // this.button13.setVisible(false);
        panel.add(button13);
        button13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(AtonalView.actions==null)
     AtonalView.actions="DoNothing";
 else AtonalView.actions +="DoNothing";
                AtonalView.aaa.setActions("DoNothing");
                try {
                    AtonalView.aaa.doNothing();
                } catch (SymmetryActionOnNonValidAtonalRow ex) {
                    Logger.getLogger(AtonalView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return this.button13;
    }

    public JButton addRetrogateListener() {

        this.button14.setBounds(250, 410, 190, 50);
        this.button14.setBackground(new Color(50, 205, 50));
        this.button14.setVisible(true);
        panel.add(button14);
        button14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
if(AtonalView.actions==null)
     AtonalView.actions="Retrogate";
 else AtonalView.actions +="Retrogate";
                AtonalView.aaa.setActions("Retrogate");
                try {
                    AtonalView.aaa.retrograde();
                } catch (SymmetryActionOnNonValidAtonalRow ex) {
                    Logger.getLogger(AtonalView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        return this.button14;
    }

    public JButton addTransposeListener() {

        this.button15.setBounds(450, 410, 190, 50);
        this.button15.setBackground(new Color(175, 238, 238));
        this.button15.setVisible(true);
        panel.add(button15);
        button15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              
                int n =Integer.parseInt( JOptionPane.showInputDialog("Enter a number for Transpose from 1 to 11:"));
        if(AtonalView.actions==null)
     AtonalView.actions="Transpose"+"("+n+")";
 else AtonalView.actions +="Transpose"+"("+n+")";

                AtonalView.aaa.setActions("Transpose");
                try {
                    AtonalView.aaa.transpose(n);
                } catch (SymmetryActionOnNonValidAtonalRow ex) {
                    Logger.getLogger(AtonalView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return this.button15;
    }

    public JButton addReflectListener() {

        this.button16.setBounds(650, 410, 190, 50);
        this.button16.setBackground(new Color(238, 169, 184));
        panel.add(button16);
        button16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                AtonalView.aaa.setActions("Reflect");
 int n =Integer.parseInt( JOptionPane.showInputDialog("Enter a number for Transpose from 1 to 11:"));
if(AtonalView.actions==null)
     AtonalView.actions="Reflect"+"("+n+")";
 else AtonalView.actions +="Reflect"+"("+n+")";
                try {
                    AtonalView.aaa.reflect(n);
                } catch (SymmetryActionOnNonValidAtonalRow ex) {
                    Logger.getLogger(AtonalView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return this.button12;
    }

    public JButton addPlayListener() {
        this.button17.setBounds(770, 60, 64, 64);
        button17.setOpaque(false);
        button17.setContentAreaFilled(false);
        button17.setBorderPainted(false);
        button17.setFocusPainted(false);
        this.button17.addActionListener(this);
        panel.add(button17);
        this.button17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button17.setIcon(iconstop);
                try {
                    AtonalView.aa.ComposeAtonalMusic();
                } catch (SymmetryActionOnNonValidAtonalRow ex) {
                    Logger.getLogger(AtonalView.class.getName()).log(Level.SEVERE, null, ex);
                }
                int k;
                k = countr % 2;
                if (k == 0) {
                    
                    AtonalView.aa.setComposer(name1);
                    AtonalView.aa.setnameOfComposition(name);
                    AtonalView.aa.playMusic();
                   
                    if (countr == 0) {
                        if (AtonalView.aa.choose == true) {
                            Composer.append("Composition:" + aa.getnameOfComposition() + "\n" + "Composer:" + AtonalView.aa.getComposer() + "\n" + "Mode:" + "Atonal"
                                    + "\n" + "Instrument:" + aa.getInstrument() + "\n\n\n" + AtonalView.aa.getInfo());
                            AtonalView.aa.choose = false;
                        } else {
                            Composer.append("Composition:" + AtonalView.aa.getnameOfComposition() + "\n" + "Composer:" + AtonalView.aa.getComposer() + "\n" + "Mode:" + "Atonal"
                                    + "\n" + "Instrument:" + AtonalView.aa.getInstrument() + "\n\n\n" + AtonalView.aa.getInformation()+"\n"+AtonalView.actions+"\n");
                        }
                    } else if (countr != 0) {
                        if (AtonalView.aa.choose == true) {
                            Composer.append(AtonalView.aa.getInfo());
                            AtonalView.aa.choose = false;
                        } else {
                            Composer.append(AtonalView.aa.getInformation()+"\n"+AtonalView.actions+"\n");
                        }
                    }
                } else if (k != 0) {
                    button17.setIcon(iconPlay);
                    aa.stopMusic();
                }
                countr++;
            }
        });
        return this.button17;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }
}
