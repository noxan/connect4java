package com.googlecode.connect4java.game;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldListener;
import com.googlecode.connect4java.field.FieldStatus;
import com.googlecode.connect4java.field.FieldValue;

/**
 * 
 * @author richard.stromer
 * @version 1.1b4(r34)
 * @since 1.1b1
 */
public class ComputerGame implements GameInterface {
	private Field<FieldValue> field;
	private Player players[];
	
	public ComputerGame() {
		players = new Player[2];
		
	}
	
	@Override
	public void click(int column) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public Player getActive() {
		// TODO Auto-generated method stub
		return null;
	}
	public Player getInactive() {
		return null;
	}

	@Override
	public Player getPlayer(int index) {
		return players[index];
	}
	@Override
	public Player[] getPlayers() {
		return players;
	}

	@Override
	public void reset() {
		field.reset();
	}
	@Override
	public FieldValue get(int column, int row) {
		return field.get(column, row);
	}
	@Override
	public Field<FieldValue> getField() {
		return field;
	}
	@Override
	public boolean isDrawn() {
		return field.isDrawn();
	}
	@Override
	public boolean isWin() {
		return field.isWin();
	}
	
	@Override
	public void handleTokenSet(int col, int row, FieldValue e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleStatusChange(FieldStatus status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFieldListener(FieldListener<FieldValue> listener) {
		// TODO Auto-generated method stub
		
	}
}
