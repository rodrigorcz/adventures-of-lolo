package Level;

import java.util.ArrayList;
import java.util.List;
import Controler.Tela;
import Entities.Hero;
import Entities.Elemento;
import Auxiliar.Fase;
import Entities.Enemy.BichinhoVaiVemHorizontal;
import Entities.Enemy.Caveira;
import Entities.Enemy.ZigueZague;
import Obstacles.Parede;

public class Level_1 extends Fase{
    
    @Override
    public void start(){
        super.createFase();
        super.start();
    }
    
    public void createEntities(){
        
        this.addElement(new Parede(1,1));
        this.addElement(new Parede(1,2));
        this.addElement(new Parede(1,3));
        this.addElement(new Caveira(9,1));
        this.addElement(new Caveira(8,1));
    }
}
