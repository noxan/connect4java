package com.googlecode.connect4java.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import info.clearthought.layout.TableLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.googlecode.connect4java.Main;

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private final Color color = new Color(50, 200, 50);
	private final Font font = new Font("Verdana", Font.PLAIN, 32);
	
	private MainGUI gui;
	
	private JButton singleButton;
	private JButton multiButton;
	private JButton settingsButton;
	private JButton exitButton;
	
	public MenuPanel(MainGUI gui) {
		this.gui = gui;
		double[][] size = {{MainGUI.MARGIN, 200, TableLayout.FILL}, 
				{TableLayout.FILL, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.PADDING, TableLayout.PREFERRED, MainGUI.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	private void initComponents() {
		singleButton = new JButton("Singleplayer");
		singleButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gui.showCard(MainGUI.CARD_SINGLE);
			}
		});
		add(singleButton, "1,1");
		
		multiButton = new JButton("Multiplayer");
		multiButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gui.showCard(MainGUI.CARD_MULTI);
			}
		});
		add(multiButton, "1,3");
		
		settingsButton = new JButton("Settings");
		settingsButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gui.showCard(MainGUI.CARD_SETTINGS);
			}
		});
		add(settingsButton, "1,5");
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(exitButton, "1,7");
	}
	
	@Override
	protected void paintComponent(Graphics g) { // Test with GradientPaint
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getSize().width;
		int height = getSize().height;
		
		GradientPaint gp = new GradientPaint(0f, 0f, Color.BLACK, 0f, (float)height, color);
		g2.setPaint(gp);
		g2.fillRect(0, 0, width, height);
		
		g2.setFont(font);
		g2.setColor(color);
		g2.drawString(Main.C4J_TITLE, width-228, 40);
	}
}
