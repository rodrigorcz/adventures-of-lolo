
package Entities;

import Auxiliar.Posicao;

public abstract class Empurravel extends Personagem{
    public Empurravel(int Linha, int Coluna){
        super("", new Posicao(Linha, Coluna));
        this.ehEmpurravel = true;
    }
}
