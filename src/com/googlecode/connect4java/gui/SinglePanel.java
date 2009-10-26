package com.googlecode.connect4java.gui;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author noxan
 * @since 0.1
 * @version 0.2
 */
public class SinglePanel extends AbstractPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton backButton;
	
	public SinglePanel(MainGUI gui) {
		super(gui, new Color(50, 50, 200));
		double[][] size = {{TableLayout.FILL, 100, MainGUI.MARGIN}, 
				{TableLayout.FILL, TableLayout.PREFERRED, MainGUI.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	private void initComponents() {
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				getMainGUI().showCard(MainGUI.CARD_MENU);
			}
		});
		add(backButton, "1,1");
	}
}
