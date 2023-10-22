package Entities.Enemy;

import Entities.Personagem;
import Auxiliar.*;
import Entities.Personagem;
import java.util.Random;

public class ZigueZague extends Personagem{
    
    public ZigueZague(int Linha, int Coluna) {
        super("robo.png", new Posicao(Linha, Coluna));
    }

    public void autoDesenho(){
        Random rand = new Random();
        int iDirecao = rand.nextInt(4);
        
        if(iDirecao == 1)
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
        else if(iDirecao == 2)
            this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
        else if(iDirecao == 3)
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);
        else if(iDirecao == 4)
            this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());
        
        super.autoDesenho();
    }    
}
