package Entities.Elements;

import Auxiliar.*;
import Entities.Personagem;

public class Poder extends Personagem{
    public int orientacaoPoder;
    
    public Poder() {
        super("", new Posicao(1, 1));
    }
    
    @Override
    public void autoDesenho() {
        
        super.autoDesenho();
        if(orientacaoPoder == 1){
            if(!this.moveDown())
                Desenho.acessoATelaDoJogo().removeElement(this);
        }
        
        if(orientacaoPoder == 2){
            if(!this.moveRight())
                Desenho.acessoATelaDoJogo().removeElement(this);
        }
        
        if(orientacaoPoder == 3){
            if(!this.moveUp())
                Desenho.acessoATelaDoJogo().removeElement(this);
        }

        if(orientacaoPoder == 4){
            if(!this.moveLeft()){
                Desenho.acessoATelaDoJogo().removeElement(this); 
            }
        }
        
        if(Desenho.acessoATelaDoJogo().transformaInimigo(this.getPosicao())){
            Desenho.acessoATelaDoJogo().removeElement(this);
        }
    }
    
    @Override
    public boolean setPosicao(int linha, int coluna){
        if(this.atualPosicao.setPosicao(linha, coluna)){
            if(Desenho.acessoATelaDoJogo().transformaInimigo(this.getPosicao())){
                Desenho.acessoATelaDoJogo().removeElement(this);
                return false;
            }
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValidaTiro(this.getPosicao())) {
                Desenho.acessoATelaDoJogo().removeElement(this);
                return false;
            } 
            return true;
        }
        return false;       
    } 
    public boolean moveDown(){
        return super.moveDown("Poder.png");
    }
    
    public boolean moveUp(){
        return super.moveUp("Poder.png");
    }
    
    public boolean moveLeft(){
        return super.moveLeft("Poder.png");
    }
    
    public boolean moveRight(){
        return super.moveRight("Poder.png");
    }
    
    @Override
    public boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValidaTiro(this.getPosicao())) {
            return false;
        }
        return true;       
    }
    
}
