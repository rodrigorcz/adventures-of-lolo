package Controler;

import java.util.ArrayList;
import java.util.List;
import Level.*;
import Auxiliar.*;
import Save.SaveData;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

public class VideoGame implements InterfaceFase{
    private ArrayList<Fase> fase;
    private TelaInicio inicio;
    private int indexLevel;
    
    public VideoGame(){
        this.fase = new ArrayList<>();
        this.inicio = new TelaInicio(this);
        this.fase.add(new Level_1(this));
        this.fase.add(new Level_2(this));
        this.fase.add(new Level_3(this));
        this.fase.add(new Level_4(this));
        this.fase.add(new Level_5(this));
        
        this.indexLevel = 0;
    }

    public ArrayList<Fase> getArray() {
        return fase;
    }

    public void setArray(ArrayList<Fase> fase) {
        this.fase = fase;
    }
    
    public Fase getFase(){
      return this.fase.get(this.indexLevel);
    }
    
    @Override
    public void terminaFase() {
        this.getFase().stopFase();
        this.nextFase();
    }

   
    public void nextFase() {
        if(++indexLevel >= fase.size()){
            System.exit(0);
        }
        this.startGame();
    }
    
    public void terminaInicio(){
        startGame();
    }
    
    public void iniciarTela(){
        inicio.start();
    }
    
    public void startGame(){
        Fase fase = this.getFase();
        java.awt.EventQueue.invokeLater(fase::start);
    }

    public void setArray(SaveData sd) {
        
    }
    
}
