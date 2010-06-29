package com.googlecode.connect4java;

import jkit.gui.KitConsole;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.util.Lock;

/**
 * The main class.
 * 
 * @author richard.stromer
 * @version 1.1b4(r34)
 * @since 0.1
 */
public class Main {
	/**
	 * Main method.
	 * @since 0.1
	 * @param args
	 */
	public static void main(String[] args) {
		KitConsole.setSystem(true); //enable system output
		if(!Lock.isLock() || MainGui.showStartDialog()) { //check lock or show dialog
			new Core();
		} else {
			KitConsole.out.println("game already running, close.");
		}
	}
}
