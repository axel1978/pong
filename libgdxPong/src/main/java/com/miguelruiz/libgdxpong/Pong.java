
package com.miguelruiz.libgdxpong;

import com.badlogic.gdx.Game;



/**
 *
 * @author Miguel Ángel Ruiz-Valdepeñas Fernández
 */
public class Pong extends Game{
    private Screens screen01;
    
    @Override
    public void create() {
        screen01= new Screen01(this);
        this.setScreen(screen01);
    }
    
}
