/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Auxiliar.Consts;
import Auxiliar.InterfaceFase;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author rodrigo
 */
public class TelaFinal extends Sistema{
    private Graphics g2;
    private InterfaceFase Terminador;
    private String[] imagens = {"fimTela.png","venceuTela.png", ""};
    private int indice;
    public boolean usuarioPerdeu;
    
    public TelaFinal(InterfaceFase Terminador, boolean usuarioPerdeu){
        this.Terminador = Terminador;
        this.usuarioPerdeu = usuarioPerdeu;
        this.indice = 0;
    }
    
    public void setVenceu(boolean info){
        usuarioPerdeu = info;
    }
    
    public void keyPressed(KeyEvent e) {
        this.stop();
        this.Terminador.terminaFim();
    }
    
    public void terminarTela(boolean i){
        this.addMouseListener(this);
        this.addKeyListener(this);
        
        usuarioPerdeu = i;
        if(usuarioPerdeu){
            indice = 1;
        }
        
        this.setSize(Consts.RES * Consts.CELL_SIDE ,
                Consts.RES * Consts.CELL_SIDE );
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + imagens[indice]);
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