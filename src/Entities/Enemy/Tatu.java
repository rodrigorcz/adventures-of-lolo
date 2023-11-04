package Entities.Enemy;

import Auxiliar.*;
import Controler.Tela;
import Entities.Elements.Fogo;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author marcussilva
 */
public class Tatu extends Personagem implements Serializable{
    
    private int linha;
    private int coluna;
    private int countTime;
    private int moveCount;
    private int orientacao;
    public Tatu(int Linha, int Coluna){
        super("tatu.png", new Posicao(Linha, Coluna));
        this.linha = Linha;
        this.coluna = Coluna;
        this.ehTransponivel = true;
        this.tipoElem = 2;
        this.orientacao = 1;
        this.countTime = 0;
        this.moveCount = 0;
    }
    

    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().movimentoInimigo(this.getPosicao())) {
                this.voltaAUltimaPosicao();
                return false;
            } 
            return true;
        }
        return false;       
    }
    
    public boolean moveUp() {
        if(super.moveUp()){
            this.setImage("TatuCima.png");
            return validaPosicao();
        }
        return false;
    }

    public boolean moveDown() {
        if(super.moveDown()){
            this.setImage("tatu.png");
            return validaPosicao();
        }
        return false;
    }

    public boolean moveRight() {
        if(super.moveRight()){
            this.setImage("TatuD.png");
            return validaPosicao();  
        }
        return false;
    }

    public boolean moveLeft() {
        if(super.moveLeft()){
            this.setImage("TatuE.png");
            return validaPosicao();
        }
        return false;
    }   
    
    private boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().movimentoInimigo(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    public void autoDesenho(){
        super.autoDesenho();
        this.countTime++;
        if(this.countTime == Consts.TIMER-1){
            if(orientacao == 1){
                if(!this.moveDown())
                    orientacao = 2;
            }

            if(orientacao == 2){
                if(!this.moveRight())
                    orientacao = 3;

            }

            if(orientacao == 3){
                if(!this.moveUp())
                    orientacao = 4;
            }

            if(orientacao == 4){
                if(!this.moveLeft())
                    orientacao = 1;
            }
            this.moveCount++;
            this.countTime = 0;
        }
        
        if(moveCount == 14){
            Random r = new Random();
            int numeroAleatorio = r.nextInt(4) + 1;
            this.orientacao = numeroAleatorio;
            moveCount = 0;
        }
    }  
}