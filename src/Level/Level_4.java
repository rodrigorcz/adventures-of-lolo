package Level;

import Entities.Enemy.Minhoca;
import Icons.Icone;
import Entities.Enemy.*;
import Obstacles.*;
import Auxiliar.*;

public class Level_4 extends Fase{
    
    public Level_4(InterfaceFase Terminador){
        super(Terminador);
    }
    
    @Override
    public void start(){
        super.createFase();
        super.start();
        lolo.setPosicao(12,11);
    }
    public void createPassavel(){
        for(int i = 3; i<11;i++){
            paintPassavel(i,11,"gramamorta.png");
        }
        for(int i = 2; i<11;i++){
            
            paintPassavel(12, i,"gramamorta.png");
        }
    }
    public void createInteragivel(){
        //Coracao
        this.addElement(new Coracao(7,6));
        this.addElement(new Coracao(12,6));
        this.addElement(new Coracao(7,11));

        
        this.porta = new Porta(1,3,false);
        this.addElement(porta);
        
        this.bau = new Bau(2,1,false);
        this.addElement(bau);
                
        this.coracoes = 3;
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
            if(i != 3)  
                this.addElement(new Parede(1,i,"Parede3D.png"));
        }

        this.addElement(new Arbusto(12,1));
        this.addElement(new Arbusto(2,11));
        
        for(int i = 0; i <= 13; i++){
            this.addElement(new Icone(i,13, "Icons/TelaPreta.png"));  
        }
        
        this.addElement(new BichoVerde(3,8));
        
        this.addElement(new Icone(2, 13, "Icons/IconLolo.png"));
        this.addElement(new Icone(3,13, "Icons/num5.png"));
        this.addElement(new Icone(6,13, "Icons/IconPoder.png"));
        this.addElement(new Icone(7,13, "Icons/num3.png"));

    }
}

