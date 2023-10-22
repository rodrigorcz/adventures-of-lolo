package Obstacle;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;


public class Parede extends Personagem implements Serializable{
    private int iContaIntervalos;   
  
    public Parede(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.iContaIntervalos = 0;
    }
}
