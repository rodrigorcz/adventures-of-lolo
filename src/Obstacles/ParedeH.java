package Obstacles;

import Auxiliar.*;
import Controler.Tela;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;


public class ParedeH extends Personagem implements Serializable{
    
    public ParedeH(int Linha, int Coluna) {
        super("ParedeCimaH.jpeg", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;

    }
}
