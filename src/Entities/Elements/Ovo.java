package Entities.Elements;

import Auxiliar.*;
import Entities.Inimigo;

public class Ovo extends Inimigo {
    public Ovo(int Linha, int Coluna) {
        super("ovo.png", new Posicao(Linha, Coluna));
        this.ehEmpurravel = true;
        this.ehMortal = false;
    }
}
