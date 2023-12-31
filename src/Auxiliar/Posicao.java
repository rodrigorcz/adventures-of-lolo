package Auxiliar;

import java.io.Serializable;

public class Posicao implements Serializable{
    private int	linha;
    private int coluna;
    
    private int linhaAnterior;
    private int colunaAnterior;

    public Posicao(int linha, int coluna){
        this.setPosicao(linha,coluna);
    }

    //Definicao de Posicao
    public boolean setPosicao(int linha, int coluna){       
        if(linha < 0 || linha >= Auxiliar.Constantes.RES)
            return false;
        linhaAnterior = this.linha;
        this.linha = linha;
        
        if(coluna < 0 || coluna >= Auxiliar.Constantes.RES)
            return false;
        colunaAnterior = this.coluna;
        this.coluna = coluna;
        
        return true;
    }
    
    //Sistema de Orientacao baseado na posicaoAtual e posicaoAnterior
    public int getOrientacao(){
        if(linhaAnterior < this.linha){
            return 1;
        }else if(colunaAnterior < this.coluna){
            return 2;
        }else if(linhaAnterior > this.linha){
            return 3;
        }else 
            return 4;
        
        /* 
                 (1)   
                  |  
            (4)---|---(2)
                  |
                 (3)
        */
    }
    public int getLinha(){
        return linha;}
   
    public boolean volta(){
        return this.setPosicao(linhaAnterior,colunaAnterior); }
   
    public int getColuna(){
        return coluna;}
   
    public boolean igual(Posicao posicao){
        return (linha == posicao.getLinha() && coluna == posicao.getColuna());
    }
  
    public boolean copia(Posicao posicao){
        return this.setPosicao(posicao.getLinha(),posicao.getColuna());
    }
  
    public boolean moveUp(){
        return this.setPosicao(this.getLinha()-1, this.getColuna());
    }
   
    public boolean moveDown(){
        return this.setPosicao(this.getLinha()+1, this.getColuna());
    }
   
    public boolean moveRight(){
        return this.setPosicao(this.getLinha(), this.getColuna()+1);
    }
   
    public boolean moveLeft(){
        return this.setPosicao(this.getLinha(), this.getColuna()-1);
    }      
   
}