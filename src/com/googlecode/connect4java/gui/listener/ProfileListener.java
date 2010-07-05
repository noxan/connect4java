package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.ProfileCard;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 1.1
 */
public class ProfileListener extends AbstractListener<ProfileCard> {
	public ProfileListener(ProfileCard card) {
		super(card);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		card.getGui().showCard(GuiCard.MENU);
	}
}
