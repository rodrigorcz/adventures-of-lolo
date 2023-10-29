package Entities;


import Auxiliar.*;
import Controler.ControleDeJogo;
import Controler.Tela;
import Entities.Elements.Poder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hero extends Personagem implements Serializable{
    private int delay;
    private int orientacao;
    private int direcao;
    
    public Hero(int Linha, int Coluna) {
        super("LoloBaixo.png", new Posicao(Linha, Coluna));
        this.delay = 0;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    
    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;       
    }

    /*TO-DO: este metodo pode ser interessante a todos os personagens que se movem*/
    private boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    
    public void atirar(){
        Poder f = new Poder();
        this.orientacao = pPosicao.getOrientacao();
        f.orientacaoPoder = orientacao;
        
        if(orientacao == 1)
           f.setPosicao(pPosicao.getLinha()+1,pPosicao.getColuna());
        if(orientacao == 2)
            f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
        if(orientacao == 3)
            f.setPosicao(pPosicao.getLinha()-1,pPosicao.getColuna());
        if(orientacao == 4)
            f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()-1);
        
        Desenho.acessoATelaDoJogo().addElement(f); 
    }
    
    public boolean moveUp() {
        direcao = 0;
        if(super.moveUp())
            return validaPosicao();
        return false;
    }

    public boolean moveDown() {
        direcao = 1;
        if(super.moveDown())
            return validaPosicao();
        return false;
    }

    public boolean moveRight() {
        direcao = 2;
        if(super.moveRight())
            return validaPosicao();
        return false;
    }

    public boolean moveLeft() {
        direcao = 3;
        if(super.moveLeft())
            return validaPosicao();
        return false;
    }
    
    public int getDirecao(){
        return direcao;
    }
    
}
