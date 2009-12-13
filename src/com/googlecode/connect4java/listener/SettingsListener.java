package com.googlecode.connect4java.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.googlecode.connect4java.gui.MainGUI;

/**
 * 
 * @author noxan
 * @since 0.4.9
 * @version 0.4.9
 */
public class SettingsListener implements ActionListener {
	private MainGUI gui;
	
	public SettingsListener(MainGUI gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand(); 
		
		if(action.equals("$b_back")) {
			gui.showCard(MainGUI.CARD_MENU);
		}
	}
}
