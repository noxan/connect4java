package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.SettingsCard;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.4.9
 */
public class SettingsListener extends AbstractListener<SettingsCard> {
	public SettingsListener(SettingsCard card) {
		super(card);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand(); 
		
		if(action.equals("$b_back")) {
			card.gui.showCard(GuiCard.MENU);
		}
	}
}
