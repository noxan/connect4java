package com.googlecode.connect4java.player;

import java.awt.Color;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 1.1
 */
public interface Player {
	public void setName(String name);
	public String getName();
	public void setColor(Color color);
	public Color getColor();
	public void setType(PlayerType type);
	public PlayerType getType();
	
	public boolean isHuman();
	public boolean isComputer();
	
	public String getHashCode();
	
	public boolean addPlayerListener(PlayerListener l);
	public boolean removePlayerListener(PlayerListener l);
}
