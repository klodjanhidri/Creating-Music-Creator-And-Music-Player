/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import model.Algorithmic;

/**
 *
 * @author klodjan
 */
public class AlgorithmicView extends JFrame implements ActionListener {

    public static Algorithmic aa = new Algorithmic();
    private static String instrumentStr, notes = null;
    private int argument;
    private static String composerStr, compostionStr, name, name1, fil;
    final static String modeStr = " Algorithmic";
    private Boolean finish;
    public static ImageIcon iconPlay = new ImageIcon("/home/klodjan/Desktop/play.png");
    public static ImageIcon iconstop = new ImageIcon("/home/klodjan/Desktop/a.png");
    public static JButton button17 = new JButton(iconPlay);
    private JPanel panel;
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
    private JLabel mode = new JLabel("Mode:Free");
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
    private int counter = 0;
    JFrame frame = new JFrame();

    public AlgorithmicView() {

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
        this.button17 = this.addPlayListener();
        this.add(panel);

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

        menu.add(this.menuItem1);
        menuItem11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aa.newFile();
            }
        });
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
                FreeView.aa.Quit();
            }
        });
        menu.add(this.menuItem15);
        return this.menu;

    }

    public JMenu createMenu1() {
        this.menuItem122.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aa.setInstrument("Piano");
            }
        });
        menu1.add(this.menuItem122);

        this.menuItem123.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aa.setInstrument("Guitar");
            }
        });
        menu1.add(this.menuItem123);

        this.menuItem124.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                aa.setInstrument("Flute");
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
                int k;
                k = counter % 2;

                if (k == 0) {
                    button17.setIcon(iconstop);
                    aa.setComposer(name1);
                    aa.setnameOfComposition(name);
                    aa.playMusic();

                    if (counter == 0) {

                        Composer.append("Composition:" + aa.getnameOfComposition() + "\n" + "Composer:" + aa.getComposer() + "\n" + "Mode:" + " Algorithmic"
                                + "\n" + "Instrument:" + aa.getInstrument() + "\n\n\n" + aa.getInformation());

                    } else if (counter != 0) {

                        Composer.append(aa.getInformation());


                    }
                } else if (k != 0) {
                    button17.setIcon(AlgorithmicView.iconPlay);
                    aa.stopMusic();
                }
                counter++;
            }
        });

        return this.button17;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
}
