package Entities.Elements;

import Auxiliar.*;
import Entities.Personagem;

public class Ovo extends Personagem {
    public Ovo(int Linha, int Coluna) {
        super("ovo.png", new Posicao(Linha, Coluna));
        this.ehEmpurravel = true;
        this.ehMortal = false;
    }
}
