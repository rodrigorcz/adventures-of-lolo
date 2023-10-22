package Entities.Enemy;

import Auxiliar.*;
import Entities.Personagem;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BichinhoVaiVemHorizontal extends Personagem  implements Serializable{
    private boolean bRight;

    public BichinhoVaiVemHorizontal(int Linha, int Coluna) {
        super("roboPink.png", new Posicao(Linha, Coluna));
        bRight = true;
    }
    
    public void autoDesenho(){
        if(bRight)
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
        else
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);           

        super.autoDesenho();
        bRight = !bRight;
    }
}
