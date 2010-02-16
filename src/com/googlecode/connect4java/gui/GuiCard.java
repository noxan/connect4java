package com.googlecode.connect4java.gui;

import java.awt.Color;

import com.googlecode.connect4java.Main;

/**
 * @author   richard.stromer
 * @version   0.8.17
 * @since   0.5.11
 */
public enum GuiCard {
	/**
	 * @uml.property  name="mENU"
	 * @uml.associationEnd  
	 */
	MENU("MENU", new Color(Main.pref.getInt("gui.cards.menu", new Color(75, 200, 75).getRGB()))), 
	/**
	 * @uml.property  name="lOCAL"
	 * @uml.associationEnd  
	 */
	LOCAL("LOCAL", new Color(Main.pref.getInt("gui.cards.local", new Color(75, 150, 150).getRGB()))),
	/**
	 * @uml.property  name="nETWORK"
	 * @uml.associationEnd  
	 */
	NETWORK("NETWORK", new Color(Main.pref.getInt("gui.cards.network", new Color(200, 200, 50).getRGB()))),
	/**
	 * @uml.property  name="sETTINGS"
	 * @uml.associationEnd  
	 */
	SETTINGS("SETTINGS", new Color(Main.pref.getInt("gui.cards.settings", new Color(200, 100, 50).getRGB()))),
	/**
	 * @uml.property  name="gAME"
	 * @uml.associationEnd  
	 */
	GAME("GAME", new Color(Main.pref.getInt("gui.cards.game", new Color(200, 0, 200).getRGB()))),
	/**
	 * @uml.property  name="cLOSE"
	 * @uml.associationEnd  
	 */
	CLOSE("CLOSE", new Color(Main.pref.getInt("gui.cards.close", new Color(0, 0, 0).getRGB())));
	
	private String card;
	/**
	 * @uml.property  name="color"
	 */
	private Color color;
	
	private GuiCard(String card, Color color) {
		this.card = card;
		this.color = color;
	}
	
	public String getString() {
		return card;
	}
	/**
	 * @return
	 * @uml.property  name="color"
	 */
	public Color getColor() {
		return color;
	}
}
