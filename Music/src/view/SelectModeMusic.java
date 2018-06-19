/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author klodjan 
 */
public class SelectModeMusic extends JFrame implements ActionListener {
    public static String commands=null;
    JPanel panel = new JPanel();
    String tmp = "Select the mode of music you want:";
    final String free = "Free";
    final String atonal = "Atonal";
    final String algorithm = "Algorithm";
    final int numButtons = 3;
    JRadioButton[] radioButtons = new JRadioButton[numButtons];
    final ButtonGroup group = new ButtonGroup();
    JButton showItButton = new JButton("Ok");

    public SelectModeMusic() {

        JPanel box = new JPanel();

        this.setSize(200, 300);
        JLabel label = new JLabel(tmp);

        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.add(label);
        panel = new JPanel(new BorderLayout());

        radioButtons[0] = new JRadioButton(free);
        radioButtons[0].setActionCommand(free);
        radioButtons[1] = new JRadioButton(atonal);
        this.radioButtons[1].setActionCommand("Atonal");

        radioButtons[2] = new JRadioButton(algorithm);
        radioButtons[2].setActionCommand("Algorithm");

        for (int i = 0; i < 3; i++) {
            box.add(this.radioButtons[i]);
            group.add(radioButtons[i]);
        }
        radioButtons[0].setSelected(true);
       panel.add(box, BorderLayout.PAGE_START);
        this.showItButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                commands = group.getSelection().getActionCommand();
                                                    
                if (commands.equalsIgnoreCase(free)) {
                    FreeView aa = new FreeView();
                    aa.setVisible(true);
                    CollectionView x=new CollectionView ();
                    x.setVisible(true);
                    
                } else if (commands.equalsIgnoreCase(atonal)) {
                    AtonalView a = new AtonalView();
                    a.setVisible(true);
                    CollectionView xx=new CollectionView ();
                    
                    xx.setVisible(true);
                   
                } else if (commands.equalsIgnoreCase(algorithm)) {
                    AlgorithmicView aaa = new  AlgorithmicView();
                    aaa.setVisible(true);
                    CollectionView xx1=new CollectionView ();
                    xx1.setVisible(true);
                   
                }
            }
        });
        panel.add(showItButton, BorderLayout.PAGE_END);
        this.add(panel);

    }

    public static void main(String[] args) {
        SelectModeMusic a = new SelectModeMusic();
        a.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet.");
    }
}
