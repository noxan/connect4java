package com.googlecode.connect4java.gui;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.googlecode.connect4java.net.Update;

/**
 * 
 * @author noxan
 * @since 0.1
 * @version 0.3.8
 */
public class MenuPanel extends AbstractPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton localButton;
	private JButton networkButton;
	private JButton settingsButton;
	private JButton exitButton;
	
	public MenuPanel(MainGUI gui) {
		super(gui, new Color(50, 200, 50));
		double[][] size = {{MainGUI.MARGIN, 200, TableLayout.FILL}, 
				{TableLayout.FILL, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	private void initComponents() {
		localButton = new JButton("Local Game");
		localButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				getMainGUI().showCard(MainGUI.CARD_LOCAL);
			}
		});
		add(localButton, "1,1");
		
		networkButton = new JButton("Network Game");
		networkButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				getMainGUI().showCard(MainGUI.CARD_NETWORK);
			}
		});
		add(networkButton, "1,3");
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent evt) {
				getMainGUI().setStatus("Contacting update site...", true);
				try {
					Update.update();
					if(Update.isUpdate()) {
						getMainGUI().setStatus("Update available", false);
						JOptionPane.showMessageDialog(getMainGUI().frame, "<html>A new version, "+Update.getString()+" is available!<br>http://connect4java.googlecode.com</html>", "Update available", JOptionPane.INFORMATION_MESSAGE);
					} else {
						getMainGUI().setStatus("No update available", false);
						JOptionPane.showMessageDialog(getMainGUI().frame, "Congratulations, this is the very latest version!", "No update available", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException e) {
					getMainGUI().setStatus("Connection problem", false);
					JOptionPane.showMessageDialog(getMainGUI().frame, "Unable to access update-server.\nPlease check your computer's network connection and try again later.", "Connection error", JOptionPane.ERROR_MESSAGE);
				}
				getMainGUI().setStatus("Ready", false);
			}
		});
		add(updateButton, "1,5");
		
		settingsButton = new JButton("Settings");
		settingsButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				getMainGUI().showCard(MainGUI.CARD_SETTINGS);
			}
		});
		add(settingsButton, "1,7");
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(exitButton, "1,9");
	}
}
