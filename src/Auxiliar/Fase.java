package Auxiliar;

import Entities.Personagem;
import Entities.Enemy.Caveira;
import Entities.Hero;
import Entities.Elemento;
import Controler.Tela;
import Auxiliar.Consts;
import Entities.Enemy.BichinhoVaiVemHorizontal;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Entities.Enemy.ZigueZague;
import Obstacles.Parede;
import Auxiliar.Posicao;
import Controler.ControleDeJogo;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.JButton;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class Fase extends Tela{
    public Hero lolo;
    protected ArrayList<Personagem> Elements;
    private ControleDeJogo cj = new ControleDeJogo();
    private Graphics g2;
    
    public Fase(){
        this.Elements = new ArrayList<>(195);
        
        lolo = new Hero(0,7);
        this.addElement(lolo);
    }
    
    public void start(){
        this.setVisible(true);
        this.createBufferStrategy(2);
        Desenho.setCenario(this);
        this.go();
    }
    
    public void addElement(Personagem e1){
        this.Elements.add(e1);
    } 
    
    public void createFase(){
        initComponents();
        createEntities();
        
        this.addMouseListener(this);
        this.addKeyListener(this);
        
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        Desenho.setCenario(this);
    }
    
    public abstract void createEntities();
          
    public boolean ehPosicaoValida(Posicao p){
        return cj.ehPosicaoValida(this.Elements, p);
    }
    
    public void removePersonagem(Personagem e1) {
        Elements.remove(e1);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        
        /*************Desenha cenário de fundo**************/
        
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "brick.png");
                    g2.drawImage(newImage,
                            j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (!this.Elements.isEmpty()) {
            this.cj.desenhaTudo(Elements);
            this.cj.processaTudo(Elements);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }
    

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            this.Elements.clear();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            lolo.moveUp();
            lolo.setImage("LoloCima.png");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            lolo.moveDown();
            lolo.setImage("LoloBaixo.png");
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            lolo.moveLeft();
            lolo.setImage("LoloEsquerda.png");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            lolo.setImage("LoloDireita.png");
            lolo.moveRight();
        }

        this.setTitle("-> Cell: " + (lolo.getPosicao().getColuna()) + ", "
                + (lolo.getPosicao().getLinha()));

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.lolo.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }
    
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
    // Variables declaration - do not modify                     
    // End of variables declaration                   

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
