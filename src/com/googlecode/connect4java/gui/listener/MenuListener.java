package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.net.Update;

/**
 * 
 * @author noxan
 * @version 0.6.12
 * @since 0.4.9
 */
public class MenuListener extends AbstractListener {
	public MenuListener(MainGui gui) {
		super(gui);
	}
	
	@Override public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		
		if(action.equals("$b_network")) {
			gui.showCard(GuiCard.NETWORK);
		} else if(action.equals("$b_update")) {
			gui.statusbar.setStatus("Contacting update site...", true);
			new Thread() {
				public void run() {
					try {
						Update.update();
						if(Update.isUpdate()) {
							gui.statusbar.setStatus("Update available", false);
							JOptionPane.showMessageDialog(gui.frame, "<html>A new version, "+Update.getString()+" is available!<br>http://connect4java.googlecode.com</html>", "Update available", JOptionPane.INFORMATION_MESSAGE);
						} else {
							gui.statusbar.setStatus("No update available", false);
							JOptionPane.showMessageDialog(gui.frame, "Congratulations, this is the very latest version!", "No update available", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (IOException e) {
						gui.statusbar.setStatus("Connection problem", false);
						JOptionPane.showMessageDialog(gui.frame, "Unable to access update-server.\nPlease check your computer's network connection and try again later.", "Connection error", JOptionPane.ERROR_MESSAGE);
					}
					gui.statusbar.setStatus("Ready", false);
				};
			}.start();
		} else if(action.equals("$b_settings")) {
			gui.showCard(GuiCard.SETTINGS);
		} else if(action.equals("$b_local")) {
			gui.showCard(GuiCard.LOCAL);
		} else if(action.equals("$b_exit")) {
			gui.showCard(GuiCard.CLOSE);
		}
	}

}
