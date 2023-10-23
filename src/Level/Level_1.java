package Level;

import java.util.ArrayList;
import java.util.List;
import Controler.Tela;
import Entities.Hero;
import Entities.Entidade;
import Auxiliar.Fase;
import Entities.Enemy.BichinhoVaiVemHorizontal;
import Entities.Enemy.Caveira;
import Entities.Enemy.ZigueZague;
import Obstacles.Parede;
import Obstacles.Arbusto;
import Obstacles.Feno;
import Entities.Lootable.Chest_1;

public class Level_1 extends Fase{
    
    @Override
    public void start(){
        super.createFase();
        super.start();
    }
    
    public void createEntities(){
        
        for(int i = 0; i <= 12; i++){
            this.addElement(new Parede(i,0));
        }
        
        this.addElement(new Feno(2,1));
        this.addElement(new Feno(4,1));
        this.addElement(new Arbusto(5,1));
        this.addElement(new Arbusto(7,1));
        this.addElement(new Arbusto(8,1));
        this.addElement(new Arbusto(9,1));
        this.addElement(new Feno(10,1));
        this.addElement(new Feno(11,1));
    }
}
