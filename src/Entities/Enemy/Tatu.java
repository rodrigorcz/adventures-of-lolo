package Entities.Enemy;

import Auxiliar.*;
import Controler.Tela;
import Entities.Elements.Fogo;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;
/**
 *
 * @author marcussilva
 */
public class Tatu extends Personagem implements Serializable{
    
    private int linha;
    private int coluna;
    private int delay = 0;
    private int movimentoDelay = 3; 
    private int moveCount = 0;
    private boolean move;
    
    public Tatu(int Linha, int Coluna){
        super("tatu.png", new Posicao(Linha, Coluna));
        this.linha = Linha;
        this.coluna = Coluna;
        move = true;
    }

    public void contador() {
        delay++;
        if (delay >= movimentoDelay) {
            delay = 0; // Zerar o atraso para permitir o próximo movimento
            if (move) {
                this.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                moveCount++;
                if (moveCount >= 2) {
                    move = !move;
                    moveCount = 0;
                }
            } else {
                this.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
                moveCount++;
                if (moveCount >= 2) {
                    move = !move;
                    moveCount = 0;
                }
            }
        }
    }
    
    public void autoDesenho(){
        
        contador();
        
        super.autoDesenho();
    }  
}
