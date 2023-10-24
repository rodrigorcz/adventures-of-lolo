package Obstacles;

import Auxiliar.*;
import Controler.Tela;
import Entities.*;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author marcussilva
 */
public class Grama extends Personagem implements Serializable{
    
    public Grama(int Linha, int Coluna){
        super("gramanovo.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = true;
        this.ehMortal = false;
    }
}
