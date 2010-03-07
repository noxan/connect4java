package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.NetworkCard;

/**
 * 
 * @author richard.stromer
 * @version 1.0.28
 * @since 0.6.12
 */
public class NetworkListener extends AbstractListener<NetworkCard> {
	public NetworkListener(NetworkCard card) {
		super(card);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		card.getGui().showCard(GuiCard.MENU);
	}
}
