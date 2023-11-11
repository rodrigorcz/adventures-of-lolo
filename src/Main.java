import Controler.*;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Comandos:\n"
        + "Aperte S para salvar o jogo.\n"
        + "Aperte E para carregar o jogo salvo.\n"
        + "Aperte Z para lançar para atirar o poder\n"
        + "Aperte R para reiniciar a fase atual\n");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VideoGame v1 = new VideoGame();
                v1.iniciarTela();
                //v1.startGame();
            }
        });
    }
}

