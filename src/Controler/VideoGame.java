package Controler;

import java.util.ArrayList;
import java.util.List;
import Level.*;
import Auxiliar.*;

public class VideoGame implements InterfaceFase{
    private final ArrayList<Fase> fase;
    private int indexLevel;
    
    public VideoGame(){
        this.fase = new ArrayList<>();
        this.fase.add(new Level_1(this));
        this.fase.add(new Level_2(this));
        this.fase.add(new Level_3(this));
        
        this.indexLevel = 0;
    }
    
    public Fase getFase(){
        return this.fase.get(this.indexLevel);
    }
    
    @Override
    public void terminaFase(){
        this.getFase().stopFase();
        this.nextFase();
    }
    
    public void nextFase() {
        this.indexLevel = this.indexLevel + 1;
        this.startGame();
    }
    
    public void startGame(){
        Fase fase = this.getFase();
        java.awt.EventQueue.invokeLater(fase::start);
    }
}
