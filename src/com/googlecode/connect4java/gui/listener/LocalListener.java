package com.googlecode.connect4java.gui.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.MainGui;

/**
 * 
 * @author noxan
 * @version 0.7.16
 * @since 0.6.12
 */
public class LocalListener extends AbstractListener {
	public LocalListener(MainGui gui) {
		super(gui);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if("$b_color1".equals(action)) {
			final int color1 = Main.pref.getInt("player.color", 255);
			Color res = JColorChooser.showDialog(gui.frame, "Local Player: Color", new Color(color1));
			if(res!=null) {
				Main.pref.put("player.color", Integer.toString(res.getRGB()));
			}
		} if("$b_color2".equals(action)) {
			final int color2 = Main.pref.getInt("computer.color", -65536);
			Color res = JColorChooser.showDialog(gui.frame, "Computer Player: Color", new Color(color2));
			if(res!=null) {
				Main.pref.put("computer.color", Integer.toString(res.getRGB()));
			}
		} else if("$b_back".equals(action)) {
			gui.showCard(GuiCard.MENU);
		} else if("$b_start".equals(action)) {
			gui.showCard(GuiCard.GAME);
		}
	}
}
