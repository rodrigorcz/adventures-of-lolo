package Entities.Enemy;

import Auxiliar.*;
import Entities.*;
import java.util.Random;

public class BichoVerde extends Inimigo{
    private int countTime;
    private int moveCount;
    private int orientacao;
    
    public BichoVerde(int Linha, int Coluna) {
        super("verdeB.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = true;
        Random r = new Random();
        this.tipoElem = 3;
        this.orientacao = r.nextInt(4) + 1;;
        this.countTime = 0;
        this.moveCount = 0;
    }
    
    public boolean moveDown(){
        return super.moveDown("verdeB.png");
    }
    
    public boolean moveUp(){
        return super.moveUp("verdeC.png");
    }
    
    public boolean moveLeft(){
        return super.moveLeft("verdeE.png");
    }
    
    public boolean moveRight(){
        return super.moveRight("verdeD.png");
    }

    public void autoDesenho(){
        super.autoDesenho();
            this.countTime++;
            if(this.countTime == Constantes.TIMER+5){
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
