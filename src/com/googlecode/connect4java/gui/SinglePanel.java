package com.googlecode.connect4java.gui;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.googlecode.connect4java.Main;

public class SinglePanel extends JPanel {
private static final long serialVersionUID = 1L;
	
	private final Color color = new Color(50, 50, 200);
	private final Font font = new Font("Verdana", Font.PLAIN, 32);
	
	private MainGUI gui;
	
	private JButton backButton;
	
	public SinglePanel(MainGUI gui) {
		this.gui = gui;
		double[][] size = {{TableLayout.FILL, 100, MainGUI.MARGIN}, 
				{TableLayout.FILL, TableLayout.PREFERRED, MainGUI.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	private void initComponents() {
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gui.showCard(MainGUI.CARD_MENU);
			}
		});
		add(backButton, "1,1");
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
