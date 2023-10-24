/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Level;

import Entities.Enemy.Minhoca;
import Icons.Icone;
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
            if(i == 6){
                this.addElement(new Porta(1, i));
            }else
                this.addElement(new Parede(1,i,"Parede3D.png"));
        }
        
       
        
        for(int i = 4; i <= 5; i++){
            this.addElement(new Feno(i,9));
        }
   
        this.addElement(new BauFechado(4,6));

        this.addElement(new Coracao(3,1));
        this.addElement(new Coracao(2,8));
        this.addElement(new Coracao(2,11));

      
        
        this.addElement(new Feno(2,1));
        this.addElement(new Feno(4,1));
        this.addElement(new Feno(11,1));
        
        this.addElement(new Feno(11,5));
        this.addElement(new Feno(11,6));
        this.addElement(new Feno(11,10));
        this.addElement(new Feno(10,11));
      
        this.addElement(new Minhoca(7,4));
        this.addElement(new Minhoca(7,8));
        this.addElement(new Minhoca(3,2));
        
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
