/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.*;
import view.FreeView;


/**
 *
 * @author klodjan
 */
public class Organ extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    String tmp = "Select the instrument you want:";
    final String violin = "Violin";
    final String viola = "Viola";
    final String cello = "Cello";
    final String xylofon="Xylophone";
    final String trumpet = "Trumpet";
    final String harmonica = "Harmonica";
    final String accoridan = "Accoridan";
    final String clarinet = "Clarinet";
    final String  SOUNDTRACK="SoundTrack";
    final String helicopter="Helicopter";
    final String GUNSHOT="Gunshot";
 
    final int numButtons = 11;
    JRadioButton[] radioButtons = new JRadioButton[numButtons];
    final ButtonGroup group = new ButtonGroup();
    JButton showItButton = new JButton("Ok");
     
    public Organ(){
         JPanel box = new JPanel();

         this.setSize(300,600);
        JLabel label = new JLabel(tmp);

        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.add(label);
        panel = new JPanel(new BorderLayout());
        
        radioButtons[0] = new JRadioButton(violin);
        radioButtons[0].setActionCommand(violin);
        radioButtons[1] = new JRadioButton(viola);
        this.radioButtons[1].setActionCommand(viola);

        radioButtons[2] = new JRadioButton(cello);
        radioButtons[2].setActionCommand(cello);
        
        radioButtons[3] = new JRadioButton(xylofon);
        radioButtons[3].setActionCommand(xylofon);
        
        radioButtons[4] = new JRadioButton(trumpet);
        radioButtons[4].setActionCommand(trumpet);
        
        radioButtons[5] = new JRadioButton(harmonica);
        radioButtons[5].setActionCommand(harmonica);
        
        radioButtons[6] = new JRadioButton(accoridan);
        radioButtons[6].setActionCommand(accoridan);
        
        radioButtons[7] = new JRadioButton(clarinet);
        radioButtons[7].setActionCommand(clarinet);
        
        radioButtons[8] = new JRadioButton(SOUNDTRACK);
        radioButtons[8].setActionCommand(SOUNDTRACK);
        
        radioButtons[9] = new JRadioButton(helicopter);
        radioButtons[9].setActionCommand(helicopter);
        
        radioButtons[10] = new JRadioButton(GUNSHOT);
        radioButtons[10].setActionCommand(GUNSHOT);
        
        for (int i = 0; i < 11; i++) {
            box.add(this.radioButtons[i]);
            group.add(radioButtons[i]);
        }
        radioButtons[0].setSelected(true);

         panel.add(box, BorderLayout.PAGE_START);
        this.showItButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = group.getSelection().getActionCommand();
                System.out.println(command);
                if (command.equalsIgnoreCase(violin)) {
                 
                   if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                 FreeView.aa.setInstrument(violin);
                 if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))  
                     AtonalView.aa.setInstrument(violin);
                 if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(violin);
                    }
                 //aa.setInstrument(violin);
                }
                if (command.equalsIgnoreCase(viola)) {
                  if(SelectModeMusic.commands.equalsIgnoreCase("Free")) 
                   FreeView.aa.setInstrument(viola);
                if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
                AtonalView.aa.setInstrument(viola);
                  if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(viola);
                    }   
                }if (command.equalsIgnoreCase(cello)) {
                   if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                    FreeView.aa.setInstrument(cello);
                if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
                   AtonalView.aa.setInstrument(cello);
                  if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(cello);
                    }   
                }if (command.equalsIgnoreCase(xylofon)) {
                    if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                       FreeView.aa.setInstrument(xylofon);
                  if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
                    AtonalView.aa.setInstrument(xylofon);
                 if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(xylofon);
                    }
                }if (command.equalsIgnoreCase(trumpet)) {
                    if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                    FreeView.aa.setInstrument(trumpet);
                 if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
                    AtonalView.aa.setInstrument(trumpet);
                  if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(trumpet);
                    }
                }if (command.equalsIgnoreCase(harmonica)) {
                    if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                    FreeView.aa.setInstrument(harmonica);
                     if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(harmonica);
                    }
                if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
                   AtonalView.aa.setInstrument(harmonica); 
                
                }if (command.equalsIgnoreCase(accoridan)) {
                   if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                    FreeView.aa.setInstrument(accoridan);
                    if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(accoridan);
                    }
                if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
                AtonalView.aa.setInstrument(accoridan);
                }if (command.equalsIgnoreCase(clarinet)) {
                   if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                    FreeView.aa.setInstrument(clarinet);
                    if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(clarinet);
                    }
                if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
                   AtonalView.aa.setInstrument(clarinet);
                }if (command.equalsIgnoreCase(SOUNDTRACK)) {
                  if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                    FreeView.aa.setInstrument(SOUNDTRACK);
                   if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
                       AtonalView.aa.setInstrument(SOUNDTRACK);
                      if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(SOUNDTRACK);
                    }  
                }if (command.equalsIgnoreCase(helicopter)) {
                   if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                         FreeView.aa.setInstrument(helicopter);
  if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
      AtonalView.aa.setInstrument(helicopter);
       if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(helicopter);
                    }
                }if (command.equalsIgnoreCase(GUNSHOT)) {
                  if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
                    FreeView.aa.setInstrument(GUNSHOT);
                  if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
                    AtonalView.aa.setInstrument(GUNSHOT);
                   if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                        AlgorithmicView.aa.setInstrument(GUNSHOT);
                    }
                }
    
            }});
     panel.add(showItButton, BorderLayout.PAGE_END);
        this.add(panel);
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
