package com.googlecode.connect4java.game;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldListener;
import com.googlecode.connect4java.field.FieldValue;

/**
 * Game Interface
 * 
 * @author richard.stromer
 * @version 1.1b2(r31)
 * @since 0.1
 * @see Game
 */
public interface GameInterface extends FieldListener {
	public void click(int column);
	
	public void addFieldListener(FieldListener listener);
	
	public FieldValue get(int column, int row);
	public boolean isWin();
	public boolean isDrawn();
	public void reset();
	
	public Player getActive();
	public Player getInactive();
	public Player getPlayer(int index);
	public Player[] getPlayers();
	
	public Field getField();
}