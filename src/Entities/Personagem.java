package Entities;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Auxiliar.Posicao;
import Controler.Tela;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Personagem implements Serializable {

    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected boolean ehTransponivel; /*Pode passar por cima?*/
    protected boolean ehMortal;       /*Se encostar, morre?*/
    protected boolean ehEmpurravel;
    protected int tipoElem;

    protected Personagem(String sNomeImagePNG, Posicao pPosicao) {
        this.pPosicao = pPosicao;
        this.ehTransponivel = true;
        this.ehMortal = false;
        this.ehEmpurravel = true;
        setImage(sNomeImagePNG);
        this.tipoElem = 0;
    }

    public Posicao getPosicao() {
        /*TODO: Retirar este método para que objetos externos nao possam operar
         diretamente sobre a posição do Personagem*/
        return pPosicao;
    }

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
    public boolean isbTransponivel() {
        return ehTransponivel;
    }
    
    public boolean ehEmpurravel(){
        return ehEmpurravel;
    }
    
    public int getTipo(){
        return tipoElem;
    }
    
    public boolean isbMortal(){
        return ehMortal;
    }

    public void setbTransponivel(boolean ehTransponivel) {
        this.ehTransponivel = ehTransponivel;
    }

    public void autoDesenho(){
        Desenho.desenhar(this.iImage, this.pPosicao.getColuna(), this.pPosicao.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }
    
    public boolean seMove(){
        return (new Random().nextInt(0, 99) >= 90);
    }
}
