/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Icons;

import Entities.Personagem;
import java.io.Serializable;
import Auxiliar.*;
/**
 *
 * @author rodrigo
 */
public class Icone extends Personagem implements Serializable{
    
    public Icone(int Linha, int Coluna, String Imagem){
        super(Imagem, new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
    }
    
}
