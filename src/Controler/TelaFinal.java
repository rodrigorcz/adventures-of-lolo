package Controler;

import Auxiliar.Constantes;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import Auxiliar.ObserverJogo;

// Ultima tela que sera apresentada, com base na vitoria ou derrota
public class TelaFinal extends Sistema{
    private Graphics g2;
    private ObserverJogo Terminador;
    private String[] imagens = {"fimTela.png","venceuTela.png", ""};
    private int indice;
    public boolean usuarioPerdeu;
    
    public TelaFinal(ObserverJogo Terminador, boolean usuarioPerdeu){
        this.Terminador = Terminador;
        this.usuarioPerdeu = usuarioPerdeu;
        this.indice = 0;
    }
    
    public void setVenceu(boolean info){
        usuarioPerdeu = info;
    }
    
    public void keyPressed(KeyEvent e) {
        if(indice >= 2){
            this.stop();
            this.Terminador.terminaFim();
        }
        indice++;
    }
    
    public void terminarTela(boolean i){
        this.addMouseListener(this);
        this.addKeyListener(this);
        
        usuarioPerdeu = i;
        if(usuarioPerdeu){
            indice = 1;
        }
        
        this.setSize(Constantes.RES * Constantes.CELL_SIDE + getInsets().left + getInsets().right, Constantes.RES * Constantes.CELL_SIDE + getInsets().top + getInsets().bottom);

        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Constantes.PATH + imagens[indice]);
            JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(newImage, 0, 0,this);
            }
        };

        this.setContentPane(imagePanel);
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void start(boolean i){
        this.setVisible(true);
        this.createBufferStrategy(3);
        this.go();
        this.terminarTela(i);
    }
    
    public void stop() {
        this.setVisible(false);
        this.cancelar();
    }
                             
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Tela Final");
        setAlwaysOnTop(true);
        setAutoRequestFocus(true);
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
    }
}
