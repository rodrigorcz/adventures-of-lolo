package Controler;

import Auxiliar.Desenho;
import Entities.Personagem;
import Entities.Hero;
import Entities.Elements.Poder;
import Auxiliar.Posicao;
import java.util.ArrayList;
import Obstacles.*;

public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Personagem> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public void processaTudo(ArrayList<Personagem> umaFase){
        Hero hero = (Hero)umaFase.get(0);
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            if(hero.getPosicao().igual(pIesimoPersonagem.getPosicao()))
                if(pIesimoPersonagem.isbTransponivel())
                    if(pIesimoPersonagem.isbMortal() != false)
                        umaFase.remove(pIesimoPersonagem);
                  
        }
    }

    /*Retorna true se a posicao p é válida para Hero com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p){
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(!pIesimoPersonagem.isbTransponivel())
                if(pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
    
    public boolean ehInimigo(ArrayList<Personagem> umaFase, Posicao p){
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(pIesimoPersonagem.getTipo() == 2 || pIesimoPersonagem instanceof Ovo)
                if(pIesimoPersonagem.getPosicao().igual(p)){
                    if(pIesimoPersonagem instanceof Ovo){
                        umaFase.remove(pIesimoPersonagem);
                        return true;
                    }
                    Ovo o = new Ovo(pIesimoPersonagem.getPosicao().getLinha(),pIesimoPersonagem.getPosicao().getColuna());
                    umaFase.remove(pIesimoPersonagem);
                    umaFase.add(o);
                    return true;
                }
        } 
        return false;
    }
}
