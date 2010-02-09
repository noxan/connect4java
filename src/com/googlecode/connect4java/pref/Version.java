package com.googlecode.connect4java.pref;


/**
 * 
 * @author richard.stromer
 * @version 1.0.25
 * @since 0.2
 */
public class Version {
    public static final int VERSION_MAIN = 1;
    public static final int VERSION_SUB = 0;
    public static final int VERSION_REVSION = 25;

    public static String string() {
    	return VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION;
    }

    @Override
    public String toString() {
    	return "Version["+VERSION_MAIN+"."+VERSION_SUB+"."+VERSION_REVSION+"]";
    }
}
