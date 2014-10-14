/**
 * FlickIt!
 * AbstractScreen.java
 * 
 * Created by Lou Foster
 * Copyright Studio332 2013. All rights reserved.
 */
package com.studio332.flickit.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.studio332.flickit.FlickIt;

public class AbstractScreen  implements Screen  {
   protected final Stage stage;
   protected final FlickIt flickIt;
   
   public AbstractScreen(FlickIt game) {
      this.flickIt = game;
      this.stage = new Stage( new StretchViewport(FlickIt.TGT_WIDTH, FlickIt.TGT_HEIGHT)) {
         @Override
         public boolean keyDown(int keyCode) {
             if (keyCode == Keys.BACK || keyCode == Keys.ESCAPE) {
                if ( backClicked() ) {
                   return true;
                } else {
                   Gdx.app.exit();
                }
             }
             return true;
         }
      };
     
      Gdx.input.setInputProcessor(this.stage);
      Gdx.input.setCatchBackKey(true);
   }
   
   protected Batch getBatch() {
      return this.stage.getBatch();
   }
   
   protected boolean backClicked() {
      // return false to indicate it was not handled
      // by the screen
      return false;
   }

   @Override
   public void render(float delta) {
      Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      
      // update and draw the stage actors
      stage.act( delta );
      stage.draw();
   }

   @Override
   public void resize(int width, int height) {
   }
   
   public Stage getStage() {
      return this.stage;
   }

   @Override
   public void show() {
      // let this screen pocess events (like touch)
      Gdx.input.setInputProcessor( this.stage );
   }

   @Override
   public void hide() {
   }

   @Override
   public void pause() {
   }

   @Override
   public void resume() {
   }

   @Override
   public void dispose() {
      this.stage.dispose();
   }
}
