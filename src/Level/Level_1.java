package Level;

import java.util.ArrayList;
import java.util.List;
import Controler.Tela;
import Entities.Hero;
import Entities.Elemento;
import Auxiliar.Fase;
import Entities.Enemy.Minhoca;
import Entities.Enemy.Caveira;
import Entities.Enemy.ZigueZague;
import Obstacles.*;
import Entities.Lootable.Chest_1;
import Icons.Icone;

public class Level_1 extends Fase{
    
    @Override
    public void start(){
        super.createFase();
        super.start();
    }
    
    public void createEntities(){
        
        for(int i = 0; i <= 13; i++){
            this.addElement(new Parede(i,0));
        }
        for(int i = 1; i <=11;i++){
            this.addElement(new ParedeTopo(0,i));
        }
        
        for(int i = 0; i <= 13; i++){
            this.addElement(new Parede(i,12));
        }
        
        for(int i = 1; i <= 12; i++){
            this.addElement(new ParedeH(13,i));
        }
        
        for(int i = 1; i <= 11; i++){
            if(i == 6){
                this.addElement(new Porta(1, i));
            }else
                this.addElement(new Parede3D(1,i));
        }
        
        for(int i = 3; i <= 4; i++){
            for(int j = 3; j<= 4; j++){
                this.addElement(new Arbusto(i,j));
            }
        }
        
        for(int i = 2; i<= 3; i++){
            for(int j = 9; j<= 10; j++){
                this.addElement(new Arbusto(i,j));
            }
        }
        
        for(int i = 7; i <= 9; i++){
            this.addElement(new Grama(i,11));
        }
        
        for(int i = 9; i <= 10; i++){
            this.addElement(new Grama(i,10));
        }
        
        for(int i = 3; i <= 4; i++){
            this.addElement(new Feno(i,8));
        }
        
        for(int i = 4; i <= 5; i++){
            this.addElement(new Feno(i,9));
        }
        
       
        this.addElement(new Arbusto(5,1));
        this.addElement(new Arbusto(10,1));
        this.addElement(new Arbusto(10,2));
        this.addElement(new Arbusto(8,1));
        this.addElement(new Arbusto(9,1));
        this.addElement(new Arbusto(9,2));
        this.addElement(new Arbusto(12,6));
        this.addElement(new Arbusto(12,7));
        this.addElement(new Arbusto(12,10));
        this.addElement(new Arbusto(11,11));
        this.addElement(new Arbusto(12,11));
        this.addElement(new Arbusto(11,7));
        this.addElement(new Arbusto(10,7));
        
        this.addElement(new Feno(2,1));
        this.addElement(new Feno(4,1));
        this.addElement(new Feno(11,1));
        this.addElement(new Feno(12,1));
        this.addElement(new Feno(12,4));
        this.addElement(new Feno(12,5));
        this.addElement(new Feno(11,5));
        this.addElement(new Feno(11,6));
        this.addElement(new Feno(11,10));
        this.addElement(new Feno(10,11));
        this.addElement(new Minhoca(7,4));
        this.addElement(new Minhoca(7,8));
        
        for(int i = 0; i <= 13; i++){
            if(i!=2){
                this.addElement(new Icone(i,13, "Icons/TelaPreta.png"));
            }
            else{
                this.addElement(new Icone(i, 13, "Icons/IconLolo.png"));
                this.addElement(new Icone(i+1,13, "Icons/num2.png"));
                i++;
            }
        }
    }
}
