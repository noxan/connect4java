package com.googlecode.connect4java.gui;

import java.awt.Color;

import com.googlecode.connect4java.Main;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.5.11
 */
public enum GuiCard {
	MENU("MENU", new Color(Main.pref.getInt("gui.cards.menu", new Color(75, 200, 75).getRGB()))), 
	LOCAL("LOCAL", new Color(Main.pref.getInt("gui.cards.local", new Color(75, 150, 150).getRGB()))),
	NETWORK("NETWORK", new Color(Main.pref.getInt("gui.cards.network", new Color(200, 200, 50).getRGB()))),
	SETTINGS("SETTINGS", new Color(Main.pref.getInt("gui.cards.settings", new Color(200, 100, 50).getRGB()))),
	GAME("GAME", new Color(Main.pref.getInt("gui.cards.game", new Color(200, 0, 200).getRGB()))),
	CLOSE("CLOSE", new Color(Main.pref.getInt("gui.cards.close", new Color(0, 0, 0).getRGB())));
	
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