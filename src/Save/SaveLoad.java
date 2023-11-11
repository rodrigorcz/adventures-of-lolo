package Save;

import Auxiliar.*;
import Controler.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author marcussilva
 */
public class SaveLoad {
    VideoGame ss;

    public SaveLoad(VideoGame ss) {
        this.ss = ss;
    }
    
    public void save() throws IOException{
        
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("level.dat")));
            
            SaveData sd = new SaveData();
            
            sd.level = ss.getArray();
            
            os.writeObject(sd); 
        }catch(Exception ex){
            System.out.println("Save Exception!!");
        }
    }
    
    public void load(){
        
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("level.dat")));
            
            SaveData sd = (SaveData)ois.readObject();
            
            ss.setArray(sd.level);
            
        }catch(Exception ex){
            System.out.println("Load Exception!!");
        }
    }
}
