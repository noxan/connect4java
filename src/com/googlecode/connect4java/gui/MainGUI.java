package com.googlecode.connect4java.gui;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.img.ImageLoader;

public class MainGUI {
	public static final int MARGIN = 25;
	public static final int PADDING = 10;
	
	public static final String CARD_MENU = "MENU";
	public static final String CARD_SETTINGS = "SETTINGS";
	public static final String CARD_SINGLE = "SINGLE";
	public static final String CARD_MULTI = "MULTI";
	public static final String CARD_GAME = "GAME";
	
	private JFrame frame;
	private JPanel cards;
	private CardLayout layout;
	
	private JPanel statusPanel;
	private JLabel statusLabel;
	private JLabel statusVersionLabel;
	private JLabel statusIconLabel;
	
	public MainGUI() {
		frame = new JFrame(Main.C4J_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50, 50);
		frame.setLocationByPlatform(true);
		frame.setMinimumSize(new Dimension(2*MARGIN+200, 275));
		frame.setLayout(new BorderLayout());
		
		layout = new CardLayout();
		cards = new JPanel(layout);
		cards.setPreferredSize(new Dimension(640, 480));
		frame.add(cards, BorderLayout.CENTER);
		
		initStatusPanel();
		initComponents();
		showCard(CARD_MENU);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void showCard(String name) {
		layout.show(cards, name);
	}
	private void initStatusPanel() {
		double[][] size = {{2, TableLayout.FILL, 2, TableLayout.PREFERRED, 10, TableLayout.PREFERRED, 2}, 
				{TableLayout.PREFERRED, 2, TableLayout.PREFERRED}};
		
		statusPanel = new JPanel(new TableLayout(size));
		
		statusPanel.add(new JSeparator(), "0,0 , 6,0");
		statusLabel = new JLabel();
		statusPanel.add(statusLabel, "1,2");
		
		statusVersionLabel = new JLabel("v"+Main.C4J_VERSION+".rev"+Main.C4J_REVISION);
		statusVersionLabel.setEnabled(false);
		statusPanel.add(statusVersionLabel, "3,2");
		
		statusIconLabel = new JLabel();
		statusPanel.add(statusIconLabel, "5,2");
		
		setStatus("Ready", false);
		frame.add(statusPanel, BorderLayout.SOUTH);
	}
	private void initComponents() {
		JPanel menuPanel = new MenuPanel(this);
		cards.add(menuPanel, CARD_MENU);
		
		JPanel settingsPanel = new SettingsPanel(this);
		cards.add(settingsPanel, CARD_SETTINGS);
		
		JPanel singlePanel = new SinglePanel(this);
		cards.add(singlePanel, CARD_SINGLE);
		
		JPanel multiPanel = new MultiPanel(this);
		cards.add(multiPanel, CARD_MULTI);
		
		JPanel gamePanel = new GamePanel();
		cards.add(gamePanel, CARD_GAME);
	}
	public void setLoading(boolean b) {
		if(b) {
			statusIconLabel.setIcon(ImageLoader.load("loading.gif"));
		} else {
			statusIconLabel.setIcon(ImageLoader.load("loaded.gif"));
		}
	}
	public void setStatus(String msg) {
		statusLabel.setText(msg);
	}
	public void setStatus(String msg, boolean loading) {
		setStatus(msg);
		setLoading(loading);
	}
}
