package Entities.Elements;

import Auxiliar.*;
import Entities.*;

public class BlocoEmpurravel extends Personagem{
    public BlocoEmpurravel(int Linha, int Coluna){
        super("bloco_empurravel.png", new Posicao(Linha, Coluna));
        this.ehEmpurravel = true;
        this.ehMortal = false;
    }
}
