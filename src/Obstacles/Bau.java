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
public class Bau extends Personagem implements Serializable{
    
    public Bau(int Linha, int Coluna, String Bau){
        super(Bau, new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
}
