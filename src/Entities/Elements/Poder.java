/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Elements;

import Auxiliar.Desenho;
import Auxiliar.Posicao;
import Entities.Personagem;
import java.io.Serializable;

/**
 *
 * @author rodrigo
 */
public class Poder extends Personagem implements Serializable{
            
    public Poder() {
        super("fire.png", new Posicao(1, 1));
        this.ehMortal = true;
    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveRight())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    }
}
