package Obstacles;

import Auxiliar.*;
import Controler.Tela;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;

public class Bau extends Personagem implements Serializable{
    private boolean estaAberto;
    
    public Bau(int Linha, int Coluna, boolean estaAberto){
        super("BauFechado.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
        this.estaAberto = false;
    }
    
    public void abrirBau(){ 
        this.estaAberto = true;
        this.ehTransponivel = true;
    }
}
