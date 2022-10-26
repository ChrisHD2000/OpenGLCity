package org.yourorghere;
import javax.media.opengl.GL;
public class Casa {
    GL gl;
    float x,y,z;
    float w,h,d;
    float rx,ry;
    Cubo pared, ventana, puerta, chimenea;
    Piramide techo;
    
    public Casa (float x, float y, float z, float w, float h, float d, float rx, float ry, GL gl){
        this.x =x;
        this.y =y;
        this.z =z;
        this.w =w;
        this.h =h;
        this.d =d;
        this.rx = rx;
        this.ry = ry;
        this.gl = gl;
        this.pared = new Cubo (0, 0, 0, 1, 1, 1, 0,0, Test.materiales.get("rojo"), gl);
        this.ventana = new Cubo(-0.5f,0.5f,1, 0.25f, 0.25f, 0.01f, 0, 0,Test.materiales.get("edificio"),gl);
        this.puerta = new Cubo (0,-0.5f,0.8f, 0.15f, 0.45f, .25f,0,0,Test.materiales.get("negro"),gl);
        this.chimenea = new Cubo (0.25f, 0.8f,-0.7f,0.2f,1.8f,0.2f,0,0,Test.materiales.get("amarillo"),gl) ;
        this. techo = new Piramide(0,1.1f,0,1.5f,2,1.5f,0,45,Test.materiales.get("amarillo"),gl);
    }
    public void display(){
    gl.glPushMatrix();
    gl.glTranslatef(x,y,z);
    gl.glRotatef(rx,1,0,0);
    gl.glRotatef(ry,0,1,0);
    gl.glScalef(w, h, d);
    pared.display();
    ventana.display();
    puerta.display();    
    chimenea.display();
    techo.display();
    gl.glPopMatrix();
    }
    public void actuar(){
    this.ry-=1.8;
    }
    
}
