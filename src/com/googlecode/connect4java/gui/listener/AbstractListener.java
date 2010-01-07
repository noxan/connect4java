package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionListener;

import com.googlecode.connect4java.gui.MainGui;

/**
 * 
 * @author noxan
 * @version 0.6.12
 * @since 0.6.12
 */
public abstract class AbstractListener implements ActionListener {
	protected MainGui gui;
	
	public AbstractListener(MainGui gui) {
		this.gui = gui;
	}
}
