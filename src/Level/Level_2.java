/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Level;

import Entities.Enemy.Minhoca;
import Icons.Icone;
import Entities.Enemy.*;
import Obstacles.*;
import Auxiliar.*;
/**
 *
 * @author rodrigo
 */
public class Level_2 extends Fase{
    
    public Level_2(InterfaceFase Terminador){
        super(Terminador);
        this.createEntities();
    }
    @Override
    public void start(){
        super.createFase();
        super.start();
    }
    
    public void createEntities(){
        
        //Coracao
        this.addElement(new Coracao(2,3));
        this.addElement(new Coracao(2,7));
        this.addElement(new Coracao(7,1));
        this.addElement(new Coracao(7,6));

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
            if(i == 7){
                this.addElement(new Porta(1, i));
            }else
                this.addElement(new Parede(1,i,"Parede3D.png"));
        }

        this.addElement(new Bau(2,1,"BauFechado.png"));

        //Arbustos
        this.addElement(new Arbusto(2,2));

        for(int j = 4; j <= 6; j++){
           this.addElement(new Arbusto(2,j));
        }
       
        this.addElement(new Arbusto(2,8));
        this.addElement(new Arbusto(3,4));
        this.addElement(new Arbusto(3,6));
        this.addElement(new Arbusto(3,8));
        this.addElement(new Arbusto(5,8));
        this.addElement(new Arbusto(6,6));
        this.addElement(new Arbusto(6,4));
        this.addElement(new Arbusto(8,1));
        this.addElement(new Arbusto(7,3));
        this.addElement(new Arbusto(7,5));
        this.addElement(new Arbusto(7,7));
        this.addElement(new Arbusto(4,10));
        this.addElement(new Arbusto(5,10));

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
        
        
        //Caveira
        this.addElement(new Caveira(7,8));
        this.addElement(new Caveira(4,5));
        
        for(int i = 0; i <= 13; i++){
            if(i!=2){
                this.addElement(new Icone(i,13, "Icons/TelaPreta.png"));
            }
            else{
                this.addElement(new Icone(i, 13, "Icons/IconLolo.png"));
                this.addElement(new Icone(i+1,13, "Icons/num5.png"));
                i++;
            }
        }
        
        this.addElement(new Icone(6,13, "Icons/IconPoder.png"));
        this.addElement(new Icone(7,13, "Icons/num3.png"));
    }
}
