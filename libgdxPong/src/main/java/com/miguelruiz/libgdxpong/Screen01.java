
package com.miguelruiz.libgdxpong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Miguel Ángel Ruiz-Valdepeñas Fernández
 */
public class Screen01 extends Screens {
    private Texture background;
    private SpriteBatch batch;
    private Racket racketLeft;
    private Racket racketRight;
    private Ball ball;
    
    public Screen01(Pong pong) {
        super(pong);
    }

    @Override
    public void show() {
        background = new Texture("images/background.png");
        batch = new SpriteBatch();
        ball= new Ball(Gdx.graphics.getWidth()/2 ,Gdx.graphics.getHeight()/2);
        racketLeft= new RacketLeft(10f,Gdx.graphics.getHeight()/2,ball);
        racketRight=new RacketRight(Gdx.graphics.getWidth() - 42, Gdx.graphics.getHeight()/2,ball);
    }
    

    @Override
    public void render(float delta) {
      	Gdx.gl.glClearColor(0,0,0,1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  
        ball.update(delta);
        racketLeft.update(delta);
        racketRight.update(delta);
        batch.begin();
        batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        ball.draw(batch);
        racketLeft.draw(batch);
        racketRight.draw(batch);
        batch.end();
    }

  
       
    
    @Override
    public void dispose() {
       ball.dispose();
       batch.dispose();
       background.dispose();
     
    }
    
}
