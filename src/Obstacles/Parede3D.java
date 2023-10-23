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
public class Parede3D extends Personagem implements Serializable{
    
    public Parede3D(int Linha, int Coluna){
        super("Parede3D.jpeg", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
    
}
