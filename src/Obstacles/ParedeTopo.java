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
public class ParedeTopo extends Personagem implements Serializable{

    public ParedeTopo(int Linha, int Coluna) {
        super("paredeTopo.jpeg", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;

    }
}
