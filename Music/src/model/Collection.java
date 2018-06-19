package model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.swing.JFileChooser;
import org.jfugue.Player;
import org.jfugue.Pattern;
import view.FreeView;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 @author Klodjan Hidri
 * @author Evagelia Petavraki
 */
public class Collection {
    private String nameCollection;
    protected static ArrayList<File> c=new ArrayList<File>();
    private Thread[] thread;
    private Player player=new Player();
    private Pattern pattern;
    private FileWriter fw = null;
     private BufferedWriter bw =null;
   protected static ArrayList<File>musicSongs=new ArrayList<File>();
     public Collection(){
    
    }
 
    public Collection(String nameCollection){
        this.nameCollection=nameCollection;
     
     }
    
    public void openFile(){
        
    }
     public void setCollection(String a){
         this.nameCollection=a;
     }
     public String getCollection(){
         return this.nameCollection;
         
     }
     
      public void addFile(File s) throws IOException, InvalidMidiDataException{
         
          this.addMusic(s);
          
      }
     
     public void addFolder() throws IOException, InvalidMidiDataException{
         JFileChooser fc = new JFileChooser();
              fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
              fc.setVisible(true);
                String folder = fc.getSelectedFile().getAbsolutePath();
                File s=new File(folder);
          File[] listOfFiles = s.listFiles();
          System.out.print(s.listFiles());
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
              this.addMusic(s);
            
            }
         
     }
     }
     
     public void save(File file) throws IOException{
         try {
                    fw = new FileWriter(file.getAbsoluteFile());
                } catch (IOException ex) {
                    Logger.getLogger(FreeView.class.getName()).log(Level.SEVERE, null, ex);
                }
			bw= new BufferedWriter(fw);
               for(int i=0;i<this.getaddMusic().size();i++)
                    bw.write(this.getaddMusic().get(i).getAbsolutePath()+"\n");
                
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(FreeView.class.getName()).log(Level.SEVERE, null, ex);
                }
         
     }
     
     public static void addMusic(File song) throws IOException, InvalidMidiDataException {
       Collection.musicSongs.add(song);
        
       
   }
     public static ArrayList<File> getaddMusic(){
         return Collection.musicSongs;
     }
     
     
     public void setplayMusic(File s) throws IOException, InvalidMidiDataException{
         
       this.c.add(s);
 System.out.println(c+"  dafdasd");
    } 
     
  
     
     public static ArrayList<File> getplayMusic() {
       return Collection.c;
 
    }  
   
}
