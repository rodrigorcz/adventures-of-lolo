package Entities;

import java.io.Serializable;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import Auxiliar.Position;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Entity implements Serializable {
    protected ImageIcon iImage;
    protected Position startPosition;
    protected boolean itsPassable;

    protected Entity(String sNomeImagePNG, Position startPosition, boolean itsPassable) {
        this.startPosition = startPosition;
        this.itsPassable = itsPassable;
        
        /* Set Image */
        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);   
            
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
        public Position getPosicao() {
        /*TODO: Retirar este método para que objetos externos nao possam operar
         diretamente sobre a posição do Personagem*/
        return startPosition;
    }

    public boolean isbTransponivel() {
        return itsPassable;
    }

    public void setbTransponivel(boolean Transponivel) {
        this.itsPassable = Transponivel;
    }

    public void autoDesenho(){
        Desenho.desenhar(this.iImage, this.startPosition.getColuna(), this.startPosition.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        return startPosition.setPosicao(linha, coluna);
    }

    public boolean moveUp() {
        return this.startPosition.moveUp();
    }

    public boolean moveDown() {
        return this.startPosition.moveDown();
    }

    public boolean moveRight() {
        return this.startPosition.moveRight();
    }

    public boolean moveLeft() {
        return this.startPosition.moveLeft();
    }
    
 
}
