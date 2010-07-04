package com.googlecode.connect4java.player;

import java.awt.Color;

public interface Player {
	public void setName(String name);
	public String getName();
	public void setColor(Color color);
	public Color getColor();
	public void setType(PlayerType type);
	public PlayerType getType();
	
	public boolean isHuman();
	public boolean isComputer();
	
	public boolean addPlayerListener(PlayerListener l);
	public boolean removePlayerListener(PlayerListener l);
}
