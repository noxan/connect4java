package com.googlecode.connect4java.pref;

/**
 * 
 * @author noxan
 * @since 0.2
 * @version 0.3.8
 */
public class Version {
	public static final int VERSION_MAIN = 0;
	public static final int VERSION_SUB = 3;
	public static final int VERSION_REVSION = 8;
	
	public static String string() {
		return VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION;
	}
	@Override
	public String toString() {
		return "Version["+VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION+"]";
	}
}
