package Level;

import Entities.Elements.*;
import Entities.Elements.Icone;
import Entities.Enemy.*;
import Obstacles.*;
import Auxiliar.*;
import Entities.Hero;

/**
 *
 * @author marcussilva
 */
public class Level_6 extends Fase{

    public Level_6(ObserverJogo Terminador) {
        super(Terminador);
    }

    @Override
    public void start(){
        super.createFase();
        super.start();
        lolo.setPosicao(2,6);
    }
    
    @Override
    public void reiniciarFase(){
        lolo.vidas -= 1;
        Elements.clear();
        faseTerminou = false;
        this.addElement(lolo);
        lolo.setPosicao(2,6);
        createFase();
    }
    
    public void createPassavel(){}

    public void createInteragivel(){
        //Coracao
        this.addElement(new Coracao(6,3));
        this.addElement(new Coracao(6,4));
        this.addElement(new Coracao(9,3));
        this.addElement(new Coracao(9,4));
        this.addElement(new Coracao(5,8));
        this.addElement(new Coracao(5,9));
        this.addElement(new Coracao(8,8));
        this.addElement(new Coracao(8,9));
        
        //Porta
        this.porta = new Porta(1,6,false);
        this.addElement(porta);
        
        //Bau
        this.bau = new Bau(8,6,false);
        this.addElement(bau);
        
        this.coracoes = 8;
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
            if(i != 6)  
                this.addElement(new Parede(1,i,"Parede3D.png"));
        }
        
        //Arbusto
        this.addElement(new Arbusto(2,1));
        this.addElement(new Arbusto(2,2));
        this.addElement(new Arbusto(4,2));
        this.addElement(new Arbusto(8,2));
        this.addElement(new Arbusto(4,5));
        this.addElement(new Arbusto(5,5));
        this.addElement(new Arbusto(6,5));
        this.addElement(new Arbusto(7,5));
        this.addElement(new Arbusto(5,7));
        this.addElement(new Arbusto(6,7));
        this.addElement(new Arbusto(7,7));
        this.addElement(new Arbusto(2,10));
        this.addElement(new Arbusto(2,11));
        this.addElement(new Arbusto(5,10));
        this.addElement(new Arbusto(5,10));
        this.addElement(new Arbusto(9,10));
        this.addElement(new Arbusto(10,10));
        
        //Feno
        this.addElement(new Feno(5,2));
        this.addElement(new Feno(6,2));
        this.addElement(new Feno(7,2));
        this.addElement(new Feno(9,2));
        this.addElement(new Feno(10,3));
        this.addElement(new Feno(8,5));
        this.addElement(new Feno(9,5));
        this.addElement(new Feno(8,7));
        this.addElement(new Feno(9,7));
        this.addElement(new Feno(10,7));
        this.addElement(new Feno(4,9));
        this.addElement(new Feno(6,10));
        this.addElement(new Feno(7,10));
        this.addElement(new Feno(8,10));
        
        //Bloco Empurravel
        this.addElement(new BlocoEmpurravel(4,3));
        this.addElement(new BlocoEmpurravel(8,4));
        this.addElement(new BlocoEmpurravel(10,4));
        this.addElement(new BlocoEmpurravel(4,8));
        this.addElement(new BlocoEmpurravel(6,8));
        this.addElement(new BlocoEmpurravel(10,9));
        
        //Tatu
        this.addElement(new Tatu(12,2));
        this.addElement(new Tatu(12,6));
        this.addElement(new Tatu(12,10));
        
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
