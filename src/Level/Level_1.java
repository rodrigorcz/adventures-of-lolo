package Level;

import java.util.ArrayList;
import java.util.List;
import Controler.Tela;
import Entities.Hero;
import Entities.Elemento;
import Auxiliar.Fase;
import Auxiliar.InterfaceFase;
import Entities.Enemy.Minhoca;
import Entities.Enemy.Caveira;
import Entities.Enemy.ZigueZague;
import Obstacles.*;
import Controler.ControleDeJogo;
import Icons.Icone;

public class Level_1 extends Fase{
    
    public Level_1(InterfaceFase Terminador){
        super(Terminador);
    }
    
    @Override
    public void start(){
        super.createFase();
        super.start();
    }
    
    public void createInteragivel(){
        Coracao c1 = new Coracao(3,1);
        Coracao c2 = new Coracao(2,8);
        Coracao c3 = new Coracao(2,11);
        
        //Coracao
        this.addElement(new Coracao(3,1));
        this.addElement(new Coracao(2,8));
        this.addElement(new Coracao(2,11));
        this.addElement(new Coracao(12,2));
        this.addElement(new Coracao(12,8));
        this.addElement(new Coracao(12,9));
        
        this.porta = new Porta(1,6,false);
        this.addElement(porta);
        
        this.bau = new Bau(4,6,false);
        this.addElement(bau);
                
        this.coracoes = 6;
    }
    
    public void createPassavel(){
        for(int i = 9; i <= 10; i++){
            paintPassavel(i,10,"gramanovo.png");
        }
        for(int i = 7; i <= 9; i++){
            paintPassavel(i,11,"gramanovo.png");
        }
        paintPassavel(6,1,"gramanovo.png");
        paintPassavel(7,1,"gramanovo.png");
        paintPassavel(7,2,"gramanovo.png");
        paintPassavel(8,2,"gramanovo.png");
    }
    public void createEntities(){
        
        //Parededs Laterais
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
            if(i != 6)
                this.addElement(new Parede(1,i,"Parede3D.png"));
        }
        
        //Arbusto
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
        
        //Feno
        for(int i = 3; i <= 4; i++){
            this.addElement(new Feno(i,8));
        }
        
        for(int i = 4; i <= 5; i++){
            this.addElement(new Feno(i,9));
        }
        
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
        
        //Minhoca
        this.addElement(new Minhoca(7,4));
        this.addElement(new Minhoca(7,8));
        this.addElement(new Minhoca(3,2));
        
        for(int i = 0; i <= 13; i++){
            this.addElement(new Icone(i,13, "Icons/TelaPreta.png"));  
        }
        
        this.addElement(new Icone(2, 13, "Icons/IconLolo.png"));
        this.addElement(new Icone(3,13, "Icons/num5.png"));
        this.addElement(new Icone(6,13, "Icons/IconPoder.png"));
        this.addElement(new Icone(7,13, "Icons/num3.png"));
        
    }
}
