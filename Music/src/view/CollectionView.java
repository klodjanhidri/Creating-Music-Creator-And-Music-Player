/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import model.Collection;
import model.CreateListMusic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author klodjan
 */
public class CollectionView extends javax.swing.JFrame implements ActionListener {

    private static ImageIcon iconPlay1 = new ImageIcon("/home/klodjan/Desktop/iconpro/prev.png");
    private static ImageIcon iconPlay = new ImageIcon("/home/klodjan/Desktop/iconpro/play1.png");
    private static ImageIcon iconstop = new ImageIcon("/home/klodjan/Desktop/iconpro/stopp.png");
    private static ImageIcon iconpause = new ImageIcon("/home/klodjan/Desktop/iconpro/pause.png");
    private static ImageIcon iconnext = new ImageIcon("/home/klodjan/Desktop/iconpro/next.png");
    private JFrame frame = new JFrame();
    private CreateListMusic a = new CreateListMusic();
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    public static int c = 0;

    // End of variables declaration
    /**
     * Creates new form
     */
    public CollectionView() {
        this.initComponent();
    }

    public void initComponent() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//-------------------------------------------------------------------------------

        jButton1.setIcon(iconstop);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a.stopMusic();
            }
        });
//-------------------------------------------------------------------------------

        jButton2.setIcon(iconPlay);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    a.playMusic();
                } catch (IOException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//-------------------------------------------------------------------------------

        jButton3.setIcon(iconpause);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    a.pauseMusic();
                } catch (IOException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        });
//-------------------------------------------------------------------------------

        jButton4.setIcon(iconPlay1);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a.previousMusic();
            }
        });
//-------------------------------------------------------------------------------

        jButton5.setIcon(iconnext);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a.nextMusic();
            }
        });
//-------------------------------------------------------------------------------

        jLabel1.setText("Default");
        jLabel7.setText("Playing");
        jLabel3.setText("Artist/Album");
        jLabel2.setText("Track No");
        jLabel5.setText("Title");
        jLabel4.setText("Duration");
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);
//-------------------------------------------------------------------------------

        jMenu1.setText("Collection");
        jMenuItem1.setText("NewCollection");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jMenu1.add(jMenuItem1);
//-------------------------------------------------------------------------------

        jMenuItem2.setText("AddFile");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileDialog chooser = new FileDialog(frame,
                        "Open File Song", FileDialog.LOAD);
                chooser.setVisible(true);

                String filepath = chooser.getDirectory() + File.separator + chooser.getFile();
                //chooser.getFile();
                try {
                    a.addFile(new File(filepath));
                } catch (IOException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                }



            }
        });
        jMenu1.add(jMenuItem2);
//-------------------------------------------------------------------------------

        jMenuItem3.setText("AddFolder");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser chooser = new JFileChooser();
                try {


                    a.addFolder();
                } catch (IOException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        jMenu1.add(jMenuItem3);
//-------------------------------------------------------------------------------
        jMenuItem4.setText("Open");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileDialog chooser = new FileDialog(frame,
                        "Open File Song", FileDialog.LOAD);
                chooser.setVisible(true);
                String filepath = chooser.getDirectory() + File.separator + chooser.getFile();
                BufferedReader inputStream = null;
                try {
                    inputStream = new BufferedReader(new FileReader(filepath));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    while (inputStream.ready()) {

                        Collection.getaddMusic().add(new File(inputStream.readLine()));

                    }
                } catch (IOException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
//------------------------------------------------------------------------------
        jMenu1.add(jMenuItem4);
        jMenuItem15.setText("Save");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileDialog chooser = new FileDialog(frame,
                        "Save File as", FileDialog.SAVE);
                chooser.setVisible(true);
                if (chooser.getFile() != null) {
                    String fil = chooser.getDirectory() + File.separator + chooser.getFile();
                    try {
                        a.save(new File(fil));
                    } catch (IOException ex) {
                        Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        jMenu1.add(jMenuItem15);

        jMenuItem5.setText("Quit");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Playback");


        jMenuItem6.setText("Default");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    a.playDefaultlyMysic();
                } catch (IOException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Random");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a.playRandomlyMysic();
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Repeat");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListMusicView aaa = new ListMusicView();
                aaa.setVisible(true);
                c = 1;
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("RepeatAll");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    a.replayAllListMusic(Collection.getaddMusic());
                } catch (IOException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(CollectionView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Menu");

        jMenuItem10.setText("Upper");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListMusicView aaa = new ListMusicView();
                aaa.setVisible(true);
                CollectionView.c=4;
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem11.setText("Lower");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 ListMusicView aaa = new ListMusicView();
                aaa.setVisible(true);
                CollectionView.c=5;
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem12.setText("Select");

        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c = 2;
                ListMusicView aaa = new ListMusicView();
                aaa.setVisible(true);



            }
        });
        jMenu4.add(jMenuItem12);
        jMenuItem13.setText("Remove");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 ListMusicView aaa = new ListMusicView();
                aaa.setVisible(true);
                c = 3;
                
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Help");

        jMenuItem14.setText("About");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
                .addComponent(jScrollPane2))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet.");
    }
}