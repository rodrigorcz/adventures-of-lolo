package Controler;

import java.util.ArrayList;

import Level.*;
import Auxiliar.*;

public class VideoGame implements ObserverJogo{
    private ArrayList<Fase> fase;
    private TelaInicio inicio;
    private TelaFinal fim;
    private int indexLevel;
    
    //Instanciacao de todas as fases e telas
    public VideoGame(){
        this.fase = new ArrayList<>();
        this.inicio = new TelaInicio(this);
        this.fim = new TelaFinal(this,false);
        
        this.fase.add(new Level_1(this));
        this.fase.add(new Level_2(this));
        this.fase.add(new Level_3(this));
        this.fase.add(new Level_4(this));
        this.fase.add(new Level_5(this));
        this.fase.add(new Level_6(this));
         
        this.indexLevel = 0;
    }

    // Inicia a Fase
    public void startGame(){
        Fase fase = this.getFase();
        java.awt.EventQueue.invokeLater(fase::start);
    }

    // Avança para proxima fase
    public void nextFase() {
        if(++indexLevel >= fase.size()){
            this.iniciarFim(true);
            return;
        }
        this.startGame();
    }
    
    // Inicio e Terminos das Telas
    public void iniciarTela(){
        inicio.start();
    }
    
    @Override
    public void iniciarFim(boolean venceu){
        fim.start(venceu);
    }
    
    @Override
    public void terminaFase() {
        this.getFase().stopFase();
        this.nextFase();
    }
    
    @Override
    public void terminaInicio(){
        inicio.stop();
        startGame();
    }
    @Override
    public void terminaFim(){
        fim.stop();
        System.exit(0);
    }
    
    //Gets e Sets
    public ArrayList<Fase> getArray() {
        return fase;
    }

    public void setArray(ArrayList<Fase> fase) {
        this.fase = fase;
    }
    
    public Fase getFase(){
      return this.fase.get(this.indexLevel);
    }

}
