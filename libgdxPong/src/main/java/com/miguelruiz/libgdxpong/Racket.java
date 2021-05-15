package com.miguelruiz.libgdxpong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Miguel Ángel Ruiz-Valdepeñas Fernández
 */
public abstract class Racket {
   
    protected Texture texture;
    protected Rectangle rectangle;
    protected byte directionY;
    protected Ball ball;
    protected short VEL_Y;
    protected final float POS_X;
    protected final float POS_Y;
    
    
    public Racket(float posX, float posY,Ball ball){
        this.POS_X=posX;
        this.POS_Y=posY;
        VEL_Y=500;
        texture= new Texture("images/racket.png");
        rectangle= new Rectangle(POS_X,POS_Y,texture.getWidth(),texture.getHeight());
        this.ball=ball;
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
    
    public abstract void crashBall();
    public abstract void update(float delta);
}
