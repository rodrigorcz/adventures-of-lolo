package Entities.Enemy;

import Auxiliar.*;
import Entities.Inimigo;
import java.util.Random;

public class Caveira extends Inimigo{

    private int linha;
    private int coluna;
    private int countTime;
    private int moveCount;
    private int orientacao;
    
    public Caveira(int Linha, int Coluna) {
        super("caveira.png", new Posicao(Linha, Coluna));
        this.linha = Linha;
        this.coluna = Coluna;
        this.ehTransponivel = false;
        this.tipoElem = 4;
        this.orientacao = 4;
        this.countTime = 0;
        this.moveCount = 0;
    }
    
    public boolean moveDown(){
        return super.moveDown("caveiraB.png");
    }
    
    public boolean moveUp(){
        return super.moveUp("caveiraC.png");
    }
    
    public boolean moveLeft(){
        return super.moveLeft("caveiraE.png");
    }
    
    public boolean moveRight(){
        return super.moveRight("caveiraD.png");
    }
    
    public void autoDesenho(){
        super.autoDesenho();
        if(Desenho.acessoATelaDoJogo().faseTerminou()){
            this.ehTransponivel = true;
            this.countTime++;
            if(this.countTime == Constantes.TIMER-4){
                if(orientacao == 1){
                    if(!this.moveDown())
                        orientacao = 4;
                }

                if(orientacao == 2){
                    if(!this.moveRight())
                        orientacao = 1;

                }

                if(orientacao == 3){
                    if(!this.moveUp())
                        orientacao = 2;
                }

                if(orientacao == 4){
                    if(!this.moveLeft())
                        orientacao = 3;
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
}
