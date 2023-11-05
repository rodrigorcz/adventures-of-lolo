package Entities.Elements;

import Auxiliar.Posicao;
import Entities.Elemento;

public class Porta extends Elemento{
    private boolean estaAberta;
    
    public Porta(int Linha, int Coluna, boolean estaAberta) {
        super("Porta.png", new Posicao(Linha, Coluna));
        this.estaAberta = estaAberta;
    }
    
    public void abrirPorta(){
        this.estaAberta = true;
        this.ehTransponivel = true;
    }
}
