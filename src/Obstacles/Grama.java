package Obstacles;

import Auxiliar.*;
import Entities.Elemento;

public class Grama extends Elemento{
    public Grama(int Linha, int Coluna){
        super("gramanovo.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = true;
    }
}
