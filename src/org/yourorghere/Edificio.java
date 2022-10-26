
package org.yourorghere;
import java.util.ArrayList;
import javax.media.opengl.GL;
import java.util.Random;
/**
 *
 * @author Christian
 */
public class Edificio {
    GL gl;
    public float x,y,z;
    public float w,h,d;
    public float rx,ry;
    public Cubo bloque, bloque2;
    public Cubo puerta1, puerta2;
    
    ArrayList<Cubo> ventanas = new ArrayList<Cubo>();
    ArrayList<Cubo> ventanas2 = new ArrayList<Cubo>();   
    public Esfera techo;
    public Piramide antena;
    
    public Edificio(float x, float y, float z, float w, float h, float d, float rx, float ry, GL gl){
        this.x = x;
        this.y=y;
        this.z=z;
        this.w=w;
        this.h=h;
        this.d=d;
        this.rx=rx;
        this.ry=ry;
        this.gl=gl;
        this.bloque = new Cubo(0,0.3f,0,1,1.3f,1,0,0,Test.materiales.get("rojo"),gl);
        this.bloque2 = new Cubo(0,0.8f,0,0.7f,1.3f,0.7f,0,0,Test.materiales.get("rojo"),gl);
        this.puerta1 = new Cubo(0.3f,-0.7f,-0.1f,  1.4f,0.14f,0.1f,0,0,Test.materiales.get("edificio"),gl);
        this.puerta2 = new Cubo(0.3f,-0.7f,0.2f,  1.4f,0.14f,0.1f, 0,0,Test.materiales.get("edificio"),gl);
        this.techo = new Esfera(0,2.3f,-0f,0.3f,0.2f,0.3f,Test.materiales.get("rojo"),2,10,10,gl);
        for(int i = 0; i<=9; i++){
            for(int j=0; j<=5; j++){
                Random rand = new Random();
                int n = rand.nextInt(10)+1;
                if(n>=5){
                    
                    this.ventanas.add(new Cubo(-0.88f,i*0.2f-0.35f,j*0.3f-.7f,   0.13f,0.05f,0.08f,0,0,Test.materiales.get("edificio"),gl));
                }
                else
                this.ventanas.add(new Cubo(-0.88f,i*0.2f-0.35f,j*0.3f-.7f,   0.13f,0.05f,0.08f,0,0,Test.materiales.get("celeste"),gl));
            }
        }
        
                for(int i = 0; i<=9; i++){
            for(int j=0; j<=5; j++){
                
                this.ventanas2.add(new Cubo(-0.88f,i*0.2f-0.35f,j*0.3f-.7f,   0.13f,0.05f,0.08f,0,0,Test.materiales.get("celeste"),gl));
            }
        }
        
        
        this.antena = new Piramide(-0.2f,2.8f,-0f,0.1f,0.8f,0.1f,0,0,Test.materiales.get("azul"),gl);
    }
    public void display(){
    gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glScalef(w,h,d);
        
        puerta1.display();
        bloque.display();
        bloque2.display();
        puerta2.display();
        techo.display();
        antena.display();
        
        if(Test.esDia==false){
            
             for(Cubo ventana:ventanas){
                ventana.display();
        }
        }
        else{
            
            for(Cubo ventana2:ventanas2){
                 ventana2.display();
        }
        }
       
     gl.glPopMatrix();   
    
    
    }
}
