package Obstacles;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Entities.Personagem;
import java.io.Serializable;


public class Agua extends Personagem implements Serializable{
    private int delay;
    public Agua(int Linha, int Coluna){
        super("Agua1.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
        this.delay = 0;
    }
    
    @Override
    public void autoDesenho(){
        if(delay < Consts.TIMER){
            this.setImage("Agua1.png");
            delay++;
        }
        else if(delay < 2*Consts.TIMER){
            this.setImage("Agua2.png"); 
            delay++;
        } else 
            delay = 0;          

        super.autoDesenho();

    }
}
