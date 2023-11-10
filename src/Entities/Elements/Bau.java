package Entities.Elements;

import Auxiliar.*;
import Entities.Elemento;

public class Bau extends Elemento{
    private boolean estaAberto;
    
    public Bau(int Linha, int Coluna, boolean estaAberto){
        super("BauFechado.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = true;
        this.estaAberto = false;
    }
    
    public void abrirBau(){ 
        this.estaAberto = true;
        this.ehTransponivel = true;
    }
    
    public boolean bauAberto(){
        return estaAberto;
    }
    
    public void bauEstado(boolean aberto){
        this.estaAberto = aberto;
    }
}
