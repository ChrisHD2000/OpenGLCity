package org.yourorghere;
import javax.media.opengl.GL;
public class Arbol {
    GL gl;
    float x,y,z;
    float w,h,d;
    float rx,ry;
    Piramide base, media, alta;
    Cilindro tronco;
    public Arbol(float x, float y, float z, float w, float h, float d, float rx, float ry, GL gl){
    this.x = x;
    this.y = y;
    this.z = z ;
    this.w=w;
    this.h=h;
    this.d=d;
    this.rx=rx;
    this.ry=ry;
    this.gl=gl;
    this.base = new Piramide(0,0.7f,0,0.6f,0.6f,0.6f,0,0,Test.materiales.get("hojas"),gl);
    this.media = new Piramide(0,1.2f,0,0.4f,0.6f,0.6f,0,0,Test.materiales.get("hojas"),gl);
    this.alta = new Piramide(0,1.6f,0,0.3f,0.6f,0.6f,0,0,Test.materiales.get("hojas"),gl);
    this.tronco = new Cilindro (0,1,0,0.4f,0.4f,5,90,0,Test.materiales.get("marron"),0.5f,0.5f,4,4,gl);
    }
    public void display(){
    gl.glPushMatrix();
    gl.glTranslatef(x,y,z);
    gl.glRotatef(rx,1,0,0);
    gl.glRotatef(ry,0,1,0);
    gl.glScalef(w, h, d);
    tronco.display();
    base.display();
    media.display();
    alta.display();
    gl.glPopMatrix();
    }
    
}
