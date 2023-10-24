package Obstacles;

import Auxiliar.Posicao;
import Entities.Personagem;
import java.io.Serializable;

public class Porta extends Personagem implements Serializable {
    private boolean estaAberta;
    
    public Porta(int Linha, int Coluna, boolean estaFechada) {
        super("Porta.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
        this.estaAberta = estaFechada;
    }
    
    public void abrirPorta(){
        this.estaAberta = true;
        this.ehTransponivel = true;
    }
    
}
