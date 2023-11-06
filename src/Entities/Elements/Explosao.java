package Entities.Elements;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Entities.Elemento;

public class Explosao extends Elemento {
    private int delay;
    
    public Explosao(int Linha, int Coluna){
         super("explosao1.png", new Posicao(Linha, Coluna));
         delay = 0;
         this.ehTransponivel = true;
    }
    
    @Override
    public void autoDesenho(){
        if(delay < 1*Consts.TIMER){
            this.setImage("explosao1.png");
            delay++;
        }else if(delay < 2*Consts.TIMER){
            this.setImage("explosao2.png"); 
            delay++;
        }else if(delay < 3*Consts.TIMER){
            this.setImage("explosao3.png"); 
            delay++;
        }else if(delay < 4*Consts.TIMER){
            this.setImage("explosao4.png"); 
            delay++;
        }else
            delay = 0;
        
        super.autoDesenho();
    }
    
    
}
