package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.CloseListener;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.6.12
 */
public class CloseCard extends AbstractCard {
	private static final long serialVersionUID = -5215346674843779851L;

	public CloseCard(MainGui gui) {
		super(gui);
		
		double[][] size = {{TableLayout.FILL, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, TableLayout.FILL}, 
				{TableLayout.FILL, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, TableLayout.FILL}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	@Override
	protected void initComponents() {
		CloseListener listener = new CloseListener(this);
		JLabel label = new JLabel("Do you really want to exit?");
		label.setForeground(Color.WHITE);
		add(label, "1,1 , 3,1");
		
		JButton yesButton = new JButton("Yes");
		yesButton.setActionCommand("$b_yes");
		yesButton.addActionListener(listener);
		add(yesButton, "1,3");
		JButton noButton = new JButton("No");
		noButton.setActionCommand("$b_no");
		noButton.addActionListener(listener);
		add(noButton, "3,3");
	}
}
