/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Elements;

import Auxiliar.Desenho;
import Auxiliar.Posicao;
import Entities.Personagem;
import java.io.Serializable;

/**
 *
 * @author rodrigo
 */
public class Poder extends Personagem implements Serializable{
    public int orientacaoPoder;
    public Poder() {
        super("Poder.png", new Posicao(1, 1));
        this.ehMortal = true;
    }
    
    @Override
    public void autoDesenho() {
        
        super.autoDesenho();
        if(orientacaoPoder == 1){
            if(!this.moveDown())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
        }
        
        if(orientacaoPoder == 2){
            if(!this.moveRight())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
        }
        
        if(orientacaoPoder == 3){
            if(!this.moveUp())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
        }

        if(orientacaoPoder == 4){
            if(!this.moveLeft())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
        }
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
