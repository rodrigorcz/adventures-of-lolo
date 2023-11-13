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
    
    //Variaveis de Controle e Auxilio
    private ControleDeJogo controleJogo = new ControleDeJogo();
    private Graphics g2;
    private ObserverJogo Terminador;
    private int count = 0;
    private int countPoder = 0;
    private boolean faseTerminou;
    
    //Variaveis inerentes de cada fase
    public Hero lolo;
    public ArrayList<Elemento> Elements;
    protected BlocoEmpurravel bloco;
    protected Bau bau;
    protected Porta porta;
    protected Fase faseAtual;
    protected int coracoes;
    protected VideoGame fase;

    
    public Fase(ObserverJogo Terminador){
        this.Elements = new ArrayList<>(195);
        this.Terminador = Terminador;
        
        this.faseTerminou = false;
        lolo = new Hero(7,7);
        this.addElement(lolo);
    }

    //Metodos Abstratos
    public abstract void createEntities();
    public abstract void createInteragivel();
    public abstract void createPassavel();
    public abstract void reiniciarFase();
    
    //Controle das tela do jogo
    public void start(){
        this.setVisible(true);
        this.createBufferStrategy(3); // Com 2 Buffers o jogo roda melhor, porem pode ter alguns bugs em algumas maquinas
        Desenho.setCenario(this);
        this.go();
    }
    
    public void stopFase(){
        this.setVisible(false);
        this.Elements.clear();
        this.cancelar();
    }

    //Cria toda os elementos da fase
    public void createFase(){
        initComponents();
        createEntities();
        createInteragivel();
        
        this.addMouseListener(this);
        this.addKeyListener(this);
        
        this.setSize(Constantes.RES * Constantes.CELL_SIDE + getInsets().left + getInsets().right, Constantes.RES * Constantes.CELL_SIDE + getInsets().top + getInsets().bottom);

        Desenho.setCenario(this);
    }
    
    //Acesso aos metodos da classe ControleDeJogo
    public boolean ehPosicaoValida(Posicao p){
        return controleJogo.ehPosicaoValida(this.Elements, p);
    }
    
    public boolean movimentoInimigo(Posicao p){
        return controleJogo.movimentoInimigo(this.Elements, p);
    }
    
    public boolean ehPosicaoValidaTiro(Posicao p){
        return controleJogo.ehPosicaoValidaTiro(this.Elements, p);
    }
    
    public boolean transformaInimigo(Posicao p){
        return controleJogo.transformaInimigo(this.Elements, p);
    }
    
    //Manipulação de elementos e variaveis

    public void removeElement(Elemento e){
        Elements.remove(e);
    }
    public void addElement(Elemento e){
        Elements.add(e);
    }
    
    public boolean faseTerminou(){
        return this.faseTerminou;
    }
    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
 
    // Elimina todos inimigos da fase, transformando-os em explosoes
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
    
    // Manipulação das interações do Lolo
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
                        removeElement(auxElemento);
                    }
                if(hero.getPosicao().igual(auxElemento.getPosicao()))
                    if(auxElemento instanceof Inimigo){
                        reiniciarFase();
                    }
                }
        }
    }
    
    
    //Desenho dos elementos
    public void paint(Graphics gOld) {
 
        //Criacao dos graficos
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        
        ///Desenha o cenário que fica no fundo
        for (int i = 0; i < Constantes.RES; i++) {
            for (int j = 0; j < Constantes.RES; j++) {
                paintPassavel(i,j,"brick.png");
            }
        }
        createPassavel();
        
        //Processamento das informações
        if (!this.Elements.isEmpty()) {
            this.controleJogo.desenhaTudo(Elements);
            this.leituraLolo(Elements);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();    
        }
        
        // Se o Lolo entrar na porta troca de fase
        if((lolo.getPosicao().igual(porta.getPosicao()))){
            this.Terminador.terminaFase();
            return;
        }
        this.count++;
    }
    

    // Definicao de comandos do teclado
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
        
        controleJogo.verificaEmpurrar(Elements);
        this.setTitle("-> Lolo: " + (lolo.getPosicao().getColuna()) + ", " + (lolo.getPosicao().getLinha()));
        
    }
    
    //Desenha o plano de fundo
    public void paintPassavel(int i, int j, String Imagem){
        try{
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Constantes.PATH + Imagem);
            g2.drawImage(newImage,j * Constantes.CELL_SIDE, i * Constantes.CELL_SIDE, Constantes.CELL_SIDE, Constantes.CELL_SIDE, null);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    // Stream e Arquivos
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
    
    // Mouse
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        this.setTitle("X: "+ x + ", Y: " + y + " -> Cell: " + (y/Constantes.CELL_SIDE) + ", " + (x/Constantes.CELL_SIDE));
        
        //Lolo ira para a posicao do clique, caso o usuario precise
        this.lolo.getPosicao().setPosicao(y/Constantes.CELL_SIDE, x/Constantes.CELL_SIDE);
        repaint();
    }
    
    //Verificacao da vida e poder
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
