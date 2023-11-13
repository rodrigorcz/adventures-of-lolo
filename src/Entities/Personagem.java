package Entities;

import Auxiliar.*;



/*
 *  Personagem é um Elemento que pode:
 *      - Mover em direções específicas  
 *      - Por padrão sao mortais
 */

public abstract class Personagem extends Elemento {  
    private int direcao;

    protected Personagem(String nomeImagem, Posicao posicao) {
        super(nomeImagem, posicao);
        this.ehTransponivel = true;
        this.ehMortal = true;
    }

    //Funções auxiliares
    @Override
    public boolean setPosicao(int linha, int coluna){
        if(this.atualPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
                return false;
            } 
            return true;
        }
        return false;       
    }  
    
    public boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    
    public void voltaAUltimaPosicao(){
        this.atualPosicao.volta();
    }
    
    //Gets e Sets
    public int getDirecao(){
        return direcao;
    }

    //Movimentação do Personagem
    public boolean moveUp(String imgCima) {
        if(super.moveUp()){
            this.setImage(imgCima);
            return validaPosicao();
        }
        return false;
    }

    public boolean moveDown(String imgBaixo) {
        if(super.moveDown()){
            this.setImage(imgBaixo);
            return validaPosicao();
        }
        return false;
    }

    public boolean moveRight(String imgDireita) {
        if(super.moveRight()){
            this.setImage(imgDireita);
            return validaPosicao();  
        }
        return false;
    }

    public boolean moveLeft(String imgEsquerda) {
        if(super.moveLeft()){
            this.setImage(imgEsquerda);
            return validaPosicao();
        }
        return false;
    } 
}
