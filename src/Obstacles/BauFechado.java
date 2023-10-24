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
public class BauFechado extends Personagem implements Serializable{
    
    public BauFechado(int Linha, int Coluna){
        super("bauFechado.jpeg", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
}
