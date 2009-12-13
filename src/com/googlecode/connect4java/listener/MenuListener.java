package com.googlecode.connect4java.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.googlecode.connect4java.gui.MainGUI;
import com.googlecode.connect4java.net.Update;

/**
 * 
 * @author noxan
 * @since 0.4.9
 * @version 0.4.9
 */
public class MenuListener implements ActionListener {
	private MainGUI gui;
	
	public MenuListener(MainGUI gui) {
		this.gui = gui;
	}
	
	@Override public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		
		if(action.equals("$b_network")) {
			gui.showCard(MainGUI.CARD_NETWORK);
		} else if(action.equals("$b_update")) {
			gui.setStatus("Contacting update site...", true);
			try {
				Update.update();
				if(Update.isUpdate()) {
					gui.setStatus("Update available", false);
					JOptionPane.showMessageDialog(gui.frame, "<html>A new version, "+Update.getString()+" is available!<br>http://connect4java.googlecode.com</html>", "Update available", JOptionPane.INFORMATION_MESSAGE);
				} else {
					gui.setStatus("No update available", false);
					JOptionPane.showMessageDialog(gui.frame, "Congratulations, this is the very latest version!", "No update available", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (IOException e) {
				gui.setStatus("Connection problem", false);
				JOptionPane.showMessageDialog(gui.frame, "Unable to access update-server.\nPlease check your computer's network connection and try again later.", "Connection error", JOptionPane.ERROR_MESSAGE);
			}
			gui.setStatus("Ready", false);
		} else if(action.equals("$b_settings")) {
			gui.showCard(MainGUI.CARD_SETTINGS);
		} else if(action.equals("$b_local")) {
			gui.showCard(MainGUI.CARD_LOCAL);
		} else if(action.equals("$b_exit")) {
			System.exit(0);
		}
	}

}
