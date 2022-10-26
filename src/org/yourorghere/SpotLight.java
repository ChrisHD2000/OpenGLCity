/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;


import javax.media.opengl.GL;

public class SpotLight extends Luz {
    float cutoff, exponent;
    float[] direction;
    
    public SpotLight(float[] position, float[] ambient, float[] diffuse, float[] specular, GL gl, int luzopengl, boolean activado,Material bombilla, boolean bombilla_visible, float cutoff, float [] direction, float exponent) {
        super(position, ambient, diffuse, specular, gl, luzopengl, activado, bombilla , bombilla_visible);
        this.cutoff = cutoff;
	this.exponent = exponent;
	this.direction = direction;
        
       
    }
    @Override
 public void display(){
	super.display();
	gl.glLightf(id_luzopengl, GL.GL_SPOT_CUTOFF, this.cutoff);
	gl.glLightfv(id_luzopengl, GL.GL_SPOT_DIRECTION, this.direction, 0);
	gl.glLightf(id_luzopengl, GL.GL_SPOT_EXPONENT, this.exponent);
        gl.glLightf(id_luzopengl, GL.GL_CONSTANT_ATTENUATION , 1.0f);
        
       
} 
    
}
