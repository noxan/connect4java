package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.CloseCard;

/**
 * 
 * @author richard.stromer
 * @version 1.0.28
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
			card.getGui().exit();
		} else if("$b_no".equals(action)) {
			card.getGui().showCard(GuiCard.MENU);
		}
	}
}
