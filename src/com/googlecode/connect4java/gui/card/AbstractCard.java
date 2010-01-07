package com.googlecode.connect4java.gui.card;

import javax.swing.JPanel;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.AbstractListener;

/**
 * (replaces AbstractPanel.java)
 * @author noxan
 * @version 0.7.16
 * @since 0.2
 */
public abstract class AbstractCard extends JPanel {
	private static final long serialVersionUID = -8553906927095969797L;
	
	public MainGui gui;
	protected AbstractListener listener;
	
	public AbstractCard(MainGui gui, AbstractListener listener) {
		this.gui = gui;
		this.listener = listener;
		setOpaque(false);
	}
	
	protected abstract void initComponents();
}
