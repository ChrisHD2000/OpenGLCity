package org.yourorghere;
import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;




public class Test implements GLEventListener {
Luz Luz1;
SpotLight luzHelicoptero;
ManejadorTeclado mt;
Personaje p;
Cubo cube;
ManejadorRaton mr;
public static boolean esDia = false;
float xlhelip, ylhelip, zlhelip, normalhelip;
ArrayList<Casa> casas = new ArrayList<Casa>();
ArrayList<Arbol> arboles = new ArrayList<Arbol>();
ArrayList<Arbol> bosque1 = new ArrayList<Arbol>();
ArrayList<Arbol> bosque2 = new ArrayList<Arbol>();
ArrayList<Piramide> cesped1 = new ArrayList<Piramide>();
ArrayList<Piramide> cesped2 = new ArrayList<Piramide>();
ArrayList<Cubo> calle1 = new ArrayList<Cubo>();
ArrayList<Cubo> calle2 = new ArrayList<Cubo>();
Arbol arbol;
Carro carro1, carro2, carro3, carro4;
Helicoptero heli1;
Cubo vereda1, vereda2, vereda3, vereda4, vereda5;
Estrellas estrellas;

Esfera monte1, monte2, monte3, monte4, monte5, monte6, monte7, monte8, monte9, monte10,sol;
Cubo puente, borde, puente2, borde2;
public static Hashtable <String, Material> materiales;
Edificio empire;
float r,g,b;
float inv;
    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Test());
        frame.add(canvas);
        frame.setSize(1280, 720);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
       // Pir = new Piramide(-5,0,-14,1,1,1,1.0f,1.0f,1.0f,0,0,gl); 
             //casa = new Casa(0,0,-14,1,1,1, 1,0,1, 0,0, gl);
             gl.glEnable(GL.GL_LIGHTING);
             float [] SpotL1pos = {0,7,-25, 1};
             float [] spotL1dir = {0,-1,0,1};
             float [] aSpotL1 = {110,110,110,0.9f};
             float [] dSpotL1 = {60,60,60,1};
             float[] sSpotL1 = {0,0,0,1};
             

             
             
             
             float [] posluz1 = {-3,-8,-2,1};
           //  float [] aluz1 = {255, 220, 200, 1};
             float [] aluz1 = {250, 250, 250, 1};
             float [] dluz1 = {60, 60, 60, 1};
             float[] sluz1 = {0,0,0,1};
             materiales = new Hashtable<String, Material>();
           
            
             //////////// MATERIALES /////////////////////////////////
            
            ////////////////////////////////// ROJO /////////////////////////
             float [] arojo = {120,0,0};
             float [] drojo = {120,120,120};
             float [] srojo = {11,10,10};
             float [] erojo = {0,0,0};
             float shrojo = 0;
             Material rojo = new Material(arojo, drojo, srojo, erojo, shrojo, gl);
             materiales.put("rojo", rojo);
             ////////////////////////////////// AZUL /////////////////////////
             float [] aazul = {0,0,120};
             float [] dazul = {120,120,120};
             float [] sazul = {10,10,0};
             float [] eazul = {0,0,0};
             float shazul = 0;
             Material azul = new Material(aazul, dazul, sazul, eazul, shazul, gl);
             materiales.put("azul", azul);            
             ////////////////////////////////// AMARILLO /////////////////////////
             float [] aamarillo = {150,120,0};
             float [] damarillo = {120,120,120};
             float [] samarillo = {5,5,5};
             float [] eamarillo= {0,0,0};
             float shamarillo = 0;
             Material amarillo = new Material(aamarillo, damarillo, samarillo, eamarillo, shamarillo, gl);
             materiales.put("amarillo", amarillo);   
             ////////////////////////////////// MARRON /////////////////////////
             float [] amarron = {50,29,10};
             float [] dmarron = {120,120,120};
             float [] smarron = {0,0,0};
             float [] emarron= {0,0,0};
             float shmarron = 0;
             Material marron = new Material(amarron, dmarron, smarron, emarron, shmarron, gl);
             materiales.put("marron", marron);
             ////////////////////////////////// PASTO /////////////////////////
             float [] apasto = {15, 75, 5};
             float [] dpasto = {120,120,120};
             float [] spasto = {0,0,0};
             float [] epasto= {0,0,0};
             float shpasto = 0;
             Material pasto = new Material(apasto, dpasto, spasto, epasto, shpasto, gl);
             materiales.put("pasto", pasto);  
              ////////////////////////////////// HOJAS ARBOL /////////////////////////
             float [] ahojas = {10, 75, 0};
             float [] dhojas = {120,120,120};
             float [] shojas = {10,10,10};
             float [] ehojas= {0,0,0};
             float shhojas = 0;
             Material hojas = new Material(ahojas, dhojas, shojas, ehojas, shhojas, gl);
             materiales.put("hojas", hojas);  
             ////////////////////////////////// CEMENTO /////////////////////////
             float [] acemento = {50, 50, 50};
             float [] dcemento= {60,60,60};
             float [] scemento = {0,0,0};
             float [] ecemento= {0,0,0};
             float shcemento = 0;
             Material cemento = new Material(acemento, dcemento, scemento, ecemento, shcemento, gl);
             materiales.put("cemento", cemento);  
             ////////////////////////////////// CELESTE /////////////////////////
             float [] aceleste = {0, 50, 100};
             float [] dceleste= {120,120,120};
             float [] sceleste = {0,0,0};
             float [] eceleste= {0,0,0};
             float shceleste = 0;
             Material celeste = new Material(aceleste, dceleste, sceleste, eceleste, shceleste, gl);
             materiales.put("celeste", celeste);  
                ////////////////////////////////// NEGRO /////////////////////////
             float [] anegro = {0, 0, 0};
             float [] dnegro= {0,0,0};
             float [] snegro = {0,0,0};
             float [] enegro= {0,0,0};
             float shnegro = 0;
             Material negro = new Material(anegro, dnegro, snegro, enegro, shnegro, gl);
             materiales.put("negro", negro);  
                  ////////////////////////////////// BLANCO /////////////////////////
             float [] ablanco = {150, 150, 150};
             float [] dblanco= {75,75,75};
             float [] sblanco = {0,0,0};
             float [] eblanco= {0,0,0};
             float shblanco = 0;
             Material blanco = new Material(ablanco, dblanco, sblanco, eblanco, shblanco, gl);
             materiales.put("blanco", blanco);  
             ////////////////////////////////// LUZ BRILLANTE /////////////////////////
             float [] abrillante = {255, 250, 230};
             float [] dbrillante= {0,0,0};
             float [] sbrillante = {0,0,0};
             float [] ebrillante= {255,255,255};
             float shbrillante = 1;
             Material brillante = new Material(abrillante, dbrillante, sbrillante, ebrillante, shbrillante, gl);
             materiales.put("brillante", brillante);  
               ////////////////////////////////// EMISIVO SOL /////////////////////////
             float [] asol = {150,120,0};
             float [] dsol= {0,0,0};
             float [] ssol = {0,0,0};
             float [] esol= {255,230,0};
             float shsol = 0;
             Material solmat = new Material(asol, dsol, ssol, esol, shsol, gl);
             materiales.put("sol", solmat);  
             ////////////////////////////////// EDIFICIO LUCES /////////////////////////
             float [] aedif = {255,245,235};
             float [] dedif= {0,0,0};
             float [] sedif = {0,0,0};
             float [] eedif= {255,155,55};
             float shedif = 0;
             Material edif = new Material(aedif, dedif, sedif, eedif, shedif, gl);
             materiales.put("edificio", edif);  
             
                heli1 = new Helicoptero (5,7,5,0,0,gl);
                 //float [] SpotL1pos = {heli1.x,7,heli1.z, 1};
               
             estrellas = new Estrellas(60,0,-67,esDia,20,gl);
             
             for(int i=0; i<=6; i++){
             casas.add(new Casa(i*4,0,-14,1,1,1,0,0,gl));
             casas.add(new Casa(i*4,0,0,1,1,1,0,180,gl));

             }
             for(int i=0; i<=6; i++){
             arboles.add(new Arbol(2+i*4,0,-14,1,1,1,0,180,gl));
             arboles.add(new Arbol(2+i*4,0,0,1,1,1,0,180,gl));
             }
             for(int i = 0; i<=13; i++){
                 for (int j =0;j<=6;j++){
                 bosque1.add(new Arbol(1+i*2,0,5+j*3f,1,1,1,0,180,gl));
                 }
             }
             for(int i = 0; i<=13; i++){
                 for (int j =0;j<=6;j++){
                 bosque1.add(new Arbol(-3+i*2,0,-17-j*3f,1,1,1,0,180,gl));
                 }
             }
             
              for(int i = 0; i<=33; i++){
                 for (int j =0;j<=8;j++){
                     //calle1.add(new Cubo(12.7f,-1.4f,-7,16,0,5,0,0,materiales.get("cemento"),gl));
                     calle1.add(new Cubo(-2.7f+i*1f,-1.4f,-11f+j*1f,0.5f,0.01f,0.5f,0,0,materiales.get("cemento"),gl));
                     
                 }
             }
                for(int i = 0; i<=10; i++){
                 for (int j =0;j<=50;j++){
                     //calle1.add(new Cubo(12.7f,-1.4f,-7,16,0,5,0,0,materiales.get("cemento"),gl));
                     
                      calle2.add(new Cubo(30.3f+i,-1.4f,-37+j,0.5f,0.01f,0.5f,0,0,materiales.get("cemento"),gl));
                 }
             }
             vereda1 = new Cubo(12.7f,-1.2f,-14,16,0.2f,2.5f,0,0,materiales.get("cemento"),gl);
             
             vereda2 = new Cubo(12.7f,-1.2f,0,16,0.2f,2.5f,0,0,materiales.get("cemento"),gl);
             
            
             vereda3= new Cubo(29.75f,-1.2f,-26.54f,15,0.2f,1,0,90,materiales.get("cemento"),gl);
             vereda4= new Cubo(29.75f,-1.2f,12.54f,15,0.2f,1,0,90,materiales.get("cemento"),gl);
             vereda5 = new Cubo(41.7f,-1.2f,-7.1f,30,0.2f,1,0,90,materiales.get("cemento"),gl);
             
            // cesped1.add( new Cubo (12.7f,-1.6f,-28,0.5f,0.2f,0.5f,0,0,materiales.get("pasto"),gl));
             for (int i = 1; i<=37; i++){
                 for(int j = 1; j<=25 ; j++){
                 cesped1.add( new Piramide (30.7f-i,-1.6f,-40+j,0.75f,0.5f,0.75f,0,45,materiales.get("pasto"),gl));
                 }                 
             }
             //cesped2 = new Cubo (12.9f,-1.6f,12.8f,16,0.2f,10.15f,0,0,materiales.get("pasto"),gl);
               for (int i = 1; i<=37; i++){
                 for(int j = 1; j<=25 ; j++){
                 cesped1.add( new Piramide (30.7f-i,-1.6f,0.8f+j,0.75f,0.5f,0.75f,0,45,materiales.get("pasto"),gl));
                 }                 
             }
             carro1 = new Carro (0,-0.78f,-6,0,0,materiales.get("amarillo"),gl);
             carro2 = new Carro (36,-0.78f,2,0,90,materiales.get("rojo"),gl);

             carro3 = new Carro (33,-0.78f,-30f,0,-90,materiales.get("marron"),gl);
             carro4 = new Carro (33,-0.78f,-38f,0,-90,materiales.get("celeste"),gl);      
             if(esDia==false){
                 float [] aluz = {0, 0, 0, 1};
             }
             if(esDia==true){
                 float [] aluz = {145, 145, 145, 1};
             }
            
             
             monte1 = new Esfera (0,-1.2f,-40,7,7,7,materiales.get("pasto"),1,29,29,gl);
             monte2 = new Esfera (10,-1.2f,-40,6,11,6,materiales.get("pasto"),1,29,29,gl);
             monte3 = new Esfera (15,-1.2f,-40,5,5,5,materiales.get("pasto"),1,29,29,gl);
             monte4 = new Esfera (25,-1.2f,-50,7,8,7,materiales.get("pasto"),1,29,29,gl);
             monte5 = new Esfera (35,-1.2f,-50,15,12,15,materiales.get("pasto"),1,20,19,gl);
             monte6 = new Esfera (0,-1.2f,20,7,7,7,materiales.get("pasto"),1,29,29,gl);
             monte7 = new Esfera (10,-1.2f,20,6,11,6,materiales.get("pasto"),1,29,29,gl);
             monte8 = new Esfera (15,-1.2f,20,5,5,5,materiales.get("pasto"),1,29,29,gl);
             monte9 = new Esfera (25,-1.2f,30,7,8,7,materiales.get("pasto"),1,29,29,gl);
             monte10 = new Esfera (35,-1.2f,30,15,12,15,materiales.get("pasto"),1,20,29,gl);
             
             borde= new Cubo (35,-1.2f,-40,6.2f,5,7,0,0,materiales.get("cemento"),gl);
             puente= new Cubo (35.5f,-1.2f,-39.9f,4.25f,3,7,0,0,materiales.get("negro"),gl);
             borde2= new Cubo (35,-1.2f,20,6.2f,5,7,0,0,materiales.get("cemento"),gl);
             puente2= new Cubo (35.5f,-1.2f,19.99f,4.25f,3,7,0,0,materiales.get("negro"),gl);
             empire = new Edificio(48,7,-7,5,10,5,0,0,gl);
             sol = new Esfera(48,30,-30,2,2,2,materiales.get("brillante"),1,10,10,gl);
             inv =1;
             p = new Personaje(1f,5f,-7f,0.4f,0.4f,0.4f,0f,0f,gl);
             cube = new Cubo (1f,-3f,0f,10f,1f,10f,0f,0f,materiales.get("blanco"),gl);
             mt = new ManejadorTeclado(p);
             mr = new ManejadorRaton(p);
        drawable.addMouseMotionListener(mr);
         
         Luz1 = new Luz(posluz1,aluz1,dluz1,sluz1,gl,GL.GL_LIGHT0,true, materiales.get("sol"), true);
        luzHelicoptero = new SpotLight(SpotL1pos ,aSpotL1,dSpotL1,sSpotL1,gl,GL.GL_LIGHT1,true,materiales.get("brillante"), false, 14,spotL1dir,1);
               
        drawable.addKeyListener(mt);
        // Enable VSync,
        gl.setSwapInterval(1);
        gl.glEnable(GL.GL_DEPTH_TEST);

        // Setup the drawing area and shading mode
       
           gl.glClearColor(0.0f, 0.1f, 0.2f, 0.4f); 
        
            
        
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        
        glu.gluPerspective(60.0f, h, 1.0, 90.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        
        GL gl = drawable.getGL();
        if(esDia==false){
           gl.glClearColor(0.0f, 0.1f, 0.2f, 0.4f); 
        }
        else
            gl.glClearColor(0.0f, 0.7f, 0.9f, 1f); 
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
      
        //calle
         if(mt.ncamera==1){
           //glu.gluLookAt(2+p.x, 7,-10, p.x,0 ,0 , 0, 1, 0);
           //glu.gluLookAt(8, 14,0, 1,0 ,0 , 0, 1, 0);
           p.w = 0;
           p.h=0;
           p.d=0;
            glu.gluLookAt(p.x, p.y, p.z,
             p.x+Math.cos(Math.toRadians(p.ry)), p.y ,p.z+Math.sin(Math.toRadians(p.ry)), 
                  0, 1, 0);
       }
       if(mt.ncamera==2){
           //glu.gluLookAt(-2+p.x, 5,-5, p.x,0 ,0 , 0, 1, 0);
           p.w = 1;
           p.h=1;
           p.d=1;
           glu.gluLookAt(p.x+Math.cos(Math.toRadians(p.ry))-15, p.y+2, p.z+Math.sin(Math.toRadians(p.ry)-15),
           p.x+Math.cos(Math.toRadians(p.ry)), p.y ,p.z+Math.sin(Math.toRadians(p.ry)), 
                  0, 1, 0);
       }
       if(mt.ncamera==3){
             p.w = 1;
           p.h=1;
           p.d=1;
           //glu.gluLookAt(-2+p.x, 5,-5, p.x,0 ,0 , 0, 1, 0);
           glu.gluLookAt(p.x, p.y+40, p.z,
                   p.x+Math.cos(Math.toRadians(p.ry)), p.y ,p.z+Math.sin(Math.toRadians(p.ry)), 
                  0, 1, 0);
                   //System.out.println(p.x+" , "+p.y+" , "+p.z);
       }
        if(mt.ncamera==4){
             p.w = 1;
           p.h=1;
           p.d=1;
           glu.gluLookAt(-2, 7,10, 14,7 ,-7 , 0, 1, 0); 
        
       }
        vereda1.display();
        vereda2.display();
        
        vereda3.display();
        vereda4.display();
        vereda5.display();
        
        borde.display();
        puente.display();
        borde2.display();
        puente2.display();
        
        estrellas.display();
        //areas verdes
         for (Piramide cesped1:cesped1){
        cesped1.display();
        }
         for (Piramide cesped2:cesped2){
        cesped2.display();
        }
         for(Cubo calle1:calle1){
             calle1.display();
         }
            for(Cubo calle2:calle2){
             calle2.display();
         }
       
        monte1.display();
        monte2.display();
        monte3.display();
        monte4.display();
        monte5.display();
        monte6.display();
        monte7.display();
        monte8.display();
        monte9.display();
        monte10.display();
        if(esDia==false){
        sol.material = materiales.get("brillante");
        sol.display();
        float [] aluz1 = {0, 0, 0, 1};
        Luz1.ambient = aluz1;
        Luz1.desactivate();
        luzHelicoptero.activate();
        }
        else{
        sol.material = materiales.get("sol");
        sol.display();        
        Luz1.activate();
        luzHelicoptero.desactivate();
        }
        
          for (Arbol arbol:arboles){
        arbol.display();
        }
          for (Arbol bosque:bosque1){
        bosque.display();  
        }
          for (Arbol bosque:bosque2){
        bosque.display();  
        }
        //trafico y animacion
        heli1.display();
        heli1.actuar();
       
        carro1.display();        
        carro2.display();
        carro3.display();
        carro4.display();
        
      
       
        //carro 4
        if(carro4.z<=20 && inv==-1){
    
             carro4.avanzarz(-0.5f);
        }
        if(carro4.z<=20 && inv==1){
      
             carro4.avanzarz(0.3f);
        }
        if(carro4.z>20 && inv==1){
            inv=-1;
            carro4.z=20;
            carro4.x=36;
            carro4.ry = 90;
           
        }
        if(carro4.z<-40 && inv==-1){
            inv=1;
            carro4.z=20;
            carro4.x=36;
            carro4.ry = -90;
            
        }
        
        
        //carro3
        if(carro3.z<=15){
            carro3.avanzarz(0.5f);
        }
        else{
            carro3.z=-40;
            
        }
        //carro 1 y 2
        if(carro1.x<=25){
        carro1.avanzarx(0.3f);
        }
        if(carro1.x>25 ){
        carro1.parar();
        carro2.avanzarz(-0.3f);
        }
        luzHelicoptero.display();
        luzHelicoptero.activate();       
        luzHelicoptero.position[0] = heli1.x+18;   
         luzHelicoptero.position[1] = heli1.y;
        luzHelicoptero.position[2] = heli1.z-12;
        xlhelip = carro1.x - luzHelicoptero.position[0];
        ylhelip = carro1.y - luzHelicoptero.position[1];
        zlhelip = carro1.z - luzHelicoptero.position[2];
        normalhelip = (float) Math.sqrt((carro2.x*carro2.x)+(carro2.y*carro2.y)+(carro2.z*carro2.z));
        luzHelicoptero.direction[0] = xlhelip / normalhelip;
        luzHelicoptero.direction[1] = ylhelip / normalhelip;
        luzHelicoptero.direction[2] = zlhelip / normalhelip;
        
        for(Casa casa:casas){
        casa.display();
        }
       //Edificio   
      empire.display();
        p.display();
        p.actuar();
        
        
        //


        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }
    
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

