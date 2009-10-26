package com.googlecode.connect4java.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import com.googlecode.connect4java.Main;

/**
 * 
 * @author noxan
 * @since 0.2
 * @version 0.2
 */
public abstract class AbstractPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Color color = new Color(50, 50, 50);
	private final Font font = new Font("Verdana", Font.PLAIN, 32);
	
	private MainGUI gui;
	
	
	public AbstractPanel(MainGUI gui) {
		setMainGUI(gui);
	}
	public AbstractPanel(MainGUI gui, Color color) {
		setMainGUI(gui);
		setColor(color);
	}
	
	private void setMainGUI(MainGUI gui) {
		this.gui = gui;
	}
	protected MainGUI getMainGUI() {
		return gui;
	}
	
	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
	public Color getColor() {
		return color;
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
