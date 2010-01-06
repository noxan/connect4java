package com.googlecode.connect4java.game;

import java.awt.Color;

/**
 * Contains a local player profil.
 * @author noxan
 * @version 0.4.11
 * @since 0.4.11
 */
public class Player {
	private String name;
	private Color color;
	
	public Player(String name) {
		this.setName(name);
	}
	
	public Player(String name, Color color) {
		this.setName(name);
		this.setColor(color);
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
}
