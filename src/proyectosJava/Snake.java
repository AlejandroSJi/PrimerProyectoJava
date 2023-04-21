
package proyectosJava;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Snake extends javax.swing.JFrame {

    PanelSnake panel;
    
    
    public Snake() {
        initComponents();
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/pngwing.com.png")));
        this.setLocationRelativeTo(this);
        
        panel = new PanelSnake(800,20);
        this.add(panel);
        panel.setBounds(10,10,800,800);
        panel.setOpaque(false);
        
        
        PanelFondo fondo = new PanelFondo(800,20);
        this.add(fondo);
        fondo.setBounds(10,10,800,800);
        
        this.requestFocus(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                panel.cambiarDireccion("iz");
                break;
            case KeyEvent.VK_RIGHT:
                panel.cambiarDireccion("de");
                break;
            case KeyEvent.VK_UP:
                panel.cambiarDireccion("ar");
                break;
            case KeyEvent.VK_DOWN:
                panel.cambiarDireccion("ab");
                break;
            default:
                break;
        }
            
    }//GEN-LAST:event_formKeyPressed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Snake().setVisible(true);

            }
        });
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
