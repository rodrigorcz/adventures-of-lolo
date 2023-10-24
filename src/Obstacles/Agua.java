package Obstacles;

import Auxiliar.Posicao;
import Entities.Personagem;
import java.io.Serializable;


public class Agua extends Personagem implements Serializable{
    private boolean aux;

    public Agua(int Linha, int Coluna){
        super("Agua1.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
        this.aux = true;
    }
    
    @Override
    public void autoDesenho(){
        if(aux)
            this.setImage("Agua2.png");
        else
            this.setImage("Agua1.png");           

        super.autoDesenho();
        aux = !aux;
    }
}
