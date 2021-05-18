package com.miguelruiz.libgdxpong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.audio.Wav.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Miguel Ángel Ruiz-Valdepeñas Fernández
 */
public class Ball {
    private byte directionX;
    private byte directionY;
    private byte golLeft;
    private byte golRight;
    private String result;
    
    private final BitmapFont LEFT;
    private final BitmapFont RIGHT;
    private final BitmapFont RESULT;
    private final Rectangle RECTANGLE;
    private final Texture TEXTURE;
    private final Sound WALL;
    private final Sound FAIL;
    
    private final float VEL_X;
    private final float VEL_Y;
    
    public Ball(float x, float y){
        TEXTURE = new Texture("images/ball.png");
        VEL_X = 1500f;
        VEL_Y = 400f;
        directionX = 1;
        directionY = 1;
        result="";
        RECTANGLE = new Rectangle(x,y,TEXTURE.getWidth(),TEXTURE.getHeight());
        LEFT = new BitmapFont(Gdx.files.internal("fonts/numbers.fnt"),Gdx.files.internal("fonts/numbers.png"),false);
        RIGHT = new BitmapFont(Gdx.files.internal("fonts/numbers.fnt"),Gdx.files.internal("fonts/numbers.png"),false);
        RESULT= new BitmapFont(Gdx.files.internal("fonts/title.fnt"),Gdx.files.internal("fonts/title.png"),false);
        WALL = (Sound) Gdx.audio.newSound(Gdx.files.internal("sounds/pong_wall.wav"));
        FAIL = (Sound) Gdx.audio.newSound(Gdx.files.internal("sounds/pong_fail.wav"));
    }
    
    
    public void draw(SpriteBatch batch){
        batch.draw(TEXTURE,RECTANGLE.x,RECTANGLE.y);
        LEFT.draw(batch,String.valueOf(golLeft),Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()-20);
        RIGHT.draw(batch,String.valueOf(golRight),Gdx.graphics.getWidth()/2+90,Gdx.graphics.getHeight()-20);
        RESULT.draw(batch,result,Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2);
    }
    
    public void update(float delta){
        goal();
        crashUP();
        RECTANGLE.x+=(VEL_X*directionX*delta);
        RECTANGLE.y+=(VEL_Y*directionY*delta);
    }
    
    public void crashUP(){
         if(RECTANGLE.y<0){
        	WALL.play();
            RECTANGLE.y=0;
            directionY=(byte) -directionY;
            
        }else if(RECTANGLE.y + TEXTURE.getHeight()>Gdx.graphics.getHeight()){
        	WALL.play();
            RECTANGLE.y=Gdx.graphics.getHeight()-TEXTURE.getHeight();
            directionY=(byte) -directionY;
        } 
    }
    
    
    private  void goal(){
        
        if(RECTANGLE.x> Gdx.graphics.getWidth()+10){
            FAIL.play();
            golLeft+=1;
            if(golLeft < 10)
                reset((byte) -1);
            else
            	win("left");
            	

        }else if(RECTANGLE.x<-15){
            FAIL.play();
            golRight+=1;
            if(golRight < 10)
                reset((byte) 1);
            else
            	win("right");
        }
    }

    
    public Rectangle getPosition(){
        return RECTANGLE;
    }
    
    public void setDirectionX(byte directionX){
        this.directionX= directionX;
    }
    
    public void setX(float x) {
    	RECTANGLE.x=x;
    }
    
    private void reset(byte dir){
        resetBall();
        Timer timer = new Timer();
        TimerTask task= new TimerTask() {
            
            @Override
            public void run() {
                Random rn= new Random();
                if(rn.nextInt(2)>0){
                    directionY=1;
                }else{
                   directionY=-1; 
                }
                directionX= dir;
                
            }
               
        };
        timer.schedule(task, 1500);
        
    }
    

    
    public void win (String str) {
        resetBall();
    	if(str.equals("left")) {
    		result="You Win";
    	}else if(str.equals("right")) {
    		result= "You Lose";
    	}
    	
        Timer timer = new Timer();
        TimerTask task= new TimerTask() {
            
            @Override
            public void run() {
            	AllScreens.screenGame.setExit(true);
            }
      
        };
        timer.schedule(task, 1500);
    }
    
    private void resetBall() {
        directionX=0;
        directionY=0;
        RECTANGLE.x=Gdx.graphics.getWidth()/2 - RECTANGLE.width/2;
        RECTANGLE.y=Gdx.graphics.getHeight()/2 - RECTANGLE.height/2;
    }
    
    public void dispose(){
        TEXTURE.dispose();
        LEFT.dispose();
        RIGHT.dispose();
        WALL.dispose();
        FAIL.dispose();
    }
 

}
