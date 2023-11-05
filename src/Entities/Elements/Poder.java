package Entities.Elements;

import Auxiliar.*;
import Entities.Personagem;

public class Poder extends Personagem{
    public int orientacaoPoder;
    
    public Poder() {
        super("Poder.png", new Posicao(1, 1));
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
            if(!this.moveLeft()){
                Desenho.acessoATelaDoJogo().removePersonagem(this); 
            }
        }
        
        if(Desenho.acessoATelaDoJogo().ehInimigo(this.getPosicao())){
            Desenho.acessoATelaDoJogo().removePersonagem(this);

        }
        
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
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            return false;
        }
        return true;       
    }
    
}
