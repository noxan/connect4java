package com.googlecode.connect4java.gui.card;

import java.awt.Color;

/**
 * 
 * @author noxan
 * @version 0.5.11
 * @since 0.5.11
 */
public enum GuiCard {
	MENU("MENU", new Color(50, 200, 50)), 
	SETTINGS("SETTINGS", new Color(200, 50, 50)), 
	LOCAL("LOCAL", new Color(50, 50, 200)), 
	NETWORK("NETWORK", new Color(200, 200, 50));
	
	private String card;
	private Color color;
	
	private GuiCard(String card, Color color) {
		this.card = card;
		this.color = color;
	}
	
	public String getString() {
		return card;
	}
	public Color getColor() {
		return color;
	}
}
