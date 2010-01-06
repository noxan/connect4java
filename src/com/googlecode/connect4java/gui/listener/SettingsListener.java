package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.card.GuiCard;

/**
 * 
 * @author noxan
 * @version 0.5.11
 * @since 0.4.9
 */
public class SettingsListener implements ActionListener {
	private MainGui gui;
	
	public SettingsListener(MainGui gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand(); 
		
		if(action.equals("$b_back")) {
			gui.showCard(GuiCard.MENU);
		}
	}
}
