package Controler;

import Entities.Creature;
import Entities.Hero;
import Auxiliar.Position;
import java.util.ArrayList;

public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Creature> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public void processaTudo(ArrayList<Creature> umaFase){
        Hero hero = (Hero)umaFase.get(0);
        Creature pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            if(hero.getPosicao().igual(pIesimoPersonagem.getPosicao()))
                if(pIesimoPersonagem.isbTransponivel())
                    /*TO-DO: verificar se o personagem eh mortal antes de retirar*/                    
                    umaFase.remove(pIesimoPersonagem);
        }
    }
    
    /*Retorna true se a posicao p é válida para Hero com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(ArrayList<Creature> umaFase, Position p){
        Creature pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(!pIesimoPersonagem.isbTransponivel())
                if(pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
}
