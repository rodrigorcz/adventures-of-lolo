package Entities.Elements;

import Auxiliar.*;
import Entities.Elemento;

public class Coracao extends Elemento{
    public Coracao(int Linha, int Coluna){
        super("Coracao.png",new Posicao(Linha, Coluna));
        this.ehTransponivel = true;
        this.ehMortal = true;
        this.tipoElem = 1;
    }
}
