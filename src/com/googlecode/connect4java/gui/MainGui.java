package com.googlecode.connect4java.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import jkit.swing.JStatusBar;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.gui.card.AbstractCard;
import com.googlecode.connect4java.gui.card.CloseCard;
import com.googlecode.connect4java.gui.card.GameCard;
import com.googlecode.connect4java.gui.card.LocalCard;
import com.googlecode.connect4java.gui.card.MenuCard;
import com.googlecode.connect4java.gui.card.NetworkCard;
import com.googlecode.connect4java.gui.card.ProfileCard;
import com.googlecode.connect4java.gui.card.SettingsCard;
import com.googlecode.connect4java.pref.Version;
import com.googlecode.connect4java.swing.JBackgroundPanel;
import com.googlecode.connect4java.util.Lock;

/**
 * @author richard.stromer
 * @version 1.1b2(r31)
 * @since 0.1
 */
public class MainGui {
	public static boolean showStartDialog() {
		return JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, Core.TITLE+" is already running.\nClick OK to start anyway.", Core.TITLE, JOptionPane.OK_CANCEL_OPTION);
	}
	
	public static final int MARGIN = 25;
    public static final int PADDING = 10;
	
	private JFrame frame;
	private JBackgroundPanel cards;
	private CardLayout layout;
	private JStatusBar statusbar;
	
	public MainGui() {
		frame = new JFrame(Core.TITLE);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocation(50, 50);
		frame.setLocationByPlatform(true);
		frame.setMinimumSize(new Dimension(480, 320));
		frame.setLayout(new BorderLayout());
		frame.addWindowListener(new MainGuiWindowListener());
		
		layout = new CardLayout();
		cards = new JBackgroundPanel();
		cards.setLayout(layout);
		cards.setLimit(Core.pref.getInt("gui.limit", 50));
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
		statusbar.setVersion(Version.getVersionPatch());
		frame.add(statusbar, BorderLayout.SOUTH);
		//cards
		cards.add(new MenuCard(this), GuiCard.MENU.toString());
		cards.add(new GameCard(this), GuiCard.GAME.toString());
		cards.add(new LocalCard(this), GuiCard.LOCAL.toString());
		cards.add(new NetworkCard(this), GuiCard.NETWORK.toString());
		cards.add(new ProfileCard(this), GuiCard.PROFILE.toString());
		cards.add(new SettingsCard(this), GuiCard.SETTINGS.toString());
		cards.add(new CloseCard(this), GuiCard.CLOSE.toString());
	}
	public void showCard(GuiCard card) {
		layout.show(cards, card.toString());
		cards.nextColor(card.getColor(), Core.pref.getInt("gui.time", 20));
	}
	public void setStatus(String text, boolean load) {
		statusbar.setText(text);
		statusbar.setLoad(load);
	}
	public JFrame getFrame() {
		return frame;
	}
	public void update() {
		for(Component c:cards.getComponents()) {
			if(c instanceof AbstractCard) {
				((AbstractCard)c).update();
			}
		}
	}
	public void exit() {
		frame.dispose();
		Lock.unlock();
	}
	
	/**
	 * Calls <tt>exit()</tt> if the frame is closing.
	 * @author richard
	 * @version 1.1b2
	 * @since 1.1b2
	 */
	private class MainGuiWindowListener extends WindowAdapter {
		@Override public void windowClosing(WindowEvent e) {
			exit();
		}
	}
}
