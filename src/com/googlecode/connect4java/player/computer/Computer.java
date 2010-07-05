package com.googlecode.connect4java.player.computer;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldValue;
import com.googlecode.connect4java.player.Player;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 1.1
 */
public interface Computer extends Player {
	public int getTurn(Field<FieldValue> field);
}
