package com.googlecode.connect4java.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import jkit.swing.JStatusBar;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.gui.card.CloseCard;
import com.googlecode.connect4java.gui.card.GameCard;
import com.googlecode.connect4java.gui.card.LocalCard;
import com.googlecode.connect4java.gui.card.MenuCard;
import com.googlecode.connect4java.gui.card.NetworkCard;
import com.googlecode.connect4java.gui.card.SettingsCard;
import com.googlecode.connect4java.pref.Version;
import com.googlecode.connect4java.swing.JBackgroundPanel;

/**
 * @author richard.stromer
 * @version 0.1.29b1
 * @since 0.1
 */
public class MainGui {
	public static final int MARGIN = 25;
    public static final int PADDING = 10;
	
	private JFrame frame;
	private JBackgroundPanel cards;
	private CardLayout layout;
	private JStatusBar statusbar;
	
	public MainGui() {
		frame = new JFrame(Main.C4J_TITLE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(50, 50);
		frame.setLocationByPlatform(true);
		frame.setMinimumSize(new Dimension(480, 320));
		frame.setLayout(new BorderLayout());
		
		layout = new CardLayout();
		cards = new JBackgroundPanel();
		cards.setLayout(layout);
		cards.setLimit(Main.pref.getInt("gui.limit", 50));
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
		statusbar.setVisibleIcon(false);
		statusbar.setComponentsBorder(new EmptyBorder(2, 2, 1, 2));
		statusbar.setVersion(Version.getVersion());
		frame.add(statusbar, BorderLayout.SOUTH);
		//cards
		cards.add(new MenuCard(this), GuiCard.MENU.getString());
		cards.add(new SettingsCard(this), GuiCard.SETTINGS.getString());
		cards.add(new LocalCard(this), GuiCard.LOCAL.getString());
		cards.add(new NetworkCard(this), GuiCard.NETWORK.getString());
		cards.add(new GameCard(this), GuiCard.GAME.getString());
		cards.add(new CloseCard(this), GuiCard.CLOSE.getString());
	}
	
	public void update() {
		cards.validate();
		cards.repaint();
	}

	public void showCard(GuiCard card) {
		layout.show(cards, card.toString());
		cards.nextColor(card.getColor(), Main.pref.getInt("gui.time", 20));
	}
	public JStatusBar getStatusBar() {
		return statusbar;
	}
	public void setStatus(String text, boolean load) {
		statusbar.setText(text);
		statusbar.setLoad(load);
	}
	public JFrame getFrame() {
		return frame;
	}
	public void exit() {
		frame.dispose();
	}
}
