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
public class PortaFechada extends Personagem implements Serializable{
    
    public PortaFechada(int Linha, int Coluna){
        super("portaFechada.jpeg", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
}
