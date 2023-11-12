package Controler;

import java.util.ArrayList;

import Level.*;
import Auxiliar.*;
import Save.SaveData;

public class VideoGame implements ObserverJogo{
    private ArrayList<Fase> fase;
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
            this.iniciarFim(true);
            return;
        }
        this.startGame();
    }
    
    public void terminaInicio(){
        inicio.stop();
        startGame();
    }
    
    public void terminaFim(){
        fim.stop();
        System.exit(0);
    }
    
    public void iniciarTela(){
        inicio.start();
    }
    
    public void iniciarFim(boolean venceu){
        fim.start(venceu);
    }
    
    public void startGame(){
        Fase fase = this.getFase();
        java.awt.EventQueue.invokeLater(fase::start);
    }

    public void setArray(SaveData sd) {
        
    }
    
}
