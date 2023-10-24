package Obstacles;

import Auxiliar.Posicao;
import Entities.Personagem;
import java.io.Serializable;

public class Porta extends Personagem implements Serializable {
    public Porta(int Linha, int Coluna) {
        super("Porta.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = true;
    }
}
