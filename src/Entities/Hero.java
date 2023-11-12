package Entities;


import Auxiliar.*;
import Controler.ControleDeJogo;
import Controler.Sistema;
import Entities.Elements.Poder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hero extends Personagem{
    private int orientacao;
    private int direcao;
    public int vidas;
    public int poderes;
    
    public Hero(int Linha, int Coluna) {
        super("LoloBaixo.png", new Posicao(Linha, Coluna));
        this.vidas = 3;
        this.poderes = 0;
    }

    public void atirar(){
        Poder f = new Poder();
        this.orientacao = this.direcao;
        f.orientacaoPoder = orientacao;
        
        f.setPosicao(atualPosicao.getLinha(),atualPosicao.getColuna());
        
        Desenho.acessoATelaDoJogo().addElement(f); 
    }
    
    //Metodo voltados para movimentação do LOLO
    public boolean moveUp() {
        setImage("LoloCima.png");
        direcao = 3;
        if(super.moveUp())
            return validaPosicao();
        return false;
    }

    public boolean moveDown() {
        setImage("LoloBaixo.png");
        direcao = 1;
        if(super.moveDown())
            return validaPosicao();
        return false;
    }

    public boolean moveRight() {
        setImage("LoloDireita.png");
        direcao = 2;
        if(super.moveRight())
            return validaPosicao();
        return false;
    }

    public boolean moveLeft() {
        setImage("LoloEsquerda.png");
        direcao = 4;
        if(super.moveLeft())
            return validaPosicao();
        return false;
    }
    
    public int getDirecao(){
        return direcao;
    }
    
}
