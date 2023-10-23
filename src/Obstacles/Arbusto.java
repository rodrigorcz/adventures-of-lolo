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
public class Arbusto extends Personagem implements Serializable{
    
    public Arbusto(int Linha, int Coluna){
        super("arbusto.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
    
}
