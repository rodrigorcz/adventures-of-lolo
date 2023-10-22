import Controler.*;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VideoGame v1 = new VideoGame();
                v1.startGame();
                
                /*
                try{
                    TimeUnit.SECONDS.sleep(5);
                }
                catch(InterruptedException e){
                    System.out.println("erro");
                }
                tTela.setVisible(false);
                Tela tTela1 = new Tela();
                tTela1.setVisible(true);
                tTela1.createBufferStrategy(3);
                tTela1.go();*/
            }
        });
    }
}

