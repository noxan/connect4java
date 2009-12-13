package com.googlecode.connect4java.gui;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

import javax.swing.JButton;

import com.googlecode.connect4java.listener.SettingsListener;

/**
 * 
 * @author noxan
 * @since 0.1
 * @version 0.4.9
 */
public class SettingsPanel extends AbstractPanel {
	private static final long serialVersionUID = 1L;
	
	private SettingsListener listener;
	
	private JButton backButton;
	
	public SettingsPanel(MainGUI gui) {
		super(gui, new Color(200, 50, 50));
		listener = new SettingsListener(gui);
		
		initLayout();
		initComponents();
	}
	
	private void initLayout() {
		double[][] size = {{TableLayout.FILL, 100, MainGUI.MARGIN}, 
				{TableLayout.FILL, TableLayout.PREFERRED, MainGUI.MARGIN}};
		setLayout(new TableLayout(size));
	}

	private void initComponents() {
		backButton = new JButton("Back");
		backButton.setActionCommand("$b_back");
		backButton.addActionListener(listener);
		add(backButton, "1,1");
	}
}
