package Entities.Enemy;

import Auxiliar.*;
import Entities.Inimigo;
import java.util.Random;

public class Tatu extends Inimigo{
    private int countTime;
    private int moveCount;
    private int orientacaoTatu;
    
    public Tatu(int Linha, int Coluna){
        super("tatu.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = true;
        this.orientacaoTatu = 1;
        this.countTime = 0;
        this.moveCount = 0;
    }
    
    public boolean moveDown(){
        return super.moveDown("tatu.png");
    }
    
    public boolean moveUp(){
        return super.moveUp("TatuCima.png");
    }
    
    public boolean moveLeft(){
        return super.moveLeft("TatuE.png");
    }
    
    public boolean moveRight(){
        return super.moveRight("TatuD.png");
    }

    
    public void autoDesenho(){
        super.autoDesenho();
        this.countTime++;
        if(this.countTime == Consts.TIMER-1){
            if(orientacaoTatu == 1){
                if(!this.moveDown())
                    orientacaoTatu = 2;
            }

            if(orientacaoTatu == 2){
                if(!this.moveRight())
                    orientacaoTatu = 3;

            }

            if(orientacaoTatu == 3){
                if(!this.moveUp())
                    orientacaoTatu = 4;
            }

            if(orientacaoTatu == 4){
                if(!this.moveLeft())
                    orientacaoTatu = 1;
            }
            this.moveCount++;
            this.countTime = 0;
        }
        
        if(moveCount == 14){
            Random r = new Random();
            int numeroAleatorio = r.nextInt(4) + 1;
            this.orientacaoTatu = numeroAleatorio;
            moveCount = 0;
        }
    }  
}