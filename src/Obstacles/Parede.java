package Obstacles;

import Auxiliar.*;
import Entities.Elemento;

public class Parede extends Elemento{
    public Parede(int Linha, int Coluna, String nomeParede) {
        super(nomeParede, new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
}
