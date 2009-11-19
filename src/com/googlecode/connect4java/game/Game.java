package com.googlecode.connect4java.game;

/**
 * 
 * @author noxan
 * @since 0.1
 * @version 0.3.8
 */
public class Game implements GameInterface {
	private Field field;
	
	public Game() {
		field = new Field();
	}
	
	@Override
	public Field getField() {
		return field;
	}

}
