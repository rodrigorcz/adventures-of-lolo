package Entities.Elements;

import Auxiliar.* ;
import Controler.Tela;
import Entities.Elemento;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;

public class Fogo extends Personagem implements Serializable{
            
    public Fogo() {
        super("fire.png", new Posicao(1, 1));
        this.ehMortal = true;
    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveRight())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    
    }
    
    public boolean moveRight() {
        if(super.moveRight())
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
