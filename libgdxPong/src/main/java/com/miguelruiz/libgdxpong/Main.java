package com.miguelruiz.libgdxpong;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/**
 *
 * @author Miguel Ángel Ruiz-Valdepeñas Fernández
 */
public class Main {
         public static void main (String [] args){
             Lwjgl3ApplicationConfiguration config= new Lwjgl3ApplicationConfiguration();
             config.setIdleFPS(60);
             config.useVsync(true);
             config.setTitle("JPong by Axel1978");
             config.setResizable(false);
             config.setDecorated(true);
             config.setWindowIcon("images/axel.png");
             config.setWindowedMode(1280,800);
             //config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        var app= new Lwjgl3Application(new Pong(),config);
         
    }
}