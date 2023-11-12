package Auxiliar;

import Entities.*;
import Entities.Elements.*;
import Entities.Enemy.*;
import Auxiliar.*;
import Controler.*;
import Obstacles.*;
import Save.SaveLoad;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;



public abstract class Fase extends Sistema{
    protected ArrayList<Elemento> Elements;
    private ControleDeJogo cj = new ControleDeJogo();
    private Graphics g2;
    private ObserverJogo Terminador;
    private int count = 0;
    private int countPoder = 0;
    private boolean faseTerminou;
    
    //Variaveis inerentes de cada fase
    public Hero lolo;
    protected BlocoEmpurravel bloco;
    protected Bau bau;
    protected Porta porta;
    protected Fase faseAtual;
    protected int coracoes;
    protected int empurra = 0;
    protected VideoGame fase;

    
    public Fase(ObserverJogo Terminador){
        this.Elements = new ArrayList<>(195);
        this.Terminador = Terminador;
        
        this.faseTerminou = false;
        lolo = new Hero(7,7);
        this.addElement(lolo);
    }
      
    public abstract void createEntities();
    public abstract void createInteragivel();
    
    public void start(){
        this.setVisible(true);
        this.createBufferStrategy(3);
        Desenho.setCenario(this);
        this.go();
    }
    
    public void addElement(Elemento e){
        this.Elements.add(e);
    }
    
    public void removeElement(Elemento e){
        this.Elements.remove(e);
    }
    
    public boolean faseTerminou(){
        return this.faseTerminou;
    }
    
    public void createFase(){
        initComponents();
        createEntities();
        createInteragivel();
        
        this.addMouseListener(this);
        this.addKeyListener(this);
        
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right, Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        Desenho.setCenario(this);
    }
    
    public boolean addDelay(int tamanho){
        this.contador = 0;
        while(contador<tamanho){
            return false;
        }
            return true;
    }
    
    public void stopFase(){
        this.setVisible(false);
        this.Elements.clear();
        this.cancelar();
    }
    
    public boolean ehPosicaoValida(Posicao p){
        return cj.ehPosicaoValida(this.Elements, p);
    }
    
    public boolean movimentoInimigo(Posicao p){
        return cj.movimentoInimigo(this.Elements, p);
    }
    
    public boolean ehPosicaoValidaTiro(Posicao p){
        return cj.ehPosicaoValidaTiro(this.Elements, p);
    }
    
    public boolean transformaInimigo(Posicao p){
        return cj.transformaInimigo(this.Elements, p);
    }
    
    public void removePersonagem(Personagem e1) {
        Elements.remove(e1);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    public void verificaPoder(){
        switch(lolo.poderes){
            case 0:
                this.addElement(new Icone(6,13, "Icons/num0.png"));
                break;
            case 1:
                this.addElement(new Icone(6,13, "Icons/num1.png"));
                break;
            case 2:
                this.addElement(new Icone(6,13, "Icons/num2.png"));
                break;
            case 3:
                this.addElement(new Icone(6,13, "Icons/num3.png"));
                break;
            case 4:
               this.addElement(new Icone(6,13, "Icons/num4.png"));
               break;
        }
    }
    
    public void verificaVida(){
        switch(lolo.vidas){
            case 0:
                stopFase();
                this.Terminador.iniciarFim(false);
                this.addElement(new Icone(2,13, "Icons/num0.png"));
                break;
            case 1:
                this.addElement(new Icone(2,13, "Icons/num1.png"));
                break;
            case 2:
                this.addElement(new Icone(2,13, "Icons/num2.png"));
                break;
            case 3:
                this.addElement(new Icone(2,13, "Icons/num3.png"));
                break;
        }
    }
    
    public void eliminarInimigos(ArrayList<Elemento> umaFase){
        Elemento pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(pIesimoPersonagem instanceof Inimigo || pIesimoPersonagem instanceof Ovo){
                Explosao e = new Explosao(pIesimoPersonagem.getPosicao().getLinha(),pIesimoPersonagem.getPosicao().getColuna());
                umaFase.remove(pIesimoPersonagem);
                umaFase.add(e);
            }       
        }        
    }
    
            
    public void leituraLolo(ArrayList<Elemento> elemFase){
        if(coracoes == 0){
            bau.abrirBau();
            this.faseTerminou = true;
            this.coracoes--;
            if(bau.bauAberto()){
                bau.setImage("BauAberto.png");
            }
        }
        verificaPoder();
        verificaVida();
       
        if(elemFase.get(0) instanceof Hero){
                Hero hero = (Hero)elemFase.get(0);
                Elemento auxElemento;

            if(hero.getPosicao().igual(bau.getPosicao()) && bau.bauAberto()){
                bau.setImage("BauVazio.png");
                porta.setImage("PortaAb.png");
                eliminarInimigos(elemFase);
                porta.abrirPorta();
            }

            for(int i = 1; i < elemFase.size(); i++){
                auxElemento = elemFase.get(i);
                if(hero.getPosicao().igual(auxElemento.getPosicao()))
                    if(auxElemento instanceof Coracao){
                        this.coracoes--;
                        if(++countPoder > 1){
                            lolo.poderes++;
                            countPoder = 0;
                        }
                    }
                if(hero.getPosicao().igual(auxElemento.getPosicao()))
                    if(auxElemento instanceof Inimigo){
                        reiniciarFase();
                    }
                }
        }
    }
    
