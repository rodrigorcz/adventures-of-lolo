package Controler;

import Auxiliar.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

// Primeiras telas que serao apresentadas

public class TelaInicio extends Sistema{
    private Graphics g2;
    private ObserverJogo Terminador;
    private String[] imagens = {"Inicio.png", "comandos.png"};
    private int indice;
    private boolean receberEntradas = true;
    
    public TelaInicio(ObserverJogo Terminador){
        this.Terminador = Terminador;
        this.indice = 0;
    }
    
    public void proxImagem(){
        if(indice++ == 1){
            this.stop();
            this.Terminador.terminaInicio();
            return;
        }
        this.stop();
        this.start();
    }

    public void keyPressed(KeyEvent e) {
        if(indice < 2){
            proxImagem();
        }
    }
    
    
    public void iniciarTela(String imagem){
        this.addMouseListener(this);
        this.addKeyListener(this);

        this.setSize(Constantes.RES * Constantes.CELL_SIDE + getInsets().left + getInsets().right, Constantes.RES * Constantes.CELL_SIDE + getInsets().top + getInsets().bottom);

        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Constantes.PATH + imagem);
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
    
    public void mudarTela(){
        
    }
    public void start(){
        this.setVisible(true);
        this.createBufferStrategy(3);
        
        this.iniciarTela(imagens[indice]);
        this.go();
        
    }
    
    public void stop() {
        this.setVisible(false);
        this.cancelar();
    }
                             
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Tela Inicial");
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
