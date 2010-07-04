package com.googlecode.connect4java.player.human;

import java.awt.Color;

import com.googlecode.connect4java.player.AbstractPlayer;
import com.googlecode.connect4java.player.PlayerType;

public class DefaultPlayer extends AbstractPlayer {
	public DefaultPlayer(String name) {
		this(name, Color.BLACK);
	}
	public DefaultPlayer(String name, Color color) {
		super(name, color, PlayerType.HUMAN);
	}
}
