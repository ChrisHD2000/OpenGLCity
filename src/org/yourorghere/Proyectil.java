
package org.yourorghere;

import javax.media.opengl.GL;

public class Proyectil {
    float vel, rotx, roty, x, y, z;
    Cubo cuerpo;
    int tiempo;
    GL gl;
    public Proyectil(float x, float y, float z, float rotx, float roty, float vel, int tiempo, GL gl){
        this.x = x;
        this.y = y;
        this.z = z;
        this.rotx = rotx;
        this.roty = roty;
        this.vel = vel;
        this.tiempo = tiempo;
        this.gl = gl;
        //  Cubo (float x,float y,float z,float w,float h,float d, float rx, float ry, Material material, GL gl)
        cuerpo = new Cubo(0,0,0, .2f,.2f,.2f, 0,0, Test.materiales.get("brillante"),gl);    
    }
    public void display(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        cuerpo.display();
        gl.glPopMatrix();
    }
    public void actuar(){
        x+=Math.cos(Math.toRadians(roty))*vel;
        z+=Math.sin(Math.toRadians(roty))*vel;
        tiempo--;
        
    }
    
}
