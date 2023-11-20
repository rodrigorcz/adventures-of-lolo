import Controler.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Avisos:\n"
        + "Para um melhor desempenho talvez seja interessante deixar o jogo em tela cheia\n");
        
        System.out.println("Comandos:\n"
        + "Aperte S para salvar o jogo.\n"
        + "Aperte E para carregar o jogo salvo.\n"
        + "Aperte Z para atirar o poder.\n"
        + "Aperte R para reiniciar a fase atual.\n"
        + "Caso a fase apresente algum erro, aperte P para pular de fase.\n"
        + "Ou use o mouse para se locomover (Apenas se houver erros).\n");
        
        System.out.println("Instruções:\n"
        + "Pegue todos os corações e corra para o bau.\n"
        + "Apos pegar o bau os monstros morrerao.\n"
        + "O jogo possui 6 niveis."
        + "Em cada nível você tem 3 vidas\n"
        + "Boa Sorte!\n");
        
        System.out.println("Feito por:\n"
                + "Rodrigo Rodrigues de Castro - 13695362\n"
                + "Marcus Vinicius da Silva - 13833150\n");
        //Iniciar o jogo
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VideoGame v1 = new VideoGame();
                v1.iniciarTela();
            }
        });
    }
}