    public abstract void createPassavel();
    public void paint(Graphics gOld) {
 
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        
        /*************Desenha cenário de fundo**************/
        
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                paintPassavel(i,j,"brick.png");
            }
        }
        createPassavel();
        if (!this.Elements.isEmpty()) {
            this.cj.desenhaTudo(Elements);
            this.leituraLolo(Elements);
            this.cj.processaTudo(Elements);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();    
        }
        
        if((lolo.getPosicao().igual(porta.getPosicao()))){
            if(contador>10){
                this.Terminador.terminaFase();
                return;
            }
        }
        if(this.count <= 5){
            this.count++;
        }
    }
    
    public void reiniciarFase(){
        this.faseTerminou = false;
        int tmp = lolo.vidas - 1;
        Elements.clear();

        Hero lolo2 = new Hero(7,7);
        lolo2.vidas = tmp;
        lolo = lolo2;
        this.addElement(lolo);
        
        createFase();
    }

    public void keyPressed(KeyEvent e) {
        if(this.count > 0){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    lolo.moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    lolo.moveDown();
                    break;
                case KeyEvent.VK_LEFT:
                    lolo.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    lolo.moveRight();
                    break;
                case KeyEvent.VK_Z:
                    if(lolo.poderes > 0){
                        lolo.atirar();
                        lolo.poderes--;
                    }   break;
                case KeyEvent.VK_P:
                    lolo.vidas--;
                    this.Terminador.terminaFase();
                    break;
                case KeyEvent.VK_S:
                    try {
                        this.save();
                    } catch (IOException ex) {
                        Logger.getLogger(Fase.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case KeyEvent.VK_E:
                    this.load();
                    break;
                case KeyEvent.VK_R:
                    reiniciarFase();
                    break;
                default:
                    break;
            }
            this.count = 0;
        }
        
        cj.verificaEmpurrar(Elements);
        
        this.setTitle("-> Cell: " + (lolo.getPosicao().getColuna()) + ", "
                + (lolo.getPosicao().getLinha()));

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }
    
    public void paintPassavel(int i, int j, String Imagem){
        try{
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + Imagem);
            g2.drawImage(newImage,j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    public void fileRegister(ObjectOutput out) throws IOException{
        out.writeObject(this.Elements);
        out.close();
    }
    
    public void fileReader(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Elemento> savedElements = null;

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            savedElements = (ArrayList<Elemento>) in.readObject();

            System.out.println("Jogo carregado com sucesso");

        } catch (Exception ex) {
            Logger.getLogger(Fase.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (savedElements != null) {
            this.Elements = savedElements;
        }
    }

    
    public void save() throws FileNotFoundException, IOException{
        try(FileOutputStream s = new FileOutputStream("saveGame.txt")){
            ObjectOutputStream d = new ObjectOutputStream(s);
            this.fileRegister(d);
            System.out.println("Jogo Salvo");
        }catch(FileNotFoundException ex){
            Logger.getLogger(ControleDeJogo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(ControleDeJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void load(){
        try{
            this.fileReader("saveGame.txt");
        }catch(IOException ex){
            Logger.getLogger(ControleDeJogo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(ControleDeJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        lolo = (Hero)Elements.get(0);
    }
    
    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.lolo.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Adventures of Lolo 2");
        setAutoRequestFocus(true);
        setResizable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
    // Variables declaration - do not modify                     
    // End of variables declaration                   

}
