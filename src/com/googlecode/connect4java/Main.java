package com.googlecode.connect4java;
import javax.swing.UIManager;

import com.googlecode.connect4java.gui.MainGUI;
import com.googlecode.connect4java.net.Update;

/**
 * 
 * @author noxan
 * @version 0.0.1
 * @since 0.0.1
 */
public class Main {
	/**
	 * Connect4Java title string
	 */
	public static final String C4J_TITLE = "connect4java";
	/**
	 * Connect4Java version string
	 */
	public static final String C4J_VERSION = "0.0.1";
	/**
	 * Connect4Java revision
	 */
	public static final int C4J_REVISION = 3;
	
	/**
	 * Main methode
	 * @since 0.0.1
	 * @param args
	 */
	public static void main(String[] args) {
		try { //look & feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		System.out.println(C4J_TITLE+" (v"+C4J_VERSION+".rev"+C4J_REVISION+") loading..");
		System.out.println("Up to date version: "+!new Update().isUpdate());
		
		new MainGUI();
	}
}
