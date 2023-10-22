import Controler.Tela;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela tTela = new Tela();
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
           
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

