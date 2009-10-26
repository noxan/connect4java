package com.googlecode.connect4java;

import javax.swing.UIManager;

import com.googlecode.connect4java.gui.MainGUI;
import com.googlecode.connect4java.pref.Version;

/**
 * 
 * @author noxan
 * @version 0.2
 * @since 0.1
 */
public class Main {
	/**
	 * Connect4Java title string
	 */
	public static final String C4J_TITLE = "connect4java";
	
	/**
	 * Main methode
	 * @since 0.0.1
	 * @param args
	 */
	public static void main(String[] args) {
		try { //look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		System.out.println(C4J_TITLE+"("+Version.string()+") loading..");
		new MainGUI();
	}
}
