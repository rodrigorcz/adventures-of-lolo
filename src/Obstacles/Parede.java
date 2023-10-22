package Obstacles;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import Entities.Creature;
import java.awt.Graphics;
import java.io.Serializable;


public class Parede extends Creature implements Serializable{
    private int iContaIntervalos;   
  
    public Parede(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.iContaIntervalos = 0;
    }
}
