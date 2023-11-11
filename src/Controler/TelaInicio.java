package Controler;

import Auxiliar.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class TelaInicio extends Sistema{
    private Graphics g2;
    private InterfaceFase Terminador;
    private String[] imagens = {"Inicio.png", "comandos.png", "comandos.png", "comandos.png"};
    private int indice;
    
    public TelaInicio(InterfaceFase Terminador){
        this.Terminador = Terminador;
        this.indice = 0;
    }
    
    public void keyPressed(KeyEvent e) {
        if(this.indice == 1){
            System.out.println("Os comandos permaneceream na tela para te ajudar!!");
            this.Terminador.terminaInicio();
        }
        indice++;
        this.stop();
        this.start();
    }
    
    
    public void iniciarTela(String imagem){
        this.addMouseListener(this);
        this.addKeyListener(this);

        this.setSize(Consts.RES * Consts.CELL_SIDE ,
                Consts.RES * Consts.CELL_SIDE );
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + imagem);
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
        this.go();
        this.iniciarTela(imagens[indice]);
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
