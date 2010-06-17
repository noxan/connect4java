package com.googlecode.connect4java.pref;

/**
 * 
 * @author richard.stromer
 * @version 1.1b2(r32)
 * @since 0.2
 */
public class Version {
	private static final Type TYPE = Type.BETA;
	private static final int MAJOR = 1;
	private static final int MINOR = 1;
	private static final int PATCH = 2;
	private static final int REVISION = 32;
	
	
	public static String getType() {
		return TYPE.toString();
	}
	public static int getMajor() {
		return MAJOR;
	}
	public static int getMinor() {
		return MINOR;
	}
	public static int getPatch() {
		return PATCH;
	}
	public static int getRevision() {
		return REVISION;
	}
	
	public static String getVersion() {
		return getVersion("%m.%n.%r");
	}
	public static String getVersionPatch() {
		return getVersion("%m.%n%t%p");
	}
	public static String getVersion(String format) {
		format = format.replace("%t", getType());
		format = format.replace("%m", Integer.toString(getMajor()));
		format = format.replace("%n", Integer.toString(getMinor()));
		if(TYPE!=Type.STABLE) {
			format = format.replace("%p", Integer.toString(getPatch()));
		} else {
			format = format.replace("%p", "");
		}
		format = format.replace("%r", Integer.toString(getRevision()));
		return format;
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName());
		sb.append("[");
		sb.append(MAJOR);
		sb.append(".");
		sb.append(MINOR);
		sb.append(".");
		sb.append(REVISION);
		sb.append(TYPE);
		if(TYPE!=Type.STABLE) {
			sb.append(PATCH);
		}
		sb.append("]");
		sb.append("@");
		sb.append(Integer.toHexString(hashCode()));
		return sb.toString();
	}
	private enum Type {
		ALPHA, BETA, STABLE, PATCH;
		
		public String toString() {
			return super.toString().substring(0, 1).toLowerCase();
		}
	}
}

