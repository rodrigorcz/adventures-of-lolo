package Level;

import Entities.Elements.Porta;
import Entities.Elements.Bau;
import Entities.Elements.Coracao;
import Entities.Elements.BlocoEmpurravel;
import Entities.Enemy.*;
import Obstacles.*;
import Auxiliar.*;
import Entities.Elements.Icone;
import Entities.Hero;
/**
 *
 * @author marcussilva
 */
public class Level_3 extends Fase{

    public Level_3(ObserverJogo Terminador){
        super(Terminador);
    }
    @Override
    public void start(){
        super.createFase();
        super.start();
        lolo.setPosicao(6,7);
    }
    
    @Override
    public void reiniciarFase(){
        int tmp = lolo.vidas - 1;
        Elements.clear();

        Hero lolo2 = new Hero(6,7);
        lolo2.vidas = tmp;
        lolo = lolo2;
        this.addElement(lolo);
        
        createFase();
    }
    
    public void createPassavel(){}
    
    @Override
    public void createInteragivel() {
        this.addElement(new Coracao(4,4));
        this.addElement(new Coracao(6,1));
        this.addElement(new Coracao(6,3));
        this.addElement(new Coracao(9,2));
        this.addElement(new Coracao(10,10));
        this.addElement(new Coracao(2,8));
        
        this.porta = new Porta(1,7,false);
        this.addElement(porta);
        
        this.bau = new Bau(6,2,false);
        this.addElement(bau);
        
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
        this.addElement(new Arbusto(9,9));
        this.addElement(new Arbusto(12,9));
        this.addElement(new Arbusto(10,5));
        this.addElement(new Arbusto(9,6));
        this.addElement(new Arbusto(11,5));
        this.addElement(new Arbusto(10,6));
              
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
     
        //Tatu
        this.addElement(new Tatu(2,1));
        
        //Bloco Empurravel
        for(int j = 1; j <= 3; j++){
            this.addElement(new BlocoEmpurravel(8, j));
        }
        
        for(int j = 1; j <= 3; j++){
            this.addElement(new BlocoEmpurravel(11, j));
        }
        
        this.addElement(new BlocoEmpurravel(8,10));
        
        for(int i = 0; i <= 13; i++){
            this.addElement(new Icone(i,13, "Icons/TelaPreta.png"));  
        }
        
        this.addElement(new Icone(1, 13, "Icons/IconLolo.png"));
        this.addElement(new Icone(5,13, "Icons/IconPoder.png"));
        
        this.addElement(new Icone(11, 13, "Icons/save.png"));
        this.addElement(new Icone(12, 13, "Icons/letraS.png"));
    }
}
