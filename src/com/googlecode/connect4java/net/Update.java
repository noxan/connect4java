package com.googlecode.connect4java.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.googlecode.connect4java.pref.Version;

import noxan.xml.lib.XML;
import noxan.xml.lib.XMLEntity;

/**
 * 
 * @author noxan
 * @since 0.1
 * @version 0.2
 */
public class Update {
	private String version;
	private String revision;
	private String date;
	
	public Update() {
		update();
	}
	
	public void update() {
		try {
			URL url = new URL("http://games4fun.rshost.de/projects/index.php?project=connect4java&action=update");
			InputStream in = url.openStream();
			XMLEntity xml = new XML().read(in);
			
			version = xml.getChild("version").getValue();
			revision = xml.getChild("revision").getValue();
			date = xml.getChild("date").getValue();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getVersionMainInt() {
		return Integer.valueOf(getVersionMain());
	}
	public int getVersionSubInt() {
		return Integer.valueOf(getVersionSub().replaceAll("[^0-9]", ""));
	}
	public int getRevisionInt() {
		return Integer.valueOf(revision);
	}
	
	public String getVersionMain() {
		return version.split(".")[0];
	}
	public String getVersionSub() {
		String res = "";
		String[] temp = version.split(".");
		for(int i=1;i<temp.length;i++) {
			res += temp[i]+(i+1<temp.length?".":"");
		}
		return res;
	}
	public String getVersionString() {
		return version;
	}
	public String getRevisionString() {
		return revision;
	}
	public String getDateString() {
		return date;
	}
	
	public boolean isUpdate() {
		if(getRevisionInt()>Version.VERSION_REVSION) {
			return true;
		}
		return false;
	}
	
	public String getString() {
		return version+"."+revision;
	}
	
	public String toString() {
		return "Update["+version+"."+revision+"-"+date+"]";
	}
}
