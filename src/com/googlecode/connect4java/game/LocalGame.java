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
 * @author richard.stromer
 * @version 1.0.27
 * @since 1.0.22
 */
public class LocalGame implements GameInterface {
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
		players[0] = new Player(Main.pref.get("player.name", "Player"),
				new Color(Main.pref.getInt("player.color", 255)));
		players[1] = new Player(Main.pref.get("computer.name", "Player"),
				new Color(Main.pref.getInt("computer.color", -65536)));
		active = 0;
	}
	
	@Override
	public void handleFieldEvent(FieldEvent event) {
		gui.update(); // fix: update gui before opening dialog
		Field field = (Field) event.getSource();
		if (field.isWin()) {
			card.getRoundPanel().repaint();
			String message = "The winner is " + players[active].getName()
					+ "!\nClick to return to the previous panel.";
			JOptionPane.showMessageDialog(gui.getFrame(), message, "Win",
					JOptionPane.INFORMATION_MESSAGE);
			card.reset();
			gui.showCard(GuiCard.LOCAL);
		}
	}
	
	@Override
	public Player getActive() {
		return players[active];
	}
	@Override
	public Player getInactive() {
		return players[active>0?0:1];
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
	public boolean setToken(int column) {
		FieldValue value = active == 0 ? FieldValue.PLAYER1
				: FieldValue.PLAYER2;
		if (field.add(column, value)) {
			// change active
			changeActive();
			// update gui
			card.getRoundPanel().repaint();
			gui.update();
			return true;
		}
		return false;
	}
	
	private void changeActive() {
		if (active == 0) {
			active = 1;
		} else {
			active = 0;
		}
	}
	
	@Override
	public void addFieldListener(FieldListener listener) {
		field.addFieldListener(listener);
	}
	@Override
	public boolean isWin() {
		return field.isWin();
	}
	@Override
	public FieldValue get(int column, int row) {
		return field.get(column, row);
	}
	
	@Override
	public void reset() {
		changeActive();
		field.reset();
	}
}
