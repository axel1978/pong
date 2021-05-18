
package com.miguelruiz.libgdxpong;




/**
 *
 * @author Miguel Ángel Ruiz-Valdepeñas Farnández
 */
public class RacketRight extends Racket {
    
    
    
    public RacketRight(float posX, float posY,Ball ball) {
        super(posX, posY,ball);
        VEL_Y=350;
    }

    @Override
    public void update(float delta) {
        float rktCoordinate=rectangle.y + rectangle.height/2;
        float ballCoordinate=ball.getPosition().y +ball.getPosition().height/2;
        directionY=0;
        crashBall();
        
        if(rktCoordinate>=ballCoordinate -20 && rktCoordinate<=ballCoordinate +20 ){
            rktCoordinate=ballCoordinate;
            directionY=0;
        }
        
        if(rktCoordinate < ballCoordinate & !crashUP()){
            directionY=1;
            
        }else if(rktCoordinate > ballCoordinate & !crashDown()){
            directionY=-1;
        }
        
        rectangle.y+= VEL_Y*directionY*delta;
        
    }

    @Override
    public void crashBall() {
        if(rectangle.overlaps(ball.getPosition())){
           HIT.play();
           byte direction=-1;
           ball.setDirectionX(direction);
        }
    }
    
}
