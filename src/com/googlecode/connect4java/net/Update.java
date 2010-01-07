package com.googlecode.connect4java.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import jkit.xml.XML;
import jkit.xml.XMLEntity;

import com.googlecode.connect4java.pref.Version;

/**
 * 
 * @author noxan
 * @version 0.7.16
 * @since 0.1
 */
public class Update {
	private static String version;
	private static String revision;
	

	/**
	 * @since 0.1.4
	 * @throws IOException
	 */
	public static void update() throws IOException {
		URL url = new URL("http://games4fun.rshost.de/projects/index.php?project=connect4java&action=update");
		InputStream in = url.openStream();
		XMLEntity xml = new XML().read(in);
		
		version = xml.getChild("version").getValue();
		revision = xml.getChild("revision").getValue();
		System.out.println("update: "+getString());
	}
	/**
	 * @since 0.2.5
	 * @return
	 */
	public static int getVersionMainInt() {
		return Integer.valueOf(getVersionMain());
	}
	/**
	 * @since 0.2.5
	 * @return
	 */
	public static int getVersionSubInt() {
		return Integer.valueOf(getVersionSub().replaceAll("[^0-9]", ""));
	}
	/**
	 * @since 0.2.5
	 * @return
	 */
	public static int getRevisionInt() {
		return Integer.valueOf(revision);
	}
	/**
	 * @since 0.2.5
	 * @return
	 */
	public static String getVersionMain() {
		return version.split("[^0-9]")[0];
	}
	/**
	 * @since 0.2.5
	 * @return
	 */
	public static String getVersionSub() {
		String res = "";
		String[] temp = version.split("[^0-9]");
		for(int i=1;i<temp.length;i++) {
			res += temp[i]+(i+1<temp.length?".":"");
		}
		return res;
	}
	/**
	 * @since 0.2.5
	 * @return
	 */
	public static String getVersionString() {
		return version;
	}
	/**
	 * @since 0.2.5
	 * @return
	 */
	public static String getRevisionString() {
		return revision;
	}
	
	/**
	 * @since 0.2.7
	 * @return
	 */
	public static boolean isVersionUpdate() {
		if(getVersionMainInt()>Version.VERSION_MAIN || getVersionSubInt()>Version.VERSION_SUB) {
			return true;
		}
		return false;
	}
	/**
	 * @since 0.2.7
	 * @return
	 */
	public static boolean isRevisionUpdate() {
		if(getRevisionInt()>Version.VERSION_REVSION) {
			return true;
		}
		return false;
	}
	/**
	 * @since 0.2.5
	 * @return
	 */
	public static boolean isUpdate() {
		if(isRevisionUpdate() || isVersionUpdate()) {
			return true;
		}
		return false;
	}
	/**
	 * @since 0.1
	 * @return
	 */
	public static String getString() {
		return version+"."+revision;
	}
	/**
	 * {@inheritDoc}
	 * @since 0.1
	 */
	@Override
	public String toString() {
		return "Update["+version+"."+revision+"]";
	}
}
