/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.jfugue.Pattern;
import org.jfugue.Player;
import view.AlgorithmicView;
import view.AtonalView;
import view.FreeView;
import view.SelectModeMusic;

/**
 *
 * @author klodjan
 */
class playerThread   implements Runnable // plays midi using jfugue Player
{

    private Pattern pt=new Pattern();
    private Player player=new Player();
    
    public void setPattern(Pattern p) {
        pt = p;
    }
public void stopTrack(){
    this.player.close();
}
    
    @Override
    public void run() {
        try {
            
            player.play(pt);
            if(SelectModeMusic.commands.equalsIgnoreCase("Free"))
            FreeView.button17.setIcon(FreeView.iconPlay);
            if(SelectModeMusic.commands.equalsIgnoreCase("Atonal"))
            AtonalView.button17.setIcon(AtonalView.iconPlay);
            if(SelectModeMusic.commands.equalsIgnoreCase("Algorithm")) {
                AlgorithmicView.button17.setIcon(AlgorithmicView.iconPlay);
            }
            
        } catch (Exception exception) {
        }
    }
    
    
   
}