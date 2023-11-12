/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Level;

import Entities.Elements.Porta;
import Entities.Elements.Bau;
import Entities.Elements.Coracao;
import Entities.Enemy.Minhoca;
import Entities.Elements.Icone;
import Entities.Enemy.*;
import Obstacles.*;
import Auxiliar.*;
/**
 *
 * @author rodrigo
 */
public class Level_2 extends Fase{
    
    public Level_2(ObserverJogo Terminador){
        super(Terminador);
    }
    
    @Override
    public void start(){
        super.createFase();
        super.start();
        lolo.setPosicao(12,11);
    }
    public void createPassavel(){

    }
    public void createInteragivel(){
        //Coracao
        this.addElement(new Coracao(2,3));
        this.addElement(new Coracao(2,7));
        this.addElement(new Coracao(7,1));
        this.addElement(new Coracao(7,6));
        this.addElement(new Coracao(11,1));
        this.addElement(new Coracao(10,7));
        this.addElement(new Coracao(9,11));
        
        this.porta = new Porta(1,7,false);
        this.addElement(porta);
        
        this.bau = new Bau(2,1,false);
        this.addElement(bau);
                
        this.coracoes = 7;
    }
  
    public void createEntities(){
        //Paredes
        for(int i = 0; i <= 13; i++){
            this.addElement(new Parede(i,0,"Parede.png"));
        }
        for(int i = 1; i <=11;i++){
            this.addElement(new Parede(0,i,"paredeTopo.png"));
        }

        for(int i = 0; i <= 13; i++){
            this.addElement(new Parede(i,12,"Parede.png"));
        }

        for(int i = 1; i <= 12; i++){
            this.addElement(new Parede(13,i,"Parede.png"));
        }

        for(int i = 1; i <= 11; i++){
            if(i != 7)  
                this.addElement(new Parede(1,i,"Parede3D.png"));
        }

        //Arbustos
        this.addElement(new Arbusto(2,2));

        for(int j = 4; j <= 6; j++){
           this.addElement(new Arbusto(2,j));
        }
       
        this.addElement(new Arbusto(2,8));
        this.addElement(new Arbusto(7,3));
        this.addElement(new Arbusto(3,4));
        this.addElement(new Arbusto(3,6));
        this.addElement(new Arbusto(3,8));
        this.addElement(new Arbusto(5,8));
        this.addElement(new Arbusto(6,6));
        this.addElement(new Arbusto(6,2));
        this.addElement(new Arbusto(11,4));
        this.addElement(new Arbusto(11,6));
        this.addElement(new Arbusto(11,7));
        this.addElement(new Arbusto(8,1));
        this.addElement(new Arbusto(7,5));
        this.addElement(new Arbusto(7,7));
        this.addElement(new Arbusto(4,10));
        this.addElement(new Arbusto(5,10));
        this.addElement(new Arbusto(12,2));
        this.addElement(new Arbusto(10,8));
        this.addElement(new Arbusto(9,4));
        this.addElement(new Arbusto(9,7));
        this.addElement(new Arbusto(9,9));
        this.addElement(new Arbusto(9,10));
        this.addElement(new Arbusto(8,11));
        this.addElement(new Arbusto(11,10));
        this.addElement(new Arbusto(12,10));

        //Feno
        this.addElement(new Feno(4,2));
        this.addElement(new Feno(5,2));
        this.addElement(new Feno(5,4));
        this.addElement(new Feno(5,6));
        this.addElement(new Feno(6,1));
        this.addElement(new Feno(7,4));
        this.addElement(new Feno(7,9));
        this.addElement(new Feno(4,8));
        this.addElement(new Feno(3,10));
        this.addElement(new Feno(6,10));
        this.addElement(new Feno(12,1));
        this.addElement(new Feno(12,4));
        this.addElement(new Feno(11,2));
        this.addElement(new Feno(9,3));
        this.addElement(new Feno(9,5));
        this.addElement(new Feno(9,6));
        this.addElement(new Feno(9,8));
        this.addElement(new Feno(12,9));
        
        //Caveira
        this.addElement(new Caveira(7,8));
        this.addElement(new Caveira(4,5));
   
        //Mihnoca
        this.addElement(new Minhoca(8,5));
        
        for(int i = 0; i <= 13; i++){
            this.addElement(new Icone(i,13, "Icons/TelaPreta.png"));  
        }
        
        this.addElement(new Icone(1, 13, "Icons/IconLolo.png"));
        this.addElement(new Icone(5,13, "Icons/IconPoder.png"));
        
        this.addElement(new Icone(11, 13, "Icons/save.png"));
        this.addElement(new Icone(12, 13, "Icons/letraS.png"));
    }
}
