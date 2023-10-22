package Auxiliar;

import Entities.Creature;
import Entities.Enemy.Caveira;
import Entities.Hero;
import Entities.Entity;
import Controler.Tela;
import Entities.Enemy.BichinhoVaiVemHorizontal;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Entities.Enemy.ZigueZague;
import Obstacles.Parede;
import Auxiliar.Position;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.JButton;
import java.util.concurrent.TimeUnit;

public abstract class Level extends Tela{
    public Hero lolo;
    protected ArrayList<Entity> Elements;
    
    
    public void addElement(Entity E1){
        this.Elements.add(E1);
    } 
    
    
}
