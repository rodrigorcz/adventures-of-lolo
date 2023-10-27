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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Minhoca extends Personagem  implements Serializable{
    private int delay;

    public Minhoca(int Linha, int Coluna) {
        super("minhocaD.png", new Posicao(Linha, Coluna));
        this.delay = 0;
        this.ehMortal = true;
        this.tipoElem = 2;
    }
    
    @Override
    public void autoDesenho(){
        if(delay < Consts.TIMER){
            this.setImage("minhocaE.png");
            delay++;
        }
        else if(delay < 2*Consts.TIMER){
            this.setImage("minhocaD.png"); 
            delay++;
        } else 
            delay = 0;
        
        super.autoDesenho();
    }
}
