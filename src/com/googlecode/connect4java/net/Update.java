package com.googlecode.connect4java.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import jkit.gui.KitConsole;
import jkit.xml.XML;
import jkit.xml.XMLEntity;

import com.googlecode.connect4java.pref.Version;

/**
 * Update-Service
 * @author richard.stromer
 * @version 1.1b3(r32)
 * @since 0.1
 */
public class Update {
	public static final String UPDATE_LINK = "http://connect4java.isgreat.org/update.php";
	public static final String UPDATE_HASH = "WAm96myeYxnr9JEY";
	private static int major;
	private static int minor;
	private static int patch;
	private static String type;
	private static int revision;
	private static String date;
	
	private Update() {
	}
	
	/**
	 * @since 0.1.4
	 * @throws IOException
	 */
	public static void update() throws IOException {
		URL url = new URL(UPDATE_LINK+"?hash="+UPDATE_HASH);
		URLConnection con = url.openConnection();
		con.setReadTimeout(2500);
		InputStream in = con.getInputStream();
		XMLEntity xml = new XML().read(in);
		
		String versionString = xml.getChild("version").getValue();
		String[] versionStrings = versionString.split("\\.");
		major = Integer.valueOf(versionStrings[0]);
		minor = Integer.valueOf(versionStrings[1]);
		patch = Integer.valueOf(versionStrings[2]);
		type = xml.getChild("type").getValue();
		revision = Integer.valueOf(xml.getChild("revision").getValue());
		date = xml.getChild("date").getValue();
		KitConsole.out.println("update: "+getVersion());
	}
	/**
	 * @since 1.1b3(r32)
	 * @return
	 */
	public static String getType() {
		return type;
	}
	/**
	 * @since 1.1b3(r32)
	 * @return
	 */
	public static int getMajor() {
		return major;
	}
	/**
	 * @since 1.1b3(r32)
	 * @return
	 */
	public static int getMinor() {
		return minor;
	}
	/**
	 * @since 1.1b3(r32)
	 * @return
	 */
	public static int getPatch() {
		return patch;
	}
	/**
	 * @since 1.1b3(r32)
	 * @return
	 */
	public static int getRevision() {
		return revision;
	}
	/**
	 * @since 1.1b3(r32)
	 * @return
	 */
	public static String getDate() {
		return date;
	}
	/**
	 * @since 0.2.7
	 * @return
	 */
	public static boolean isVersionUpdate() {
		return (getMajor()>Version.getMajor() || getMinor()>Version.getMinor() || getPatch()>Version.getPatch());
	}
	/**
	 * @since 0.2.7
	 * @return
	 */
	public static boolean isRevisionUpdate() {
		return (getRevision()>Version.getRevision());
	}
	/**
	 * @since 0.2.5
	 * @return
	 */
	public static boolean isUpdate() {
		return (isRevisionUpdate() || isVersionUpdate());
	}
	/**
	 * @since 1.1b3(r32)
	 * @return
	 */
	public static String getVersion() {
		return getVersion("%m.%n.%r");
	}
	/**
	 * @since 1.1b3(r32)
	 * @return
	 */
	public static String getVersionPatch() {
		return getVersion("%m.%n%t%p");
	}
	/**
	 * @since 1.1b3(r32)
	 * @return
	 */
	private static String formatType() {
		return getType().substring(0, 1).toLowerCase();
	}
	/**
	 * @since 1.1b3(r32)
	 * @param format
	 * @return
	 */
	public static String getVersion(String format) {
		format = format.replace("%t", formatType());
		format = format.replace("%m", Integer.toString(getMajor()));
		format = format.replace("%n", Integer.toString(getMinor()));
		format = format.replace("%p", Integer.toString(getPatch()));
		format = format.replace("%r", Integer.toString(getRevision()));
		format = format.replace("%d", getDate());
		return format;
	}
}
