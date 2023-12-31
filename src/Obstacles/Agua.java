package Obstacles;

import Auxiliar.Posicao;
import Entities.Elemento;

public class Agua extends Elemento{
    private int delay;
    public Agua(int Linha, int Coluna){
        super("Agua1.png", new Posicao(Linha, Coluna));
        this.delay = 0;
    }
    
    @Override
    public void autoDesenho(){
        if(delay < 10){
            this.setImage("Agua1.png");
            delay++;
        }
        else if(delay < 20){
            this.setImage("Agua2.png"); 
            delay++;
        }else if(delay < 30){
            this.setImage("Agua3.png"); 
            delay++;
        }else 
            delay = 0;          

        super.autoDesenho();

    }
}
