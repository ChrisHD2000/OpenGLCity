/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author fing.labcom
 */
public class ManejadorRaton implements MouseMotionListener {
    float oldx, oldy;
    Movil personaje;
   
    public ManejadorRaton(Movil p){
        this.personaje = p;
    }
    public void mouseDragged(MouseEvent e) {
       
    }

    public void mouseMoved(MouseEvent e) {
       float x = e.getX();
       float y = e.getY();
       personaje.incrementarAnguloY(x-oldx);
       //personaje.incrementarAnguloX( y-oldy);
       oldx=x;
       oldy=y;
       
    }
    
}
