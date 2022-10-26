/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.util.ArrayList;
import javax.media.opengl.GL;

/**
 *
 * @author fing.labcom
 */
public class Personaje implements Movil {
    GL gl;
    float x,y,z;
    float auxY;
    float w,h,d;
    float rx, ry;
    int dir = 1;
    // definimos los objetos del personaje
    ArrayList<Proyectil> proyectiles = new ArrayList<Proyectil>();
    Cubo cubito, cubito2, cubito3, cubito4, cubito5, cubito6, cubito7, cubito8;
    Cubo cuerpo;
    Piramide aletast, punta;
    Cilindro turbina, turbina2, turbina3;
    Esfera turbinaIn, turbinaIn2, turbinaIn3, ventana;
    public Personaje(float x, float y, float z, float w, float h, float d,float rx ,float ry, GL gl){
        this.x=x;
        this.y=y;
        this.z=z;
        this.auxY = y;
        this.w=w;
        this.h=h;
        this.d=d;
        this.rx = rx;
        this.ry = ry;
        this.gl=gl;
        this.cubito = new Cubo(0,0,0,1f,0.4f,0.8f,0,0,Test.materiales.get("marron"),gl);
        this.cubito2 = new Cubo(0,0.47f,-0.5f,1f,0.05f,0.14f,0,0,Test.materiales.get("rojo"),gl);
        this.cubito3 = new Cubo(0,0.47f,0.5f,1f,0.05f,0.14f,0,0,Test.materiales.get("rojo"),gl);
        this.cubito4 = new Cubo(-0.3f,0.47f,0f,0.18f,0.05f,0.3f,0,0,Test.materiales.get("rojo"),gl);
        this.cubito5 = new Cubo(1,0f,-0.5f,0.05f,0.5f,0.14f,0,0,Test.materiales.get("rojo"),gl);
        this.cubito6 = new Cubo(1,0f,0.5f,0.05f,0.5f,0.14f,0,0,Test.materiales.get("rojo"),gl);
        this.cubito7 = new Cubo (0,0,0,0.4f,0.36f,1.8f,0,0,Test.materiales.get("amarillo"),gl);
        this.aletast = new Piramide(0,0,0,0.2f,1,4f,0,0,Test.materiales.get("amarillo"),gl);
        this.cubito8 = new Cubo (0,0.65f,0,0.2f,0.25f,1.5f,0,0,Test.materiales.get("amarillo"),gl);
        this.cuerpo = new Cubo (2,-0f,0,1f,0.4f,0.8f,0,0,Test.materiales.get("rojo"),gl);
        this.punta = new Piramide (3f,0,0,0.5f,0.4f,0.5f,0,45,Test.materiales.get("amarillo"),gl);
        this.turbina= new Cilindro(-1.5f,0,0, // x y z
                                    1,1,1, // w h d
                                    0,90, // rx ry
                                    Test.materiales.get("rojo"), // r g b
                                    0.4f, 0.4f, // raido 1 radio 2
                                    20,20,gl); // slices, stacks, gl
        this.turbina2= new Cilindro(-1f,-0.7f,-2, // x y z
                                    1,1,1, // w h d
                                    0,90, // rx ry
                                    Test.materiales.get("rojo"), // r g b
                                    0.4f, 0.4f, // raido 1 radio 2
                                    20,20,gl); // slices, stacks, gl
        this.turbinaIn = new Esfera(-1.5f,0,0, // x y z
                                    0,1,1, // w h d
                                    Test.materiales.get("negro"), // r g b
                                    0.4f, // raido 1 radio 2
                                    20,20,gl); // slices, stacks, gl
          this.turbinaIn2 = new Esfera(-1f,-0.7f,-2, // x y z
                                    0,1,1, // w h d
                                    Test.materiales.get("negro"), // r g b
                                    0.4f, // raido 1 radio 2
                                    20,20,gl); // slices, stacks, gl
        this.turbina3= new Cilindro(-1f,-0.7f,2, // x y z
                                    1,1,1, // w h d
                                    0,90, // rx ry
                                    Test.materiales.get("rojo"), // r g b
                                    0.4f, 0.4f, // raido 1 radio 2
                                    20,20,gl); // slices, stacks, gl
         this.turbinaIn3 = new Esfera(-1f,-0.7f,2, // x y z
                                    0,1,1, // w h d
                                    Test.materiales.get("negro"), // r g b
                                    0.4f, // raido 1 radio 2
                                    20,20,gl); // slices, stacks, gl
        this.ventana  = new Esfera (2f,0.35f,0, // x y z
                                    2,1,1, // w h d
                                    Test.materiales.get("celeste"), // r g b
                                    0.4f, // raido 1 radio 2
                                    20,20,gl); // slices, stacks, gl
        
    }
    public void display(){
       gl.glPushMatrix();
       gl.glTranslatef(x,y,z);
       gl.glRotatef(rx,1,0,0);
       gl.glRotatef(-ry,0,1,0);  
       gl.glScalef(w,h,d);
       
        cubito.display();
        cubito2.display();
        cubito3.display();
        cubito4.display();
        cubito5.display();
        cubito6.display();
        cubito7.display();
        aletast.display();
        cubito8.display();
        turbina.display();
        turbinaIn.display();
        turbina2.display();
        turbinaIn2.display();
        turbina3.display();
        turbinaIn3.display();
        cuerpo.display();
        punta.display();
        ventana.display();
        
       gl.glPopMatrix();
        
    }
    public void disparar(){
        proyectiles.add(new Proyectil(this.x, this.y, this.z,this.rx, this.ry, 3f, 1000, gl));
        
    }
    public void avanzar(){
    this.z+=Math.sin(Math.toRadians(ry))*0.5f;
    this.x+=Math.cos(Math.toRadians(ry))*0.5f;
    }
    public void retroceder(){
    this.z-=Math.sin(Math.toRadians(ry))*0.5f;
    this.x-=Math.cos(Math.toRadians(ry))*0.5f;
    }
       public void izquierda(){
      this.z+=Math.sin(Math.toRadians(ry-90))*0.5f;
    this.x+=Math.cos(Math.toRadians(ry-90))*0.5f;
    }
          public void derecha(){
      this.z+=Math.sin(Math.toRadians(ry+90))*0.5f;
    this.x+=Math.cos(Math.toRadians(ry+90))*0.5f;
          }
    public void incrementarAnguloX(float incrementox){
       this.rx+=incrementox*0.5f;
    }
    public void incrementarAnguloY(float incrementoy){
        this.ry+=incrementoy*0.5f;
    }
    public void actuar(){
        
    ArrayList<Proyectil> paborrar = new ArrayList<Proyectil>();
    for(Proyectil p: proyectiles){
        p.actuar();
        p.display();
        if(p.tiempo<1 ){
            paborrar.add(p);
        }
    }
    for(Proyectil p: paborrar){
      
        if(p.tiempo<1 ){
            proyectiles.remove(p);
        }
    }
    if(this.y<=this.auxY+0.5f && dir== 1){
        this.y += 0.007f;
    }
    if(this.y>=this.auxY-0.5f && dir== -1 ){
        this.y -= 0.007f;
    }
    if(this.y>=this.auxY+0.5f ){
        dir=-1;
        }
      if(this.y<=this.auxY-0.5f ){
        dir=1;
        }
    }
 

    
    
    
}
