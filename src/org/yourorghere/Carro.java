package org.yourorghere;
import javax.media.opengl.GL;
public class Carro {
    public float x,y,z;
    public float rx,ry;
    public Cubo carcaza1, carcaza2,carcaza3;
    public Cilindro llanta1, llanta2, llanta3, llanta4;
    public Cubo ventana;
    public GL gl;
    public Material material;
    
    public Carro(float x, float y, float z, float rx, float ry, Material material, GL gl){
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.gl=gl;
        
        this.llanta1 = new Cilindro(0,0,-0.1f,1.5f,1.5f,1.3f,0,0,Test.materiales.get("negro"),0.2f,0.2f,15,15,gl);
     
        this.llanta2 = new Cilindro(0,0,-0.1f,1.5f,1.5f,1.3f,0,0,Test.materiales.get("negro"),0.1f,0.1f,15,15,gl);
        
        this.llanta3 = new Cilindro(3,0,0,1.5f,1.5f,1.1f,0,0,Test.materiales.get("negro"),0.2f,0.2f,15,15,gl);
       
        this.llanta4 = new Cilindro(3,0,0,1.5f,1.5f,1.1f,0,0,Test.materiales.get("negro"),0.1f,0.1f,15,15,gl);
        this.carcaza1 = new Cubo(1,1f,0.8f,1.5f,0.7f,1,0,0,material, gl);
        this.carcaza2 = new Cubo(3f,0.9f,0.8f,0.5f,0.7f,0.7f,0,0,Test.materiales.get("blanco"), gl);
        this.carcaza3 = new Cubo(3.6f,0.5f,0.8f,0.4f,0.3f,0.7f,0,0,Test.materiales.get("blanco"), gl);
    }
    public void display(){
    gl.glPushMatrix();
    gl.glTranslatef(x,y,z);
    gl.glRotatef(rx,1,0,0);
    gl.glRotatef(ry,0,1,0);
    llanta1.display();
    llanta2.display();
    llanta3.display();
    llanta4.display();
    carcaza1.display();
    carcaza2.display();
    carcaza3.display();
    gl.glPopMatrix();
    }
    public void avanzarx(float inc){
    this.x+=inc;
    }
    public void avanzarz(float inc){
    this.z+=inc;
    }
   
    
    public void parar(){
    
    this.x+=0f;
    this.z-=0f;
    }      
   
          
}
