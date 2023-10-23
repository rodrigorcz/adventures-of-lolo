package Controler;

import java.util.ArrayList;
import java.util.List;
import Level.*;
import Auxiliar.*;

public class VideoGame implements Complete{
    private final ArrayList<Fase> fases;
    private int indexLevel;
    
    public VideoGame(){
        this.fases = new ArrayList<>();
        this.fases.add(new Level_1(this));
        this.fases.add(new Level_2(this));
        this.fases.add(new Level_1(this));

        
        this.indexLevel = 0;
    }
    
    public Fase getFase(){
        return this.fases.get(this.indexLevel);
    }
    
    public void setLevel(int indexLevel){
        this.indexLevel = indexLevel;
    }
    
    public void startGame(){
        Fase fase = this.getFase();
        java.awt.EventQueue.invokeLater(fase::start);
    }
    
    @Override
    public void onPhaseComplete(){
        this.indexLevel++;
        Fase fase = this.getFase();
        java.awt.EventQueue.invokeLater(fase::start);
    }
}
