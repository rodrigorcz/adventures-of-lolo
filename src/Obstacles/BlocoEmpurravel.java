package Obstacles;

import Auxiliar.*;
import Controler.Tela;
import Entities.*;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author marcussilva
 */
public class BlocoEmpurravel extends Personagem implements Serializable{
    
    public BlocoEmpurravel(int Linha, int Coluna){
        super("bloco_empurravel.png", new Posicao(Linha, Coluna));
        //this.setbTransponivel(false);
        this.ehEmpurravel = true;
    }
    
    public boolean moveUp(){
        return this.pPosicao.moveUp();
    }
    
    public boolean moveDown(){
        return this.pPosicao.moveDown();
    }
    
    public boolean moveRight(){
        return this.pPosicao.moveRight();
    }
    
    public boolean moveLeft(){
        return this.pPosicao.moveLeft();
    }
}
