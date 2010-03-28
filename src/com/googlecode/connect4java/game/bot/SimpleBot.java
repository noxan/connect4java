package com.googlecode.connect4java.game.bot;

import java.awt.Color;
import java.util.Random;

import com.googlecode.connect4java.game.Player;

/**
 * 
 * @author richard
 * @version 1.1b2(r31)
 * @since 1.1b1
 */
public class SimpleBot implements Bot {
	private Player player;
	
	public SimpleBot() {
		player = new Player("SimpleBot", new Color(0));
	}
	
	@Override
	public int getColumn() {
		return new Random().nextInt(6);
	}
	
	@Override
	public Player getPlayer() {
		return player;
	}
}
