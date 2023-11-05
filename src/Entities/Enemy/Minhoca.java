package Entities.Enemy;

import Auxiliar.*;
import Entities.Inimigo;

public class Minhoca extends Inimigo{
    private int delay;

    public Minhoca(int Linha, int Coluna) {
        super("minhocaD.png", new Posicao(Linha, Coluna));
        this.delay = 0;
        this.ehTransponivel = false;
        this.tipoElem = 2;
    }
    
    @Override
    public void autoDesenho(){
        if(delay < Consts.TIMER){
            this.setImage("minhocaE.png");
            delay++;
        }
        else if(delay < 2*Consts.TIMER){
            this.setImage("minhocaD.png"); 
            delay++;
        } else 
            delay = 0;
        
        super.autoDesenho();
    }
}
