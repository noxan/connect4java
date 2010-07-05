package com.googlecode.connect4java.player;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.player.computer.EasyComputer;
import com.googlecode.connect4java.player.computer.RandomComputer;
import com.googlecode.connect4java.player.human.DefaultPlayer;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 1.1
 */
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
	public static List<Player> getPlayers(PlayerType type) {
		List<Player> list = new LinkedList<Player>();
		for(String key:getInstance().players.keySet()) {
			Player p = getInstance().players.get(key);
			if(p.getType().equals(type)) {
				list.add(p);
			}
		}
		return list;
	}
	private void doImport() {
		add("default", new DefaultPlayer(Core.pref.get("player.name", "Player"), new Color(Core.pref.getInt("player.color", 255))));
		add("computer(random)", new RandomComputer(new Color(Core.pref.getInt("computer.color", -65536))));
		add("computer(easy)", new EasyComputer(new Color(Core.pref.getInt("computer.color", -65536))));
	}
	
	@Override
	public void valueChanged(Player source) {
		
	}
}
