package Level;

import Entities.Elements.Porta;
import Entities.Elements.Bau;
import Entities.Elements.Coracao;
import Entities.Elements.Icone;
import Entities.Enemy.*;
import Obstacles.*;
import Auxiliar.*;
import Entities.Hero;

public class Level_4 extends Fase{
    
    public Level_4(ObserverJogo Terminador){
        super(Terminador);
    }
    
    @Override
    public void start(){
        super.createFase();
        super.start();
        lolo.setPosicao(12,11);
    }
    
    @Override
    public void reiniciarFase(){
        lolo.vidas -= 1;
        Elements.clear();

        this.addElement(lolo);
        lolo.setPosicao(12,11);
        createFase();
    }
    
    public void createPassavel(){
        //Grama morta
        for(int i = 3; i<= 11;i++){
            paintPassavel(i,11,"gramamorta.png");
        }
        for(int i = 2; i<11;i++){
            paintPassavel(12, i,"gramamorta.png");
        }
        for(int i = 8; i <= 11; i++){
            paintPassavel(i,6,"gramamorta.png");
        }
        for(int j = 7; j <= 10; j++){
            paintPassavel(7,j, "gramamorta.png");
        }
        
        //Grama verde
        for(int i = 3; i <= 11; i++){
            paintPassavel(i,1, "graman.png");
        }
        for(int i = 3; i <= 6; i++){
            paintPassavel(i, 2, "graman.png");
        }
        for(int j = 2; j <= 10; j++){
            paintPassavel(2, j, "graman.png");
        }
        for(int i = 3; i<= 4; i++){
            paintPassavel(i, 3, "graman.png");
        }
        for(int j = 4; j <= 5; j++){
            paintPassavel(3, j, "graman.png");
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
        
        //Arbusto
        this.addElement(new Arbusto(12,1));
        this.addElement(new Arbusto(2,11));
        this.addElement(new Arbusto(10,9));
        
        //Bicho Verde
        this.addElement(new BichoVerde(3,8));
        this.addElement(new BichoVerde(5,4));
        this.addElement(new BichoVerde(6,10));
        this.addElement(new BichoVerde(11,5));
        this.addElement(new BichoVerde(9,2));
        
        //Icones
        for(int i = 0; i <= 13; i++){
            this.addElement(new Icone(i,13, "Icons/TelaPreta.png"));  
        }
        
        this.addElement(new Icone(1, 13, "Icons/IconLolo.png"));
        this.addElement(new Icone(5,13, "Icons/IconPoder.png"));
        
        this.addElement(new Icone(11, 13, "Icons/save.png"));
        this.addElement(new Icone(12, 13, "Icons/letraS.png"));

    }
}

