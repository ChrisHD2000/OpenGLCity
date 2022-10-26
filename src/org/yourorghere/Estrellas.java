
package org.yourorghere;
import java.util.ArrayList;
import javax.media.opengl.GL;
import java.util.Random;

public class Estrellas {
    GL gl;
    public float x,y,z;
    private boolean esDia;
    ArrayList<Esfera> NubeEstrellas = new ArrayList<Esfera>();
     ArrayList<Esfera> auxiliar = new ArrayList<Esfera>();
   // ArrayList<Esfera> auxiliar = new ArrayList<Esfera>();
    public  Estrellas(float x, float y, float z, boolean esDia, int numero, GL gl){
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.esDia= esDia;
        
        for (int i = 1; i<=numero;i++){
            for(int j = 1; j<= numero; j++){
                Random rand = new Random();
                int n = rand.nextInt(10)+1;
                if(n>=5){
                    this.NubeEstrellas.add(new Esfera(n,7*j+n,5*i+n,0.1f,0.1f,0.1f,Test.materiales.get("brillante"),1,10,10,gl ));
                }
                else
                    this.NubeEstrellas.add(new Esfera(-n,7*j-n,5*i-n,0.1f,0.1f,0.1f,Test.materiales.get("brillante"),1,10,10,gl ));
            }
        }
      
        
     this.auxiliar = (ArrayList<Esfera>) NubeEstrellas.clone();
        
    }
    
    public void display(){
    gl.glPushMatrix();
    gl.glTranslatef(x,y,z);
    
        if(Test.esDia == false){
             NubeEstrellas = (ArrayList<Esfera>) auxiliar.clone();
             for(Esfera NubeEstrellas:NubeEstrellas){
                     NubeEstrellas.display();
            }
        }
       else
            this.NubeEstrellas.clear();
    
 
   
     
    gl.glPopMatrix();   
    }
}


