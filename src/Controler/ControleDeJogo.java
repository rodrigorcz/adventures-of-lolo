package Controler;

import Entities.Elements.Coracao;
import Entities.Elements.Ovo;
import Obstacles.*;
import Auxiliar.*;
import Entities.*;
import Entities.Elements.*;
import java.util.ArrayList;
import java.util.List;

public class ControleDeJogo {
    
    //Desenha todos os elementos
    public void desenhaTudo(ArrayList<Elemento> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    
    //Verifica se a posicao que o elemento esta é valida
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
    
    //Verifica se a posicao do tiro é valida
    public boolean ehPosicaoValidaTiro(ArrayList<Elemento> umaFase, Posicao p){
        Elemento pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(!pIesimoPersonagem.ehTransponivel()|| pIesimoPersonagem instanceof Inimigo)
                if(pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
    
    //Verifica se a posicao que o inimigo esta é valida
    public boolean movimentoInimigo(ArrayList<Elemento> umaFase, Posicao p){
        Elemento pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(pIesimoPersonagem instanceof Coracao || 
                    pIesimoPersonagem instanceof Empurravel||
                    pIesimoPersonagem instanceof Bau||
                    !pIesimoPersonagem.ehTransponivel())
                if(pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }

    //Tranforma os inimigos em Ovo
    public boolean transformaInimigo(ArrayList<Elemento> umaFase, Posicao p){
        Elemento pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(pIesimoPersonagem instanceof Inimigo || pIesimoPersonagem instanceof Ovo)
                if(pIesimoPersonagem.getPosicao().igual(p)){
                    if(pIesimoPersonagem instanceof Ovo){
                        umaFase.remove(pIesimoPersonagem);
                        return true;
                    }
                    Ovo o = new Ovo(pIesimoPersonagem.getPosicao().getLinha(),pIesimoPersonagem.getPosicao().getColuna(), pIesimoPersonagem.getTipo());
                    umaFase.remove(pIesimoPersonagem);
                    umaFase.add(o);
                    return true;
                }
        } 
        return false;
    }
    
    //Mecanica de empurrar os blocos
    public void verificaEmpurrar(ArrayList<Elemento> Elements){
        if(!Elements.isEmpty()){
            Hero lolo = (Hero)Elements.get(0);

            List<Empurravel> listaEmpurravel = Elements.stream().filter(elem -> elem instanceof Empurravel).map(elem -> (Empurravel) elem).toList();
            ArrayList<Empurravel> empurravel = new ArrayList(listaEmpurravel);
            Empurravel temp;
            for(int i = 0; i < empurravel.size(); i++){
                temp = empurravel.get(i);
                if(lolo.getPosicao().igual(temp.getPosicao())){
                    switch(lolo.getDirecao()){
                        case 1:
                            temp.moveDown();
                            break;
                        case 2:
                            temp.moveRight();
                            break;
                        case 3:
                            temp.moveUp();
                            break;
                        case 4:
                            temp.moveLeft();
                            break;
                    }
                    if(!posicaoValidaBloco(temp, Elements)){
                        temp.voltaAUltimaPosicao();
                        lolo.voltaAUltimaPosicao();
                    }
                }
            }
        }
    }
   
    public boolean posicaoValidaBloco(Elemento p, ArrayList<Elemento> Elements){
        Elemento pTemp;
        if(p instanceof Hero){
            for(int i = 0; i < Elements.size(); i++){
                pTemp = Elements.get(i);
                if(!pTemp.ehTransponivel() && p != pTemp){
                    if(pTemp.getPosicao().igual(p.getPosicao())){
                        return false;
                    }
                }
            }
        }
        else if(p instanceof Empurravel || p instanceof Inimigo){
            for(int i = 0; i < Elements.size(); i++){
                pTemp = Elements.get(i);
                if((!pTemp.ehTransponivel() || pTemp instanceof Bau || pTemp instanceof Empurravel || pTemp instanceof Coracao) && p != pTemp){
                    if(pTemp.getPosicao().igual(p.getPosicao())){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
