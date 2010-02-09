package com.googlecode.connect4java.game;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldEvent;
import com.googlecode.connect4java.field.FieldListener;
import com.googlecode.connect4java.field.FieldValue;
import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.card.GameCard;

/**
 * 
 * @author noxan
 * @version 1.0.23
 * @since 1.0.22
 */
public class LocalGame implements GameInterface, FieldListener {
	private MainGui gui;
	private GameCard card;
	private int active;
	private Player[] players;
	private Field field;
	
	public LocalGame(MainGui gui, GameCard card) {
		this.gui = gui;
		this.card = card;
		field = new Field();
		field.addFieldListener(this);
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
	public void handleFieldEvent(FieldEvent event) {
		System.out.println(event.getField());
		if(event.getField().isWin()) {
			JOptionPane.showMessageDialog(gui.getFrame(), "One player won the game!\nClick to return to the previous panel. ", "Win", JOptionPane.INFORMATION_MESSAGE);
			card.reset();
			gui.showCard(GuiCard.LOCAL);
		}
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
		card.getRoundPanel().switchPlayer();
		gui.update();
	}
}
