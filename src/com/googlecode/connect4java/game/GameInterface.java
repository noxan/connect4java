package com.googlecode.connect4java.game;

import com.googlecode.connect4java.field.Field;

/**
 * Game Interface
 * @author noxan
 * @version 1.0.22
 * @since 0.1
 * @see Game
 */
public interface GameInterface {
	/**
	 * @since 1.0.22
	 * @param column
	 */
	public void click(short column);
	/**
     * Returns the (active) field of the game.
     * @return the field of the game
     * @since 0.0.1
     * @see Field
     */
    public Field getField();
}
