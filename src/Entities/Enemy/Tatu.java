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
    
    int linha;
    int coluna;
    
    public Tatu(int Linha, int Coluna){
        super("tatu.png", new Posicao(Linha, Coluna));
        this.linha = Linha;
        this.coluna = Coluna;
    }
    
    public void autoDesenho(){
        //Random rand = new Random();
        //int iDirecao = 0;//rand.nextInt(4);
        
        for(int i = 0; i <= 1; i++){
            this.moveDown();
            //this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
        }
        
        for(int i = 0; i <= 1; i++){
            this.moveRight();
            //this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
        }
        
        /*
        for(iDirecao = 0; iDirecao <= 6; iDirecao++){
            if(iDirecao <= 1){
                this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
            }else if(iDirecao == 2 || iDirecao == 3){
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
            }else if(iDirecao == 4 || iDirecao == 5){
                this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());
            }else if(iDirecao == 5 || iDirecao == 6){
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);
            }
            
        }*/
        
        //iDirecao = 0;
        super.autoDesenho();
    }  
    
   public boolean movimenta() {
       int randomNum = Random().nextInt(1, 5);
       switch (randomNum) {
           case 1:
               return moveUp();
           case 2:
               return moveDown();
           case 3:
               return moveRight();
           case 4:
               return moveLeft();
           default:
               return false;
       }
       
  }
}
