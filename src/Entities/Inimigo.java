package Entities;

import Auxiliar.*;
import Controler.Sistema;

//Imports Externos
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 *  Inimigo é um Personagem com movimentação específica e tipo = 2
 * 
 */

public class Inimigo extends Personagem{
    public Inimigo(String nomeImagem, Posicao posicao){
        super(nomeImagem, posicao);
        this.ehTransponivel = true;
        this.ehMortal = false;
        this.tipoElem = 2;
    }

    @Override
    public boolean setPosicao(int linha, int coluna){
        if(this.atualPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().movimentoInimigo(this.getPosicao())) {
                this.voltaAUltimaPosicao();
                return false;
            } 
            return true;
        }
        return false;       
    }
    
    @Override
    public boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().movimentoInimigo(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }

}
