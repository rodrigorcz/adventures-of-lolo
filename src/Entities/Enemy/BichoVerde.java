package Entities.Enemy;

import Auxiliar.*;
import Entities.Personagem;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;

public class BichoVerde extends Personagem  implements Serializable{
    public BichoVerde(int Linha, int Coluna) {
        super("bichoVerde.png", new Posicao(Linha, Coluna));
        this.ehTransponivel = false;
        this.ehMortal = true;
        this.tipoElem = 2;
    }
}
