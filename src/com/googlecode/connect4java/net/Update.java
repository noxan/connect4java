package com.googlecode.connect4java.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.googlecode.connect4java.pref.Version;

import noxan.xml.lib.XML;
import noxan.xml.lib.XMLEntity;

/**
 * 
 * @author noxan
 * @since 0.1
 * @version 0.2.6
 */
public class Update {
	private static String version;
	private static String revision;
	private static String date;
	
	public static void update() throws IOException {
		URL url = new URL("http://games4fun.rshost.de/projects/index.php?project=connect4java&action=update");
		InputStream in = url.openStream();
		XMLEntity xml = new XML().read(in);
		
		version = xml.getChild("version").getValue();
		revision = xml.getChild("revision").getValue();
		date = xml.getChild("date").getValue();
	}
	
	public static int getVersionMainInt() {
		return Integer.valueOf(getVersionMain());
	}
	public static int getVersionSubInt() {
		return Integer.valueOf(getVersionSub().replaceAll("[^0-9]", ""));
	}
	public static int getRevisionInt() {
		return Integer.valueOf(revision);
	}
	
	public static String getVersionMain() {
		return version.split(".")[0];
	}
	public static String getVersionSub() {
		String res = "";
		String[] temp = version.split(".");
		for(int i=1;i<temp.length;i++) {
			res += temp[i]+(i+1<temp.length?".":"");
		}
		return res;
	}
	public static String getVersionString() {
		return version;
	}
	public static String getRevisionString() {
		return revision;
	}
	public static String getDateString() {
		return date;
	}
	
	public static boolean isUpdate() {
		if(getRevisionInt()>Version.VERSION_REVSION) {
			return true;
		}
		return false;
	}
	
	public static String getString() {
		return version+"."+revision;
	}
	
	@Override
	public String toString() {
		return "Update["+version+"."+revision+"-"+date+"]";
	}
}
