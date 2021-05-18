package com.miguelruiz.libgdxpong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.audio.Wav.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Miguel Ángel Ruiz-Valdepeñas Fernández
 */
public abstract class Racket{
   
    protected Texture texture;
    protected Rectangle rectangle;
    protected byte directionY;
    protected Ball ball;
    protected short VEL_Y;
    protected final float POS_X;
    protected final float POS_Y;
    protected final Sound HIT;
    
    
    public Racket(float posX, float posY,Ball ball){
        this.POS_X=posX;
        this.POS_Y=posY;
        VEL_Y=500;
        texture= new Texture("images/racket.png");
        rectangle= new Rectangle(POS_X,POS_Y,texture.getWidth(),texture.getHeight());
        this.ball=ball;
        HIT =  (Sound) Gdx.audio.newSound(Gdx.files.internal("sounds/pong_hit.wav"));
    }
    
    public void draw(SpriteBatch batch){
        batch.draw(texture, rectangle.x,rectangle.y);
    }
    
    public Texture getTexture(){
        return texture;
    }
    
    public boolean crashUP(){
        return rectangle.y +rectangle.getHeight()>Gdx.graphics.getHeight();
    }
    
    public boolean crashDown(){
        return rectangle.y<5;
    }
    
    public void dispose() {
    	texture.dispose();
        HIT.dispose();
    }
    public abstract void crashBall();
    public abstract void update(float delta);
}
