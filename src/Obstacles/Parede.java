package Obstacles;

import Auxiliar.*;
import Controler.Tela;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;


public class Parede extends Personagem implements Serializable{
    
    public Parede(int Linha, int Coluna) {
        super("Parede.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;

    }
}
