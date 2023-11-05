package Obstacles;

import Auxiliar.*;
import Entities.Elemento;

public class Arbusto extends Elemento{
    public Arbusto(int Linha, int Coluna){
        super("arbusto.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
}
