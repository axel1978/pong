
package com.miguelruiz.libgdxpong;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



/**
 *
 * @author Miguel Ángel Ruiz-Valdepeñas Fernández
 */
public class Pong extends Game{
    private SpriteBatch batch;
    
    @Override
    public void create() {
    	batch= new SpriteBatch();
    	AllScreens.pong=this;
    	AllScreens.screenGame = new ScreenGame(batch);
    	AllScreens.screenMenu = new ScreenMenu(batch);
        this.setScreen(AllScreens.screenMenu);
    }
    
    
    
    public void dispose() {
    	AllScreens.screenMenu.dispose();
    }
    
}
