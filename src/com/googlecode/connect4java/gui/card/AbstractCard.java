package com.googlecode.connect4java.gui.card;

import javax.swing.JPanel;

import com.googlecode.connect4java.gui.MainGui;

/**
 * (replaces AbstractPanel.java)
 * 
 * @author richard.stromer
 * @version 1.0.28
 * @since 0.2
 */
public abstract class AbstractCard extends JPanel {
	private static final long serialVersionUID = -8553906927095969797L;
	private MainGui gui;
	
	public AbstractCard(MainGui gui) {
		super();
		this.gui = gui;
		setOpaque(false);
	}
	
	public MainGui getGui() {
		return gui;
	}
	
	protected abstract void initComponents();
}
