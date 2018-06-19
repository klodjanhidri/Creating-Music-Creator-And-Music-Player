package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.midi.InvalidMidiDataException;
import org.jfugue.Player;
import view.ListMusicView;
import view.ThreadPlayer;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Klodjan Hidri
 * @author Evagelia Petavraki
 */
public class CreateListMusic extends Collection {

    private String ListMusicName, tmp = null;
    private Player player = new Player();
    public static Boolean replay = false, replayall = false, select = false, random = false, defa = false,
            prev = false, next = false,upper=false;
    private ThreadPlayer pthread;
    private Thread threadPlyr;

    public CreateListMusic() {
    }

    public CreateListMusic(String ListMusicName, String nameCollection) {
        super(nameCollection);
        this.ListMusicName = ListMusicName;


    }

    public void removeMusic(File song) throws IOException, InvalidMidiDataException {
        Collection.getplayMusic().clear();
        for (int i = 0; i < Collection.getaddMusic().size(); i++) {
            if (Collection.getaddMusic().get(i).getAbsolutePath().equals(song.getAbsolutePath())) {
                System.out.println(Collection.getaddMusic());
                Collection.getaddMusic().remove(i);
                System.out.println(Collection.getaddMusic());
                break;

            }
        }
    }

    public void DragAndDrop() {
    }

    public void setListMusicName(String a) {
        this.ListMusicName = a;
    }

    public String getListMusicName() {
        return this.ListMusicName;
    }

    public Boolean selectMusicfromList(File song) throws IOException, InvalidMidiDataException {
        Collection.getplayMusic().clear();
        CreateListMusic.select = true;
        CreateListMusic.replay = false;
        CreateListMusic.replayall = false;
        CreateListMusic.random = false;
        CreateListMusic.defa = false;
        super.setplayMusic(song);

        return CreateListMusic.select;
    }

    public Boolean playDefaultlyMysic() throws IOException, InvalidMidiDataException {
        Collection.getplayMusic().clear();
        for (int i = 0; i < super.getaddMusic().size(); i++) {
            super.setplayMusic(new File(super.getaddMusic().get(i).getAbsolutePath()));
        }
        CreateListMusic.select = false;
        CreateListMusic.replay = false;
        CreateListMusic.replayall = false;
        CreateListMusic.random = false;
        CreateListMusic.defa = true;
        return CreateListMusic.defa;
    }

    public Boolean playRandomlyMysic() {

        CreateListMusic.select = false;
        CreateListMusic.replay = false;
        CreateListMusic.replayall = false;
        CreateListMusic.defa = false;
        return CreateListMusic.random = true;

    }

    public Boolean replayMusic(File song) throws IOException, InvalidMidiDataException {
        Collection.getplayMusic().clear();
        int j = 0;
        for (int i = 0; i < super.getaddMusic().size(); i++) {
            if (super.getaddMusic().get(i).equals(song)) {

                super.setplayMusic(song);



            }
        }
        CreateListMusic.select = false;
        CreateListMusic.replay = true;
        CreateListMusic.replayall = false;
        CreateListMusic.defa = false;
        CreateListMusic.random = false;
        return CreateListMusic.replay;
    }

    public Boolean replayAllListMusic(ArrayList<File> musicSongs) throws IOException, InvalidMidiDataException {
        for (int i = 0; i < musicSongs.size(); i++) {
            this.setplayMusic(musicSongs.get(i).getAbsoluteFile());
        }
        CreateListMusic.select = false;
        CreateListMusic.replay = false;
        CreateListMusic.replayall = true;
        CreateListMusic.defa = false;
        CreateListMusic.random = false;
        return CreateListMusic.replayall;

    }

    public void playMusic() throws IOException, InvalidMidiDataException {

        if (pthread == null) {
            pthread = new ThreadPlayer();
        }
        /*else {
         pthread = null;
         pthread = new ThreadPlayer();
         }*/
        if (threadPlyr == null) {
            threadPlyr = new Thread(pthread);
        } else {
            threadPlyr = null;
            threadPlyr = new Thread(pthread);

        }

        if (ThreadPlayer.pause) {
            threadPlyr.resume();
        } else {
            threadPlyr.start();
        }



    }

    public void pauseMusic() throws IOException, InvalidMidiDataException {
        threadPlyr.suspend();
        pthread.pauseTrack();
    }

    public Boolean stopMusic() {
        threadPlyr.stop();
        pthread.stopTrack();
        return true;

    }

    public Boolean previousMusic() {
        prev = true;
        next = false;
        return CreateListMusic.prev;
    }

    public Boolean nextMusic() {
        prev = false;
        next = true;
        return CreateListMusic.next;
    }
    public  void upper(File a) throws IOException, InvalidMidiDataException{
        ArrayList<File>s=new ArrayList<File>();
     int Track= Collection.getaddMusic().indexOf(a);
     System.out.println(Collection.getaddMusic());
     for(int i=0;i<Collection.getaddMusic().size();i++){
           
            if((i==Track-1)&&Track-1>0){
               s.add(new File(Collection.getaddMusic().get(i+1).getAbsolutePath()));
            s.add(new File(Collection.getaddMusic().get(i).getAbsolutePath()) );
            i++;
            }else
           s.add(new File(Collection.getaddMusic().get(i).getAbsolutePath() ));     
            
        }
     
     System.out.println(s+" s");
    Collection.getaddMusic().clear(); 
        for(int j=0;j<s.size();j++){
          
            
            Collection.addMusic( new File (s.get(j).getAbsolutePath()));
        }
     
           
        
    }
    
    public  void lower(File a) throws IOException, InvalidMidiDataException{
        ArrayList<File>s=new ArrayList<File>();
     int Track= Collection.getaddMusic().indexOf(a);
     System.out.println(Collection.getaddMusic());
     for(int i=0;i<Collection.getaddMusic().size();i++){
           
            if((i==Track)&&Track<Collection.getaddMusic().size()){
               s.add(new File(Collection.getaddMusic().get(i+1).getAbsolutePath()));
            s.add(new File(Collection.getaddMusic().get(i).getAbsolutePath()) );
            i++;
            }else
           s.add(new File(Collection.getaddMusic().get(i).getAbsolutePath() ));     
            
        }
     
     System.out.println(s+" s");
    Collection.getaddMusic().clear(); 
        for(int j=0;j<s.size();j++){
          
            
            Collection.addMusic( new File (s.get(j).getAbsolutePath()));
        }
     
            System.out.println(Collection.getaddMusic()+" super");
        
    }
    
    
}
