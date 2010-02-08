package com.googlecode.connect4java.game;

import java.awt.Color;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldValue;
import com.googlecode.connect4java.gui.MainGui;

/**
 * 
 * @author noxan
 * @version 1.0.22
 * @since 1.0.22
 */
public class LocalGame implements GameInterface {
	private MainGui gui;
	private int active;
	private Player[] players;
	private Field field;
	
	public LocalGame(MainGui gui) {
		this.gui = gui;
		field = new Field();
		players = new Player[2];
		players[0] = new Player(Main.pref.get("player.name", "Player"), new Color(Main.pref.getInt("player.color", 255)));
		players[1] = new Player(Main.pref.get("computer.name", "Player"), new Color(Main.pref.getInt("computer.color", -65536)));
		active = 0;
	}
	
	@Override
	public Field getField() {
		return field;
	}
	
	@Override
	public void click(short column) {
		System.out.println(active+" -> "+column);
		if(active!=0) {
			field.add(column, FieldValue.PLAYER1);
			active = 0;
		} else {
			field.add(column, FieldValue.PLAYER2);
			active = 1;
		}
		gui.update();
	}
}
