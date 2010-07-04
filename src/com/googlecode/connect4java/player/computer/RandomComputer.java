package com.googlecode.connect4java.player.computer;

import java.awt.Color;
import java.util.Random;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.player.PlayerType;

public class RandomComputer extends AbstractComputer {
	public RandomComputer(Color color) {
		super("Computer (Random)", color, PlayerType.COMPUTER);
	}

	@Override
	public int getTurn(Field<?> field) {
		return new Random().nextInt(field.getWidth());
	}
	
}
