package com.googlecode.connect4java;

import java.util.prefs.Preferences;

import javax.swing.UIManager;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.pref.Version;

/**
 * The main class.
 * 
 * @author richard.stromer
 * @version 0.1.29b1
 * @since 0.1
 */
public class Main {
	/**
	 * Connect4Java title string.
	 */
	public static final String C4J_TITLE = "connect4java";
	public static final boolean DEBUG = true;
	/**
	 * Preferences instance.
	 */
	public static Preferences pref = Preferences.userRoot().node("com/googlecode/connect4java");
	
	/**
	 * Main method.
	 * 
	 * @since 0.0.1
	 * @param args
	 */
	public static void main(String[] args) {
		try { // look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
		}
		
		System.out.println(C4J_TITLE + "(" + Version.getVersion() + ")");
		new MainGui();
	}
}
