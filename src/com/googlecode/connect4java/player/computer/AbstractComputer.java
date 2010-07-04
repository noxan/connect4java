package com.googlecode.connect4java.player.computer;

import java.awt.Color;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.player.AbstractPlayer;
import com.googlecode.connect4java.player.PlayerType;

public abstract class AbstractComputer extends AbstractPlayer implements Computer {
	public AbstractComputer(String name, Color color, PlayerType type) {
		super(name, color, type);
	}
	
	@Override
	public abstract int getTurn(Field<?> field);
	
}
