package Obstacles;

import Auxiliar.*;
import Controler.Tela;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author marcussilva
 */
public class Coracao extends Personagem implements Serializable{
    
    public Coracao(int Linha, int Coluna){
        super("Coracao.png",new Posicao(Linha, Coluna));
        this.ehTransponivel = true;
    }
}
