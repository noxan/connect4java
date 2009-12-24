package com.googlecode.connect4java.pref;

/**
 * 
 * @author noxan
 * @version 0.4.10
 * @since 0.2
 */
public class Version {
	public static final int VERSION_MAIN = 0;
	public static final int VERSION_SUB = 4;
	public static final int VERSION_REVSION = 10;
	
	public static String string() {
		return VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION;
	}
	@Override
	public String toString() {
		return "Version["+VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION+"]";
	}
}
