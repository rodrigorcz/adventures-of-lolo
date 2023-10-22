package Entities.Elements;

import Auxiliar.Desenho;
import Controler.Tela;
import Entities.Creature;
import Entities.Creature;
import java.awt.Graphics;
import java.io.Serializable;

public class Fogo extends Creature implements Serializable{
            
    public Fogo(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveRight())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    }
    
}
