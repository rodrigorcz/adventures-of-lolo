package Controler;

import java.util.ArrayList;
import java.util.List;
import Level.*;
import Auxiliar.*;

public class VideoGame {
    private final ArrayList<Fase> fase;
    private int indexLevel;
    
    public VideoGame(){
        this.fase = new ArrayList<>();
        this.fase.add(new Level_1());
  
        this.indexLevel = 0;
    }
    
    public Fase getFase(){
        return this.fase.get(this.indexLevel);
    }
    
    public void nextFase() {
        this.indexLevel++;
        this.startGame();
    }
    
    public void startGame(){
        Fase fase = this.getFase();
        java.awt.EventQueue.invokeLater(fase::start);
    }
}