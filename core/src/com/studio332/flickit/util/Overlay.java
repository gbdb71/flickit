/**
 * FlickIt!
 * Overlay.java
 * 
 * Created by Lou Foster
 * Copyright Studio332 2013. All rights reserved.
 */
package com.studio332.flickit.util;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.studio332.flickit.FlickIt;

public class Overlay extends Image {
   
   public Overlay() {
      super( Assets.instance().getPixel() );
      setSize(FlickIt.TGT_WIDTH, FlickIt.TGT_HEIGHT);
      setColor(0.0f,0.0f, 0.0f, 0.0f);
      setTouchable(Touchable.disabled);
   }
   
   public void dimScreen() {
      setTouchable(Touchable.enabled);
      setColor(0.0f,0.0f, 0.0f, 0.0f);
      addAction( FlickItActions.fadeTo(0.7f, 0.5f) );
   }
   
   public void fadeOut() {
      setTouchable(Touchable.disabled);
      addAction( Actions.fadeOut(0.5f) );
   }
}
