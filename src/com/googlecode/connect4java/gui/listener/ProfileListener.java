package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.ProfileCard;

public class ProfileListener extends AbstractListener<ProfileCard> {
	public ProfileListener(ProfileCard card) {
		super(card);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		card.getGui().showCard(GuiCard.MENU);
	}
}
