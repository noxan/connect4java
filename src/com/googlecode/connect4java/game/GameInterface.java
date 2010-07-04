package com.googlecode.connect4java.game;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldListener;
import com.googlecode.connect4java.field.FieldValue;
import com.googlecode.connect4java.player.Player;

/**
 * Game Interface
 * 
 * @author richard.stromer
 * @version 1.1b4(r34)
 * @since 0.1
 * @see Game
 */
public interface GameInterface extends FieldListener<FieldValue> {
	public void click(int column);
	
	public void addFieldListener(FieldListener<FieldValue> listener);
	
	public FieldValue get(int column, int row);
	public boolean isWin();
	public boolean isDrawn();
	public void reset();
	
	public Player getActive();
	public Player getInactive();
	public Player getPlayer(int index);
	public Player[] getPlayers();
	
	public Field<FieldValue> getField();
}