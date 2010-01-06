package com.googlecode.connect4java.gui.card;

import javax.swing.JPanel;

import com.googlecode.connect4java.gui.MainGui;

/**
 * 
 * (replaces AbstractPanel.java)
 * 
 * @author noxan
 * @version 0.5.11
 * @since 0.2
 */
public class AbstractCard extends JPanel {
	private static final long serialVersionUID = -8553906927095969797L;
	
	protected MainGui gui;
	
	public AbstractCard(MainGui gui) {
		this.gui = gui;
		setOpaque(false);
	}
}
