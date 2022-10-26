/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author fing.labcom
 */
public class ManejadorTeclado implements KeyListener{
    Movil movil;
    
    int ncamera = 1;
    public ManejadorTeclado(Movil m){
        this.movil= m;
    
    }
    public void keyTyped(KeyEvent e){
        if(e.getKeyChar() == 'p'){
            Test.esDia = !Test.esDia;
            System.out.println(Test.esDia);
        }
        if(e.getKeyChar() == 'w'){
        this.movil.avanzar();
         
        }
         if(e.getKeyChar() == 's'){
        this.movil.retroceder();
        }
           if(e.getKeyChar() == 'a'){
        this.movil.izquierda();
        }
             if(e.getKeyChar() == 'd'){
        this.movil.derecha();
        }
        if(e.getKeyChar() == '1'){
                  
            ncamera=1;
        }
        if(e.getKeyChar() == '2'){
            ncamera=2;
        }
        if(e.getKeyChar() == '3'){
            ncamera=3;
        }
        if(e.getKeyChar() == '4'){
            ncamera=4;
        }
        if(e.getKeyChar() == 'b'){
            System.out.println("disparando........");
            this.movil.disparar();
        }
        
    }
    
    public void keyPressed (KeyEvent e){
    
    
    }
    public void keyReleased (KeyEvent e){
    
    
    }

    

  
    
}
