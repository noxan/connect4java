package com.googlecode.connect4java.game;

/**
 * Game Interface
 * @author noxan
 * @version 0.0.1
 * @since 0.0.1
 * @see Game
 */
public interface GameInterface {
	/**
	 * Returns the (active) field of the game.
	 * @return the field of the game
	 * @since 0.0.1
	 * @see Field
	 */
	public Field getField();
}
