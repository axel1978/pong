
package com.miguelruiz.libgdxpong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 *
 * @author Miguel Ángel Ruiz-Valdepeñas Fernández
 */
public class RacketLeft extends Racket {

    public RacketLeft(float posX, float posY,Ball ball) {
        super(posX, posY,ball);
        VEL_Y=800;
    }

    
    @Override
    public void update(float delta) {
    directionY=0;
        
    if(Gdx.input.isKeyPressed(Keys.W) & !crashUP()){
          directionY=1;
          
       }else if(Gdx.input.isKeyPressed(Keys.S) & !crashDown()){
          directionY=-1;  
       }
       rectangle.y+= VEL_Y*directionY*delta;
       crashBall();
    }
    
    

    @Override
    public void crashBall() {
        if(rectangle.overlaps(ball.getPosition())){
           byte direction=1;
           ball.setDirectionX(direction);
        }
  
    }
    
}
