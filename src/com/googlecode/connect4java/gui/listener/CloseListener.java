package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.MainGui;

/**
 * 
 * @author noxan
 * @version 0.7.16
 * @since 0.6.12
 */
public class CloseListener extends AbstractListener {
	public CloseListener(MainGui gui) {
		super(gui);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		String action = evt.getActionCommand();
		if("$b_yes".equals(action)) {
			gui.frame.dispose();
		} else if("$b_no".equals(action)) {
			gui.showCard(GuiCard.MENU);
		}
	}
}
