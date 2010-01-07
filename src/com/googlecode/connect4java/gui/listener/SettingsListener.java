package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.MainGui;

/**
 * 
 * @author noxan
 * @version 0.6.12
 * @since 0.4.9
 */
public class SettingsListener extends AbstractListener {
	public SettingsListener(MainGui gui) {
		super(gui);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand(); 
		
		if(action.equals("$b_back")) {
			gui.showCard(GuiCard.MENU);
		}
	}
}
