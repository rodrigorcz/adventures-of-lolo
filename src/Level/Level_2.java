package Level;

import java.util.ArrayList;
import java.util.List;
import Controler.Tela;
import Entities.Hero;
import Entities.Entidade;
import Auxiliar.*;
import Controler.Complete;
import Entities.Enemy.Minhoca;
import Entities.Enemy.Caveira;
import Entities.Enemy.ZigueZague;
import Obstacles.Parede;

public class Level_2 extends Fase{
    
    public Level_2(Complete phaseCompleteListener){
        super(phaseCompleteListener);
    }
    @Override
    public void start(){
        super.createFase();
        super.start();
    }
    
    @Override
    public void createEntities(){
        
        for(int i = 5; i<Consts.RES-1;i++){
            for(int j = 0; j<Consts.RES;j++){
                this.addElement(new Parede(i,j));
            }
        }
    }
    
}
