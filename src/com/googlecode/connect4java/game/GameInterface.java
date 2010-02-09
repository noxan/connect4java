package com.googlecode.connect4java.game;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldListener;

/**
 * Game Interface
 * @author richard.stromer
 * @version 1.0.25
 * @since 0.1
 * @see Game
 */
public interface GameInterface extends FieldListener {
	public boolean setToken(int column);
	public void reset();
	
	public Player getActive();
	/**
	 * Returns the (active) field of the game.
	 * @return the field of the game
	 * @since 0.0.1
	 * @see Field
	 */
   public Field getField();
}