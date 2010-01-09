package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.CloseCard;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.6.12
 */
public class CloseListener extends AbstractListener<CloseCard> {
	public CloseListener(CloseCard card) {
		super(card);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		String action = evt.getActionCommand();
		if("$b_yes".equals(action)) {
			card.gui.frame.dispose();
		} else if("$b_no".equals(action)) {
			card.gui.showCard(GuiCard.MENU);
		}
	}
}
