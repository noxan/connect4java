package com.googlecode.connect4java.game;

import java.awt.Color;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.field.DefaultField;
import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldListener;
import com.googlecode.connect4java.field.FieldStatus;
import com.googlecode.connect4java.field.FieldValue;
import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.card.GameCard;
import com.googlecode.connect4java.player.Player;
import com.googlecode.connect4java.player.PlayerManager;
import com.googlecode.connect4java.player.computer.Computer;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 1.0
 */
public class LocalGame implements GameInterface {
	private MainGui gui;
	private GameCard card;
	private int active;
	private Player[] players;
	private Field<FieldValue> field;
	
	public LocalGame(MainGui gui, GameCard card) {
		this.gui = gui;
		this.card = card;
		field = new DefaultField();
		field.addFieldListener(this);
		players = new Player[2];
		PlayerManager.get("player");
		players[0] = PlayerManager.get("default");
		players[1] = PlayerManager.get("computer(easy)");
		active = 0;
		
		Core.pref.addPreferenceChangeListener(new PreferenceChangeListener() {
			@Override
			public void preferenceChange(PreferenceChangeEvent evt) {
				String key = evt.getKey();
				String value = evt.getNewValue();
				if(value!=null) {
					if("player.name".equals(key)) {
						players[0].setName(value);
					} else if("computer.name".equals(key)) {
						players[1].setName(value);
					} else if("player.color".equals(key)) {
						players[0].setColor(new Color(Integer.valueOf(value)));
					} else  if("computer.color".equals(key)) {
						players[1].setColor(new Color(Integer.valueOf(value)));
					}
				}
			}
		});
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
	public void click(int column) {
		if(isDrawn() || isWin()) {
			card.getGui().showCard(GuiCard.LOCAL);
			reset();
		} else {
			FieldValue value = (active==0?FieldValue.PLAYER1:FieldValue.PLAYER2);
			//computer test
			if(getActive().isComputer()) {
				column = ((Computer) getActive()).getTurn(field.clone());
			}
			if (field.add(column, value)) {
				// change active
				changeActive();
				// update gui
				gui.update();
			}
		}
	}
	
	private void changeActive() {
		if (active == 0) {
			active = 1;
		} else {
			active = 0;
		}
	}
	
	@Override
	public boolean isWin() {
		return field.isWin();
	}
	@Override
	public boolean isDrawn() {
		return field.isDrawn();
	}
	@Override
	public FieldValue get(int column, int row) {
		return field.get(column, row);
	}
	public Field<FieldValue> getField() {
		return field;
	}
	
	@Override
	public void reset() {
		field.reset();
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
