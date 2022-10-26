
package org.yourorghere;
import javax.media.opengl.GL;

import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
public class Piramide {
    GL gl;
    float x,y,z;
    float w,h,d;
    Material material;
    float rx,ry;
    
    public Piramide (float x, float y, float z, float w, float h, float d, float rx, float ry, Material material, GL gl){
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
    this.h = h;
    this.d = d;
    this.material = material;
    this.rx = rx;
    this.ry = ry;
    this.gl = gl;
    }
    
    public void display(){
        gl.glPushMatrix();
        GLU glu = new GLU();
        this.material.activar();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glScalef(w,h,d);
        GLUquadric piramide = glu.gluNewQuadric();
        glu.gluSphere(piramide, 1, 4,2 );
        glu.gluNewQuadric();
        
        
        gl.glPopMatrix();
    }
    
    
}
