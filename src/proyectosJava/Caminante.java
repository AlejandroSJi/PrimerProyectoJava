/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosJava;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ale
 */
public class Caminante implements Runnable{
    PanelSnake panel;
    int velocidad = 250;
    boolean estado = true;
    static boolean estadoStatic = true;
    public Caminante (PanelSnake panel){
        this.panel=panel;
    }
    @Override
    public void run() {
        while(estado){
            panel.avanzar();
            panel.repaint();
           
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Caminante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void parar(){
        this.estado=false;
    }
}
