package com.googlecode.connect4java.gui;

import java.awt.Color;

/**
 * 
 * @author noxan
 * @version 0.7.16
 * @since 0.5.11
 */
public enum GuiCard {
	MENU("MENU", new Color(75, 200, 75)), 
	LOCAL("LOCAL", new Color(75, 150, 150)), 
	NETWORK("NETWORK", new Color(200, 200, 50)),
	SETTINGS("SETTINGS", new Color(200, 100, 50)),
	GAME("GAME", Color.MAGENTA),
	CLOSE("CLOSE", new Color(0, 0, 0));
	
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
