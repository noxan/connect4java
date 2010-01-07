package com.googlecode.connect4java.pref;

/**
 * 
 * @author noxan
 * @version 0.6.12
 * @since 0.2
 */
public class Version {
	public static final int VERSION_MAIN = 0;
	public static final int VERSION_SUB = 6;
	public static final int VERSION_REVSION = 12;
	
	public static String string() {
		return VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION;
	}
	@Override
	public String toString() {
		return "Version["+VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION+"]";
	}
}
