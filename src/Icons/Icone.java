package Icons;

import Entities.Elemento;
import Auxiliar.*;

public class Icone extends Elemento{
    public Icone(int Linha, int Coluna, String Imagem){
        super(Imagem, new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
    
}
