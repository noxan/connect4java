package com.googlecode.connect4java.core;

import java.util.prefs.Preferences;

import javax.swing.UIManager;

import jkit.gui.KitConsole;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.pref.Version;
import com.googlecode.connect4java.util.Lock;

/**
 * 
 * @author richard.stromer
 * @version 1.1b4(r34)
 * @since 1.1b2(r31)
 */
public class Core {
	/**
	 * Connect4Java title string.
	 */
	public static final String TITLE = "connect4java";
	/**
	 * Debug mode.
	 */
	public static final boolean DEBUG = false;
	/**
	 * Preferences instance.
	 */
	public static final Preferences pref = Preferences.userRoot().node("com/googlecode/connect4java");
	
	
	public Core() {
		KitConsole.out.println(TITLE+"("+Version.getVersion()+")"); //print welcome message and version
		try { //set laf
			UIManager.setLookAndFeel(pref.get("gui.laf", UIManager.getSystemLookAndFeelClassName()));
		} catch(Exception e) {
			e.printStackTrace(KitConsole.err);
		}
		new MainGui();
		Lock.lock();
	}
}
