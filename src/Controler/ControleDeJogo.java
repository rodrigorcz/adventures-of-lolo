package Controler;

import Entities.Elements.Coracao;
import Entities.Elements.BlocoEmpurravel;
import Entities.Elements.Ovo;
import Obstacles.*;
import Auxiliar.*;
import Entities.*;
import Entities.Elements.Poder;
import java.util.ArrayList;

public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Elemento> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public void processaTudo(ArrayList<Elemento> umaFase){
        Hero hero = (Hero)umaFase.get(0);
        Elemento pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            if(hero.getPosicao().igual(pIesimoPersonagem.getPosicao()))
                if(pIesimoPersonagem.ehTransponivel())
                    if(pIesimoPersonagem.ehMortal() != false)
                        umaFase.remove(pIesimoPersonagem);
        }
    }

    /*Retorna true se a posicao p é válida para Hero com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(ArrayList<Elemento> umaFase, Posicao p){
        Elemento pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(!pIesimoPersonagem.ehTransponivel())
                if(pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
    
    public boolean movimentoInimigo(ArrayList<Elemento> umaFase, Posicao p){
        Elemento pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(pIesimoPersonagem instanceof Coracao || pIesimoPersonagem instanceof BlocoEmpurravel || !pIesimoPersonagem.ehTransponivel())
                if(pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
    
    public boolean ehInimigo(ArrayList<Elemento> umaFase, Posicao p){
        Elemento pIesimoPersonagem;
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
