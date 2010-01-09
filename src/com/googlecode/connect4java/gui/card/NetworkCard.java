package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import javax.swing.JButton;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.NetworkListener;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.1
 */
public class NetworkCard extends AbstractCard {
	private static final long serialVersionUID = 1L;
	
	private JButton backButton;
	
	public NetworkCard(MainGui gui) {
		super(gui);
		double[][] size = {{TableLayout.FILL, 100, MainGui.MARGIN}, 
				{TableLayout.FILL, TableLayout.PREFERRED, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	protected void initComponents() {
		NetworkListener listener = new NetworkListener(this);
		
		backButton = new JButton("Back");
		backButton.addActionListener(listener);
		add(backButton, "1,1");
	}
}
