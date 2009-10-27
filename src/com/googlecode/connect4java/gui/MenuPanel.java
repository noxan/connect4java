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
 * @version 0.2.6
 */
public class MenuPanel extends AbstractPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton singleButton;
	private JButton multiButton;
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
		singleButton = new JButton("Singleplayer");
		singleButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				getMainGUI().showCard(MainGUI.CARD_SINGLE);
			}
		});
		add(singleButton, "1,1");
		
		multiButton = new JButton("Multiplayer");
		multiButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				getMainGUI().showCard(MainGUI.CARD_MULTI);
			}
		});
		add(multiButton, "1,3");
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent evt) {
				try {
					Update.update();
					if(Update.isUpdate()) {
						JOptionPane.showMessageDialog(getMainGUI().frame, "<html>A new version, "+Update.getString()+" is available!<br>http://connect4java.googlecode.com</html>", "Update available", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(getMainGUI().frame, "Congratulations, this is the very latest version!", "No update available", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(getMainGUI().frame, "Unable to access update-server.\nPlease check your computer's network connection and try again later.", "Connection error", JOptionPane.ERROR_MESSAGE);
				}
				
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
