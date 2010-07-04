package com.googlecode.connect4java.player;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.player.computer.RandomComputer;
import com.googlecode.connect4java.player.human.DefaultPlayer;

public class PlayerManager implements PlayerListener {
	private static PlayerManager instance;
	private Map<String, Player> players;
	
	protected static PlayerManager getInstance() {
		if(instance==null) {
			instance = new PlayerManager();
			instance.doImport();
		}
		return instance;
	}
	
	private PlayerManager() {
		players = new HashMap<String, Player>();
	}
	
	public static void add(String profile, Player player) {
		getInstance().players.put(profile, player);
	}
	public static void remove(String name) {
		getInstance().players.remove(name);
	}
	public static void remove(Player player) {
		remove(player.getName());
	}
	public static Player get(String name) {
		return getInstance().players.get(name);
	}
	private void doImport() {
		add("default", new DefaultPlayer(Core.pref.get("player.name", "Player"), new Color(Core.pref.getInt("player.color", 255))));
		add("computer(random)",new RandomComputer(new Color(Core.pref.getInt("computer.color", -65536))));
	}
	
	@Override
	public void valueChanged(Player source) {
		
	}
}
