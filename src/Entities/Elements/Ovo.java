package Entities.Elements;

import Auxiliar.*;
import Entities.*;
import Entities.Enemy.*;

public class Ovo extends Empurravel {
    private int delay;
    private int tipoOvo;
    public Ovo(int Linha, int Coluna, int tipo) {
        super(Linha, Coluna);
        this.delay = 0;
        this.setImage("ovo.png");
        tipoOvo = tipo;
    }
    
    @Override
    public void autoDesenho(){       
        
        super.autoDesenho();
        if(delay > Constantes.TIMER_OVO && delay <2*Constantes.TIMER_OVO){
            this.setImage("ovoQuebrado.png");   
        }else if( delay > 2*Constantes.TIMER_OVO){
            int linha = this.getPosicao().getLinha();
            int coluna = this.getPosicao().getColuna();
            Desenho.acessoATelaDoJogo().removeElement(this);
            switch(tipoOvo){
                case 3:
                    Desenho.acessoATelaDoJogo().addElement(new BichoVerde(linha,coluna));
                    break;
                case 4:
                    Desenho.acessoATelaDoJogo().addElement(new Caveira(linha,coluna));
                    break;
                case 5:
                    Desenho.acessoATelaDoJogo().addElement(new Minhoca(linha,coluna));
                    break;
                case 6:
                    Desenho.acessoATelaDoJogo().addElement(new Tatu(linha,coluna));
                    break;
                default:
                    break;
            }
                    
        }
        
        delay++;
    }
}
