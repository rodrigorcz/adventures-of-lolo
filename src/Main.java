import Controler.*;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VideoGame v1 = new VideoGame();
                //v1.iniciarTela();
                v1.startGame();
            }
        });
    }
}

