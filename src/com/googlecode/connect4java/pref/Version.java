package com.googlecode.connect4java.pref;

/**
 * 
 * @author noxan
 * @version 0.5.11
 * @since 0.2
 */
public class Version {
	public static final int VERSION_MAIN = 0;
	public static final int VERSION_SUB = 5;
	public static final int VERSION_REVSION = 11;
	
	public static String string() {
		return VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION;
	}
	@Override
	public String toString() {
		return "Version["+VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION+"]";
	}
}
