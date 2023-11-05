package Entities;

import Auxiliar.*;
import Controler.Tela;

//Imports Externos
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Elemento implements Serializable {

    protected ImageIcon iImage;
    protected Posicao atualPosicao;
    protected boolean ehTransponivel; 
    protected boolean ehMortal;
    protected boolean ehEmpurravel;
    protected int tipoElem;

    //Construtor do Elemento
    protected Elemento(String nomeImagem, Posicao posicaoInicial) {
        this.atualPosicao = posicaoInicial;
        this.ehTransponivel = false;
        this.ehMortal = false;
        this.ehEmpurravel = false;
        this.tipoElem = 0;
        setImage(nomeImagem);
    }
    
    //Função para mudar a Imagem do Elemento
    public void setImage(String newImg){
            try {
                iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + newImg);
                iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + newImg);Image img = iImage.getImage();
                BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                iImage = new ImageIcon(bi);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }

    //Funções auxiliares
    public void autoDesenho(){
        Desenho.desenhar(this.iImage, this.atualPosicao.getColuna(), this.atualPosicao.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        return atualPosicao.setPosicao(linha, coluna);
    }

    // Gets & Sets
    public int getTipo(){
        return tipoElem;
    }

    public Posicao getPosicao() {
        return atualPosicao;
    }

    public boolean ehTransponivel() {
        return ehTransponivel;
    }

    public boolean ehMortal(){
        return ehMortal;
    }

    public void setTransponivel(boolean ehTransponivel) {
        this.ehTransponivel = ehTransponivel;
    }

    //Movimentação 
    public boolean moveUp() {
        return this.atualPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.atualPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.atualPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.atualPosicao.moveLeft();
    }
}
