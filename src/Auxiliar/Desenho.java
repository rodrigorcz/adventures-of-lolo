package Auxiliar;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class Desenho implements Serializable {
    static Fase cenarioAtual;
    
    public static void setCenario(Fase umCenario) {
        cenarioAtual = umCenario;
    }

    public static Fase acessoATelaDoJogo() {
        return cenarioAtual;
    }

    public static Graphics getGraphicsDaTela() {
        return cenarioAtual.getGraphicsBuffer();
    }
    
    public static void desenhar(ImageIcon iImage, int iColuna, int iLinha) {
        iImage.paintIcon(cenarioAtual, getGraphicsDaTela() ,iColuna * Constantes.CELL_SIDE, iLinha * Constantes.CELL_SIDE);
    }
}
