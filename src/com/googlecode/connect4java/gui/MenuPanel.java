package com.googlecode.connect4java.gui;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

import javax.swing.JButton;

import com.googlecode.connect4java.listener.MenuListener;

/**
 * 
 * @author noxan
 * @since 0.1
 * @version 0.4.9
 */
public class MenuPanel extends AbstractPanel {
	private static final long serialVersionUID = 1L;
	
	private MenuListener listener;
	
	private JButton localButton;
	private JButton networkButton;
	private JButton settingsButton;
	private JButton exitButton;
	
	public MenuPanel(MainGUI gui) {
		super(gui, new Color(50, 200, 50));
		listener = new MenuListener(gui);
		
		initLayout();
		initComponents();
	}
	
	private void initLayout() {
		double[][] size = {{MainGUI.MARGIN, 200, TableLayout.FILL}, 
				{TableLayout.FILL, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.MARGIN}};
		setLayout(new TableLayout(size));
	}
	
	private void initComponents() {
		localButton = new JButton("Local Game");
		localButton.setActionCommand("$b_local");
		localButton.addActionListener(listener);
		add(localButton, "1,1");
		
		networkButton = new JButton("Network Game");
		networkButton.setActionCommand("$b_network");
		networkButton.addActionListener(listener);
		add(networkButton, "1,3");
		
		JButton updateButton = new JButton("Update");
		updateButton.setActionCommand("$b_update");
		updateButton.addActionListener(listener);
		add(updateButton, "1,5");
		
		settingsButton = new JButton("Settings");
		settingsButton.setActionCommand("$b_settings");
		settingsButton.addActionListener(listener);
		add(settingsButton, "1,7");
		
		exitButton = new JButton("Exit");
		exitButton.setActionCommand("$b_exit");
		exitButton.addActionListener(listener);
		add(exitButton, "1,9");
	}
}
