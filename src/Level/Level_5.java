package Level;

import Entities.Elements.*;
import Icons.Icone;
import Entities.Enemy.*;
import Obstacles.*;
import Auxiliar.*;

/**
 *
 * @author marcussilva
 */
public class Level_5 extends Fase{
    
    public Level_5(InterfaceFase Terminador){
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
        this.addElement(new Coracao(4,1));
        this.addElement(new Coracao(6,1));
        this.addElement(new Coracao(8,1));
        this.addElement(new Coracao(2,4));
        this.addElement(new Coracao(2,8));
        this.addElement(new Coracao(4,11));
        this.addElement(new Coracao(6,11));
        this.addElement(new Coracao(8,11));
        this.addElement(new Coracao(10,6));
        
        //Porta
        this.porta = new Porta(1,6,false);
        this.addElement(porta);
        
        //Bau
        this.bau = new Bau(3,6,false);
        this.addElement(bau);
        
        this.coracoes = 9;
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
        this.addElement(new Arbusto(3,2));
        this.addElement(new Arbusto(5,2));
        this.addElement(new Arbusto(6,2));
        this.addElement(new Arbusto(10,3));
        this.addElement(new Arbusto(3,4));
        this.addElement(new Arbusto(2,7));
        this.addElement(new Arbusto(3,8));
        this.addElement(new Arbusto(3,10));
        this.addElement(new Arbusto(5,10));
        this.addElement(new Arbusto(7,10));
        this.addElement(new Arbusto(8,10));
        this.addElement(new Arbusto(10,9));
        
        //Feno
        this.addElement(new Feno(3,3));
        this.addElement(new Feno(4,2));
        this.addElement(new Feno(7,2));
        this.addElement(new Feno(8,2));
        this.addElement(new Feno(5,3));
        this.addElement(new Feno(7,3));
        this.addElement(new Feno(9,3));
        this.addElement(new Feno(2,5));
        this.addElement(new Feno(3,9));
        this.addElement(new Feno(5,9));
        this.addElement(new Feno(7,9));
        this.addElement(new Feno(9,9));
        this.addElement(new Feno(4,10));
        this.addElement(new Feno(6,10));
        
        //Bloco Empurravel
        this.addElement(new BlocoEmpurravel(10,2));
        this.addElement(new BlocoEmpurravel(10,5));
        this.addElement(new BlocoEmpurravel(10,7));
        this.addElement(new BlocoEmpurravel(10,10));
        
        //Caveira
        this.addElement(new Caveira(4,3));
        this.addElement(new Caveira(6,3));
        this.addElement(new Caveira(8,3));
        this.addElement(new Caveira(4,9));
        this.addElement(new Caveira(6,9));
        this.addElement(new Caveira(8,9));
        
        //Minhoca
        this.addElement(new Minhoca(7,5));
        this.addElement(new Minhoca(7,7));
        
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
