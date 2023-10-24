package Entities.Enemy;

import Auxiliar.*;
import Controler.Tela;
import Entities.Elements.Fogo;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;

public class Caveira extends Personagem implements Serializable{
    private int iContaIntervalos;
    private int linha;
    private int coluna;
    
    public Caveira(int Linha, int Coluna) {
        super("caveira.png", new Posicao(Linha, Coluna));
        this.linha = Linha;
        this.coluna = Coluna;
        this.ehTransponivel = false;
        this.iContaIntervalos = 0;
    }
    
    
    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER){
            this.iContaIntervalos = 0;
            Fogo f = new Fogo();
            f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
            Desenho.acessoATelaDoJogo().addElement(f);
        }
    }    
}