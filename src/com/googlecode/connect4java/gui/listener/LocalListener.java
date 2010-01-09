package com.googlecode.connect4java.gui.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.LocalCard;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.6.12
 */
public class LocalListener extends AbstractListener<LocalCard> {
	public LocalListener(LocalCard card) {
		super(card);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if("$b_color1".equals(action)) {
			final int color1 = Main.pref.getInt("player.color", 255);
			Color res = JColorChooser.showDialog(card.gui.frame, "Local Player: Color", new Color(color1));
			if(res!=null) {
				Main.pref.put("player.color", Integer.toString(res.getRGB()));
			}
		} if("$b_color2".equals(action)) {
			final int color2 = Main.pref.getInt("computer.color", -65536);
			Color res = JColorChooser.showDialog(card.gui.frame, "Computer Player: Color", new Color(color2));
			if(res!=null) {
				Main.pref.put("computer.color", Integer.toString(res.getRGB()));
			}
		} else if("$b_back".equals(action)) {
			card.gui.showCard(GuiCard.MENU);
		} else if("$b_start".equals(action)) {
			card.gui.showCard(GuiCard.GAME);
		}
	}
}
