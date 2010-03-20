package com.googlecode.connect4java.game;

import java.awt.Color;

/**
 * Contains a local player profil.
 * @author richard.stromer
 * @version 0.1.29b1
 * @since 0.4.11
 */
public class Player {
	private String name;
	private Color color;
	/**
	 * Creates a new player with the given name.
	 * @since 0.4.11
	 * @param name the players name
	 */
	public Player(String name) {
		this.setName(name);
	}
	/**
	 * Creates a new player with the given name and color.
	 * @since 0.4.11
	 * @param name the players name
	 * @param color the players color
	 */
	public Player(String name, Color color) {
		this.setName(name);
		this.setColor(color);
	}
	/**
	 * @since 0.4.11
	 * @param name  sets the players name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @since 0.4.11
	 * @return returns the players name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @since 0.4.11
	 * @param color  sets the players color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * @since 0.4.11
	 * @return returns the players color
	 */
	public Color getColor() {
		return color;
	}
}
