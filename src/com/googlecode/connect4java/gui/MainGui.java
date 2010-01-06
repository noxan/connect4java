package com.googlecode.connect4java.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.gui.card.GuiCard;
import com.googlecode.connect4java.gui.card.LocalCard;
import com.googlecode.connect4java.gui.card.MenuCard;
import com.googlecode.connect4java.gui.card.NetworkCard;
import com.googlecode.connect4java.gui.card.SettingsCard;
import com.googlecode.connect4java.swing.JBackgroundPanel;
import com.googlecode.connect4java.swing.JStatusBar;

/**
 * 
 * @author noxan
 * @version 0.5.11
 * @since 0.1
 */
public class MainGui {
	public static final int MARGIN = 25;
    public static final int PADDING = 10;
	
	public JFrame frame;
	private JBackgroundPanel cards;
	private CardLayout layout;
	public JStatusBar statusbar;
	
	public MainGui() {
		frame = new JFrame(Main.C4J_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50, 50);
		frame.setLocationByPlatform(true);
		frame.setMinimumSize(new Dimension(480, 320));
		frame.setLayout(new BorderLayout());
		
		layout = new CardLayout();
		cards = new JBackgroundPanel();
		cards.setLayout(layout);
		cards.setPreferredSize(new Dimension(640, 480));
		frame.add(cards, BorderLayout.CENTER);
		
		showCard(GuiCard.MENU);
		initComponents();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	
	private void initComponents() {
		//statusbar
		statusbar = new JStatusBar();
		frame.add(statusbar, BorderLayout.SOUTH);
		//cards
		JPanel menuCard = new MenuCard(this);
		cards.add(menuCard, GuiCard.MENU.getString());
		JPanel settingsCard = new SettingsCard(this);
		cards.add(settingsCard, GuiCard.SETTINGS.getString());
		JPanel localCard = new LocalCard(this);
		cards.add(localCard, GuiCard.LOCAL.getString());
		JPanel networkCard = new NetworkCard(this);
		cards.add(networkCard, GuiCard.NETWORK.getString());
	}


	public void showCard(GuiCard card) {
		layout.show(cards, card.getString());
		cards.nextColor(card.getColor());
	}
}
