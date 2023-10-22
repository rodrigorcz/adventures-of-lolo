package Entities.Elements;

import Auxiliar.Desenho;
import Controler.Tela;
import Entities.Entidade;
import Entities.Personagem;
import java.awt.Graphics;
import java.io.Serializable;

public class Fogo extends Entidade implements Serializable{
            
    public Fogo(String sNomeImagePNG) {
        super("fire.png");
        this.bMortal = true;
    }
    /*
    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveRight())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    }*/
    
}
