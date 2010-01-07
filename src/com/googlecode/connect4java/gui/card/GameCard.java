package com.googlecode.connect4java.gui.card;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.GameListener;

/**
 * 
 * @author noxan
 * @version 0.6.12
 * @since 0.5.11
 */
public class GameCard extends AbstractCard {
	private static final long serialVersionUID = -1775250517657176595L;

	public GameCard(MainGui gui) {
		super(gui, new GameListener(gui));
	}

	@Override
	protected void initComponents() {
		
	}
}
