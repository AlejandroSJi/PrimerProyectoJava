/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosJava;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelSnake extends JPanel{
    
    
    Color colorSnake=Color.BLUE;
    Color colorComida=Color.RED;
    int tanmax,tam,can,res;
    int[]comida = new  int[2];
    List<int[]> snake = new ArrayList<>();
    String direccion = "de";
    String direccionProxima = "de";
    Thread hilo;
    Caminante camino;    
    
    public PanelSnake(int tanmax, int can) {
        this.tanmax = tanmax;
        this.can = can;
        this.tam = tanmax/can;
        this.res = tanmax%can;
        int[] a={can/2-1,can/2-1};
        int[] b={can/2,can/2-1};
        snake.add(a);
        snake.add(b);
        generarComida();
        
        camino = new Caminante(this);
        hilo = new Thread(camino);
        hilo.start();
                
    }
   
    @Override
    public void paint (Graphics pintor){
        super.paint(pintor);
        pintor.setColor(colorSnake);
        for(int i = 0; i<snake.size(); i++){
           pintor.fillRect(res/2+snake.get(i)[0]*tam,res/2+snake.get(i)[1]*tam,tam-1,tam-1);
        }
        pintor.setColor(colorComida);
        pintor.fillRect(res/2+comida[0]*tam,res/2+comida[1]*tam,tam-1,tam-1);
        
    }

    public void avanzar(){
        igualarDir();
        int[] ultimo = snake.get(snake.size()-1);
        int agregarX = 0;
        int agregarY = 0;
        switch(direccion){
            case "de": agregarX++;break;
            case "iz": agregarX--;break;
            case "ar": agregarY--;break;
            case "ab": agregarY++;break;
        }
        
        int[]nuevo = {Math.floorMod(ultimo[0]+agregarX,can),Math.floorMod(ultimo[1]+agregarY,can)};
        boolean existe = false;
         for(int i = 0; i<snake.size(); i++){
           if(nuevo[0]==snake.get(i)[0]&&nuevo[1]==snake.get(i)[1]){
               existe=true;
               break;
           }
        }
         if(existe){
             JOptionPane.showMessageDialog(this,"Has perdido, Tu puntuacion es: " + snake.size() );
             camino.parar();
             
         }else if ((nuevo[0]==comida[0]&&nuevo[1]==comida[1])){
            snake.add(nuevo);
            if(camino.velocidad>20){
            camino.velocidad-=3;}
             System.out.println(camino.velocidad);
            generarComida();
         }else{
             snake.add(nuevo);
             snake.remove(0);
         }
        
        
    }
    
    public void generarComida(){
        boolean existe = false;
        int a = (int)(Math.random()*can);
        int b = (int)(Math.random()*can);
        for(int[]par:snake){
            if(par[0]==a&&par[1]==b){
                existe=true;
                generarComida();
                break;
            }
               
        }
        if(!existe){
            this.comida[0]=a;
            this.comida[1]=b;
            
        }
    }
    public void cambiarDireccion(String dir){
        if((this.direccion.equals("de")||this.direccion.equals("iz"))&&(dir.equals("ar")||dir.equals("ab"))){
             this.direccionProxima = dir;
        }
         if((this.direccion.equals("ar")||this.direccion.equals("ab"))&&(dir.equals("iz")||dir.equals("de"))){
             this.direccionProxima = dir;
        }
       
    }
    public void igualarDir(){
        this.direccion = direccionProxima;
    }
}
