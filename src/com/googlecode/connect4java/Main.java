package com.googlecode.connect4java;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;

import jkit.pref.Preferences;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.pref.Version;

/**
 * The main class.
 * @author richard.stromer
 * @version 1.0.28
 * @since 0.1
 */
public class Main {
	/**
	 * Connect4Java title string.
	 */
	public static final String C4J_TITLE = "connect4java";
	/**
	 * Preferences instance.
	 */
	public static Preferences pref = new Preferences();
	/**
	 * Main method.
	 * @since 0.0.1
	 * @param args
	 */
	public static void main(String[] args) {
		try { //look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		System.out.println(C4J_TITLE+"("+Version.string()+") loading...");
		File file = new File(System.getProperty("user.home")+"/.connect4java/settings.xml");
		System.out.println(file);
		if(!file.getParentFile().isDirectory()) { //settings directory
			if(file.getParentFile().mkdir()) {
				System.out.println("settings directory created");
			} else {
				System.err.println("could not create settings directory");
			}
		} else {
			try { //settings file (import)
				pref.importXML(System.getProperty("user.home")+"/.connect4java/settings.xml");
			} catch (IOException e) {
				System.err.println("could not import settings");
			}
		}
		MainGui gui = new MainGui();
		gui.getFrame().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				try { //settings file (export)
					pref.exportXML(System.getProperty("user.home")+"/.connect4java/settings.xml");
				} catch (IOException ex) {
					System.err.println("could not export settings");
				}
			}
		});
	}
}
