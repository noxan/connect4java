package com.googlecode.connect4java.player;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractPlayer implements Player {
	private List<PlayerListener> listeners;
	private String name;
	private Color color;
	private PlayerType type;
	
	public AbstractPlayer(String name, Color color, PlayerType type) {
		listeners = new LinkedList<PlayerListener>();
		setName(name);
		setColor(color);
		setType(type);
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public Color getColor() {
		return color;
	}
	@Override
	public void setType(PlayerType type) {
		this.type = type;
	}
	@Override
	public PlayerType getType() {
		return type;
	}
	@Override
	public boolean isComputer() {
		return PlayerType.COMPUTER.equals(getType());
	}
	@Override
	public boolean isHuman() {
		return PlayerType.HUMAN.equals(getType());
	}
	
	@Override
	public boolean addPlayerListener(PlayerListener l) {
		return listeners.add(l);
	}
	
	@Override
	public boolean removePlayerListener(PlayerListener l) {
		return listeners.remove(l);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Player) {
			Player player = (Player) obj;
			return getName().equals(player.getName())&&getColor().equals(player.getColor())&&getType().equals(player.getType());
		}
		return super.equals(obj);
	}
}
