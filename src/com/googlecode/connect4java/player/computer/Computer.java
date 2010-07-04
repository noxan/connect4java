package com.googlecode.connect4java.player.computer;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.player.Player;

public interface Computer extends Player {
	public int getTurn(Field<?> field);
}
