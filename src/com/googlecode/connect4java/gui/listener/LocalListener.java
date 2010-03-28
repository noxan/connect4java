package com.googlecode.connect4java.gui.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JColorChooser;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.LocalCard;

/**
 * 
 * @author richard.stromer
 * @version 0.1.29b1
 * @since 0.6.12
 */
public class LocalListener extends AbstractListener<LocalCard> implements
		ItemListener {
	public LocalListener(LocalCard card) {
		super(card);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if("$b_color1".equals(action)) {
			final int color1 = Core.pref.getInt("player.color", 255);
			Color res = JColorChooser.showDialog(card.getGui().getFrame(), "Local Player: Color", new Color(color1));
			if(res != null) {
				Core.pref.putInt("player.color", res.getRGB());
			}
		} else if("$b_color2".equals(action)) {
			final int color2 = Core.pref.getInt("computer.color", -65536);
			Color res = JColorChooser.showDialog(card.getParent(), "Computer Player: Color", new Color(color2));
			if(res != null) {
				Core.pref.putInt("computer.color", res.getRGB());
			}
		} else if("$b_back".equals(action)) {
			card.getGui().showCard(GuiCard.MENU);
		} else if("$b_start".equals(action)) {
			Core.pref.put("player.name", card.getPlayerName());
			Core.pref.put("computer.name", card.getComputerName());
			card.getGui().showCard(GuiCard.GAME);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			if(!e.getItem().toString().isEmpty()) {
				if(card.equalsSlotBox1(e.getSource())) {
					Core.pref.put("player.name", card.getPlayerName());
				} else {
					Core.pref.put("computer.name", card.getComputerName());
				}
			}
		}
	}
}
