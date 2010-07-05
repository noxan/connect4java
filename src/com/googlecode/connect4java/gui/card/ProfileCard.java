package com.googlecode.connect4java.gui.card;

import javax.swing.JButton;

import info.clearthought.layout.TableLayout;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.ProfileListener;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 1.1
 */
public class ProfileCard extends AbstractCard {
	private static final long serialVersionUID = 7011751919075160426L;
	private JButton backButton;
	
	public ProfileCard(MainGui gui) {
		super(gui);
		double[][] size = {{TableLayout.FILL, 100, MainGui.MARGIN}, 
				{TableLayout.FILL, TableLayout.PREFERRED, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	@Override
	protected void initComponents() {
		ProfileListener listener = new ProfileListener(this);
		
		backButton = new JButton("Back");
		backButton.addActionListener(listener);
		add(backButton, "1,1");
	}
	
	@Override
	public void update() {
	}
}
