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
public class Feno extends Personagem implements Serializable{
    
    public Feno(int Linha, int Coluna){
        super("Feno.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
    
}
