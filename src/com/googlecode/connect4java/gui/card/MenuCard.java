package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import javax.swing.JButton;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.MenuListener;

/**
 * 
 * @author noxan
 * @version 0.6.12
 * @since 0.1
 */
public class MenuCard extends AbstractCard {
	private static final long serialVersionUID = 1L;
	
	private JButton localButton;
	private JButton networkButton;
	private JButton settingsButton;
	private JButton exitButton;
	
	public MenuCard(MainGui gui) {
		super(gui, new MenuListener(gui));
		
		initLayout();
		initComponents();
	}
	
	private void initLayout() {
		double[][] size = {{MainGui.MARGIN, 200, TableLayout.FILL}, 
				{TableLayout.FILL, TableLayout.PREFERRED, MainGui.PADDING, TableLayout.PREFERRED, MainGui.PADDING, TableLayout.PREFERRED, MainGui.PADDING, TableLayout.PREFERRED, MainGui.PADDING, TableLayout.PREFERRED, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
	}
	
	protected void initComponents() {
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
