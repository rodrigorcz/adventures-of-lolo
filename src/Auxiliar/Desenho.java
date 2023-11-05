package Auxiliar;

import Auxiliar.Fase;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;
import Controler.Sistema;

public class Desenho implements Serializable {
    static Fase jCenario;
    public static void setCenario(Fase umJCenario) {
        jCenario = umJCenario;
    }

    public static Fase acessoATelaDoJogo() {
        return jCenario;
    }

    public static Graphics getGraphicsDaTela() {
        return jCenario.getGraphicsBuffer();
    }
    
    public static void desenhar(ImageIcon iImage, int iColuna, int iLinha) {
        iImage.paintIcon(jCenario,getGraphicsDaTela(),iColuna * Consts.CELL_SIDE, iLinha * Consts.CELL_SIDE);
    }
}
