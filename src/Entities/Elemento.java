package Entities;

import Auxiliar.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;


public abstract class Elemento implements Serializable {

    protected ImageIcon iImage;
    protected Posicao atualPosicao;
    protected boolean ehTransponivel; 
    protected boolean ehEmpurravel;
    protected boolean ehMortal;
    protected int tipoElem;

    //Construtor do Elemento
    protected Elemento(String nomeImagem, Posicao posicaoInicial) {
        this.atualPosicao = posicaoInicial;
        this.ehTransponivel = false;
        this.ehEmpurravel = false;
        this.ehMortal = false;
        this.tipoElem = 0;
        setImage(nomeImagem);
    }
    
    //Função para mudar a Imagem do Elemento
    public void setImage(String newImg){
            try {
                iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Constantes.PATH + newImg);
                iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Constantes.PATH + newImg);Image img = iImage.getImage();
                BufferedImage bi = new BufferedImage(Constantes.CELL_SIDE, Constantes.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                g.drawImage(img, 0, 0, Constantes.CELL_SIDE, Constantes.CELL_SIDE, null);
                iImage = new ImageIcon(bi);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }

    //----------------Funções auxiliares--------------------
    public void autoDesenho(){
        Desenho.desenhar(this.iImage, this.atualPosicao.getColuna(), this.atualPosicao.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        return atualPosicao.setPosicao(linha, coluna);
    }

    //-----------------Gets & Sets--------------------------
    public int getTipo(){
        return tipoElem;
    }

    public Posicao getPosicao() {
        return atualPosicao;
    }

    public boolean ehTransponivel() {
        return ehTransponivel;
    }

    public void setTransponivel(boolean ehTransponivel) {
        this.ehTransponivel = ehTransponivel;
    }

    //--------------Movimentação------------------------
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
