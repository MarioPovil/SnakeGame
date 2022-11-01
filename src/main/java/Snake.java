import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
public class Snake extends JFrame {
    Point snake;  //Creación de punto 
    Point comida; //comida
    int widht=640;  //Ancho de la pantalla
    int height=480;  //Altura de la pantalla
int widhtPoint=10;  //Ancho del punto 
long frecuencia = 20;   //frecuenciaXseg
int heightPoint=10;  //altura del punto
int direccion= KeyEvent.VK_LEFT;  //guardado de coordenadas
ImagenSnake imagenSnake;   //Variable global
public Snake() {
    setTitle("esnake");   //Titulo del JFrame
    setSize (widht,height);  //Selección del tamaño de la pantalla
    Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();   //Posición de la pantalla 
    this.setLocation(dim.width/2-widht/2, dim.height/2-height/2);  //Posicion al centro de la pantalla
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrado de la pantalla
    Teclas teclas = new Teclas();   //Se crea la variable teclas
    this.addKeyListener(teclas);    // para que el programa ejecute la clase "Teclas"
    imagenSnake = new ImagenSnake();   //Variable imagenSnake
    this.getContentPane().add(imagenSnake);  //Se da el contenedor
    setVisible(true);  //hacer visible el punto
    Momento momento = new Momento();  //Variable momento
    Thread trid = new Thread(momento);
    trid.start();
    StartGame();
    }
    public void StartGame(){
        comida = new Point(200,200);
        snake = new Point(200,200);
    }
    public void CrearComida(){
        Random rnd = new Random();
        comida.x = rnd.nextInt(widht);
        if((comida.x % 5)>0){
            comida.x= comida.x - (comida.x % 5);
        }
        if (comida.x < 5){
            comida.x = comida.x + 10;
        }
         comida.x = rnd.nextInt(height);
        if((comida.y % 5)<0){
            comida.y= comida.y - (comida.y % 5);
        }
        if (comida.y > 5){
            comida.y = comida.y + 5;
        }
    }
    public static void main(String[] args) throws Exception {
        Snake s =new Snake();
        }
    public void actualizar(){
        
       if((snake.x > (comida.x - 10)) && (snake.x <(comida.x + 10)) && (snake.y > (comida.y - 10)) && (snake.y < (comida.y +10))){
           
       
        CrearComida();    
    }
       imagenSnake.repaint();
    }
        public class ImagenSnake extends JPanel {
        public void paintComponent(Graphics vibora){ //se usara para elegir el rellenado del punto
            super.paintComponents(vibora);
            vibora.setColor(new Color(138,43,226));
            vibora.fillRect(snake.x, snake.y, widhtPoint, heightPoint);
            vibora.setColor(new Color(230,100,15));
             vibora.fillRect(comida.x, comida.y, widhtPoint, heightPoint);
        }
    }
    public class Teclas extends KeyAdapter { //KeyAdapter sirve para eventos de teclas 
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //Si la tecla ESC es presionada sale el programa
             System.exit(0);
              actualizar();
            
        } else if(e.getKeyCode()==KeyEvent.VK_UP) {   // Sí la tecla up es accionada 
        if(direccion != KeyEvent.VK_DOWN) {
            direccion  = KeyEvent.VK_UP;
        } }
            else if(e.getKeyCode()==KeyEvent.VK_DOWN){       
        if(direccion != KeyEvent.VK_UP) {
            direccion  = KeyEvent.VK_DOWN;
        }
            } else if(e.getKeyCode()==KeyEvent.VK_LEFT) {        
             if(direccion != KeyEvent.VK_RIGHT) {
            direccion  = KeyEvent.VK_LEFT;
        }}
            else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {  
                 if(direccion != KeyEvent.VK_LEFT) {
            direccion  = KeyEvent.VK_RIGHT;
        }
            }
        }
        
    }
   public class Momento extends Thread {
       long last =0;
    public void run(){
        while(true){
            if((java.lang.System.currentTimeMillis()-last)> frecuencia){
                if(direccion == KeyEvent.VK_UP){
                    snake.y=snake.y- heightPoint;
                    if(snake.y <0){
                        snake.y=height - heightPoint;
                    }
                    if(snake.y > height){
                        snake.y=0;
                    }
                } else if(direccion ==KeyEvent.VK_DOWN){
                    snake.y= snake.y + widhtPoint;
                    if(snake.y <0){
                        snake.y=height + heightPoint;
                    }
                    if(snake.y > 480){
                        snake.y=0;
                    }
                }
                else if(direccion ==KeyEvent.VK_LEFT){
                    snake.x= snake.x - widhtPoint;
                    if(snake.x <0){
                        snake.x=widht - widhtPoint;
                    }
                    if(snake.x > widht){
                        snake.x=0;
                    }
                }
                else if(direccion ==KeyEvent.VK_RIGHT){
                    snake.x= snake.x + widhtPoint;
                    if(snake.x <0){
                        snake.x= widht + widhtPoint;
                    }
                    if(snake.x > 640){
                        snake.x=0;
                    }
                }
                
                last= java.lang.System.currentTimeMillis();
        }
            actualizar();
        } 
    }    
    }
    }

