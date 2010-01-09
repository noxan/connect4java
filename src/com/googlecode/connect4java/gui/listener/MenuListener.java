package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.MenuCard;
import com.googlecode.connect4java.net.Update;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.4.9
 */
public class MenuListener extends AbstractListener<MenuCard> {
	public MenuListener(MenuCard card) {
		super(card);
	}
	
	@Override public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		
		if(action.equals("$b_network")) {
			card.gui.showCard(GuiCard.NETWORK);
		} else if(action.equals("$b_update")) {
			card.gui.statusbar.setStatus("Contacting update site...", true);
			new Thread() {
				public void run() {
					try {
						Update.update();
						if(Update.isUpdate()) {
							card.gui.statusbar.setStatus("Update available", false);
							JOptionPane.showMessageDialog(card.gui.frame, "<html>A new version, "+Update.getString()+" is available!<br>http://connect4java.googlecode.com</html>", "Update available", JOptionPane.INFORMATION_MESSAGE);
						} else {
							card.gui.statusbar.setStatus("No update available", false);
							JOptionPane.showMessageDialog(card.gui.frame, "Congratulations, this is the very latest version!", "No update available", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (IOException e) {
						card.gui.statusbar.setStatus("Connection problem", false);
						JOptionPane.showMessageDialog(card.gui.frame, "Unable to access update-server.\nPlease check your computer's network connection and try again later.", "Connection error", JOptionPane.ERROR_MESSAGE);
					}
					card.gui.statusbar.setStatus("Ready", false);
				};
			}.start();
		} else if(action.equals("$b_settings")) {
			card.gui.showCard(GuiCard.SETTINGS);
		} else if(action.equals("$b_local")) {
			card.gui.showCard(GuiCard.LOCAL);
		} else if(action.equals("$b_exit")) {
			card.gui.showCard(GuiCard.CLOSE);
		}
	}

}
