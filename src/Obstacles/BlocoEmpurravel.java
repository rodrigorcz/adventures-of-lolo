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
        this.ehEmpurravel = true;
    }
    
    public boolean moveUp() {
        if(super.moveUp())
            return validaPosicao();
        return false;
    }

    public boolean moveDown() {
        if(super.moveDown())
            return validaPosicao();
        return false;
    }

    public boolean moveRight() {
        if(super.moveRight())
            return validaPosicao();
        return false;
    }

    public boolean moveLeft() {
        if(super.moveLeft())
            return validaPosicao();
        return false;
    }
    
    
    private boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
