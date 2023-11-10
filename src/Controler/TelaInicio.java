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
    
    public TelaInicio(InterfaceFase Terminador){
        this.Terminador = Terminador;
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.stop();
            this.Terminador.terminaInicio();
        }
    }
    
    public void iniciarTela(){
        this.addMouseListener(this);
        this.addKeyListener(this);

        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "Inicio.png");
            JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newImage, 0, 0,this);
            }
        };

        this.setContentPane(imagePanel);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void start(){
        this.setVisible(true);
        this.createBufferStrategy(3);
        this.go();
        this.iniciarTela();
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
