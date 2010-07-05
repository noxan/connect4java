package com.googlecode.connect4java.player.computer;

import java.awt.Color;
import java.util.Random;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldValue;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 1.1
 */
public class RandomComputer extends AbstractComputer {
	public RandomComputer(Color color) {
		super("Computer (Random)", color);
	}

	@Override
	public int getTurn(Field<FieldValue> field) {
		return new Random().nextInt(field.getWidth());
	}
	
}
