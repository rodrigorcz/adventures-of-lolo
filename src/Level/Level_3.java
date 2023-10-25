package Level;

import Entities.Enemy.*;
import Obstacles.*;
import Auxiliar.*;
import Icons.Icone;
/**
 *
 * @author marcussilva
 */
public class Level_3 extends Fase{

    public Level_3(InterfaceFase Terminador){
        super(Terminador);
    }
    @Override
    public void start(){
        super.createFase();
        super.start();
    }

    
    public void createCoracao() {
        Coracao c1 = new Coracao(4,4);
        Coracao c2 = new Coracao(6,1);
        Coracao c3 = new Coracao(6,3);
        Coracao c4 = new Coracao(9,2);
        Coracao c5 = new Coracao(10,10);
        Coracao c6 = new Coracao(2,8);
        
        this.addElement(c1);
        this.addElement(c2);
        this.addElement(c3);
        this.addElement(c4);
        this.addElement(c5);
        this.addElement(c6);
        
        this.porta = new Porta(1,7,false);
        this.addElement(porta);
        
        this.coracoes = 6;
    }
    
    
    public void createEntities() {
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
        
        this.addElement(new Bau(6,2,"BauFechado.png"));
        
        //Arbusto
        for(int j = 5; j <= 7; j++){
            this.addElement(new Arbusto(5,j));
        }
        this.addElement(new Arbusto(2,5));
        this.addElement(new Arbusto(2,6));
        this.addElement(new Arbusto(3,6));
        this.addElement(new Arbusto(6,6));
        this.addElement(new Arbusto(5,1));
        this.addElement(new Arbusto(5,9));
        this.addElement(new Arbusto(5,10));
        this.addElement(new Arbusto(9,9));
        this.addElement(new Arbusto(12,9));
        this.addElement(new Arbusto(10,5));
        this.addElement(new Arbusto(9,6));
        
        //Feno
        for(int j = 2; j <= 4; j++){
            this.addElement(new Feno(5,j));
        }
        this.addElement(new Feno(2,4));
        this.addElement(new Feno(3,4));
        this.addElement(new Feno(3,5));
        this.addElement(new Feno(2,9));
        this.addElement(new Feno(3,8));
        this.addElement(new Feno(3,9));
        this.addElement(new Feno(6,5));
        this.addElement(new Feno(10,9));
        this.addElement(new Feno(11,9));
        this.addElement(new Feno(9,10));
        
        //Agua
        for(int i = 6; i <= 11; i++){
            this.addElement(new Agua(i,4));
        }
        for(int i = 8; i <= 10; i++){
            this.addElement(new Agua(i,5));
        }
        this.addElement(new Agua(9,6));
     
        
        for(int i = 0; i <= 13; i++){
            this.addElement(new Icone(i,13, "Icons/TelaPreta.png"));  
        }
        
        this.addElement(new Icone(2, 13, "Icons/IconLolo.png"));
        this.addElement(new Icone(3,13, "Icons/num5.png"));
        this.addElement(new Icone(6,13, "Icons/IconPoder.png"));
        this.addElement(new Icone(7,13, "Icons/num3.png"));
    }
}