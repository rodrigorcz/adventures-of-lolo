package Entities.Elements;

import Auxiliar.*;
import Entities.*;

public class Ovo extends Empurravel {
    private int delay;
    
    public Ovo(int Linha, int Coluna) {
        super(Linha, Coluna);
        this.delay = 0;
        this.setImage("ovo.png");
    }
    
    @Override
    public void autoDesenho(){       
        
        super.autoDesenho();
        if(delay > 5*Consts.TIMER){
            this.setImage("ovoQuebrado.png");
            
        }
        delay++;
    }
}
