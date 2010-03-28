package com.googlecode.connect4java.util;

import com.googlecode.connect4java.core.Core;

/**
 * 
 * @author richard
 * @version 1.1b2(r31)
 * @since 1.1b2
 */
public class Lock {
	private Lock() {
	}
	
	public static boolean isLock() {
		return Core.pref.getBoolean("lock", false);
	}
	public static boolean lock() {
		boolean old = Core.pref.getBoolean("lock", false);
		Core.pref.putBoolean("lock", true);
		return old;
	}
	public static boolean unlock() {
		boolean old = Core.pref.getBoolean("lock", false);
		Core.pref.putBoolean("lock", false);
		return old;
	}
}
