package com.googlecode.connect4java;

import java.io.File;

import javax.swing.UIManager;

import com.googlecode.connect4java.gui.MainGUI;
import com.googlecode.connect4java.pref.Preferences;
import com.googlecode.connect4java.pref.Version;

/**
 * 
 * @author noxan
 * @version 0.4.10
 * @since 0.1
 */
public class Main {
	/**
	 * Connect4Java title string
	 */
	public static final String C4J_TITLE = "connect4java";
	
	
	public static Preferences pref = new Preferences();
	/**
	 * Main methode
	 * @since 0.0.1
	 * @param args
	 */
	public static void main(String[] args) {
		try { //look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		System.out.println(C4J_TITLE+"("+Version.string()+") loading...");
		System.out.println(new File(System.getProperty("user.home")+"/.connect4java/settings.xml"));
//		try {
//			pref.doImport(System.getProperty("user.home")+"/.connect4java/settings.xml");
//		} catch (IOException e) {
//			System.err.println("could not import settings");
//		}
		new MainGUI();
//		try {
//			pref.doExport(System.getProperty("user.home")+"/.connect4java/settings.xml");
//		} catch (IOException e) {
//			System.err.println("could not export settings");
//		}
	}
}
