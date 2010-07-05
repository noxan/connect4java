package com.googlecode.connect4java.player.computer;

import java.awt.Color;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldValue;
import com.googlecode.connect4java.player.AbstractPlayer;
import com.googlecode.connect4java.player.PlayerType;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 1.1
 */
public abstract class AbstractComputer extends AbstractPlayer implements Computer {
	public AbstractComputer(String name, Color color) {
		super(name, color, PlayerType.COMPUTER);
	}
	
	@Override
	public abstract int getTurn(Field<FieldValue> field);
	
}
