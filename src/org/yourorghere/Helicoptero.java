package org.yourorghere;

import javax.media.opengl.GL;

public class Helicoptero {
    public float x;
    public float y;
    public float z;
    public float rx;
    public float ry;
    public GL gl;
    public Esfera Pdelantera;
    public Cilindro Ptrasera;
    public Cubo ventana, helice1, helice2, ala;
    
    public Helicoptero(float x, float y, float z,  float rx, float ry, GL gl){
    this.x = x;
    this.y = y;
    this.z = z;
  
    this.rx = rx;
    this.ry = ry;
    this.gl = gl;
    this.Pdelantera = new Esfera(0,0,0,2f,2f,2f,Test.materiales.get("rojo"),0.25f,18,18,gl);    
    this.Ptrasera = new Cilindro(0,0,0,2f,2f,1f,0,0,Test.materiales.get("rojo"),0.25f,0,18,18,gl);
   this.ventana = new Cubo(0,0.2f,-0.3f,0.4f,0.2f,0.2f,0,0,Test.materiales.get("celeste"),gl);
   this.helice1 = new Cubo(0,0.7f,0,0.1f,0.05f,2,0,0,Test.materiales.get("marron"),gl);
    this.helice2 = new Cubo(0,0.7f,0,0.1f,0.05f,2,0,90,Test.materiales.get("marron"),gl);
    this.ala = new Cubo(0f,0f,1.9f,0.1f,0.5f,0.1f,0,90,Test.materiales.get("rojo"),gl);
    }
    public void display(){
        gl.glPushMatrix();
        gl.glRotatef(ry, 0, 1, 0);
        
        gl.glTranslatef(x,y,z);
       // gl.glRotatef(30,0,0,1);
       
        Pdelantera.display();
        Ptrasera.display();
        ventana.display();
       helice1.display();
       helice2.display();
       ala.display();
        gl.glPopMatrix();
        
    }
    public void actuar(){
   // this.z-=.5;
    this.ry+=1;
    this.helice1.ry+= 14;
    this.helice2.ry+=14;
    }
    
    
}
