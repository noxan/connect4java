package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.googlecode.connect4java.gui.MainGui;


/**
 * 
 * @author noxan
 * @version 0.5.11
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
	
	private void initComponents() {
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gui.showCard(GuiCard.MENU);
			}
		});
		add(backButton, "1,1");
	}
}
