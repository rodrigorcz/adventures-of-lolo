/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Obstacles;


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

public class Ovo extends Personagem implements Serializable{
    public Ovo(int Linha, int Coluna) {
        super("ovo.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
        this.ehMortal = false;
    }
    
}
