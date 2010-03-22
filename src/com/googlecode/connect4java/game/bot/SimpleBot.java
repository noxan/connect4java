package com.googlecode.connect4java.game.bot;

import java.util.Random;

/**
 * 
 * @author richard
 * @version 1.1b1
 * @since 1.1b1
 */
public class SimpleBot implements Bot {
	public SimpleBot() {
		
	}
	
	@Override
	public int getColumn() {
		return new Random().nextInt(6);
	}
}
