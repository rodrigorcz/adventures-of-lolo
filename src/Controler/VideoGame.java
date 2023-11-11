package Controler;

import java.util.ArrayList;
import java.util.List;
import Level.*;
import Auxiliar.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

public class VideoGame implements InterfaceFase{
    private final ArrayList<Fase> fase;
    private TelaInicio inicio;
    private TelaFinal fim;
    private int indexLevel;
    
    public VideoGame(){
        this.fase = new ArrayList<>();
        this.inicio = new TelaInicio(this);
        this.fim = new TelaFinal(this,false);
        
        this.fase.add(new Level_1(this));
        this.fase.add(new Level_2(this));
        this.fase.add(new Level_3(this));
        this.fase.add(new Level_4(this));
        this.fase.add(new Level_5(this));
         
        this.indexLevel = 0;
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
            fim.start();
            return;
        }
        this.startGame();
    }
    
    public void terminaInicio(){
        startGame();
    }
    
    public void terminaFim(){
        fim.stop();
        System.exit(0);
    }
    
    public void iniciarTela(){
        inicio.start();
    }
    
    public void startGame(){
        Fase fase = this.getFase();
        java.awt.EventQueue.invokeLater(fase::start);
    }
    
}
