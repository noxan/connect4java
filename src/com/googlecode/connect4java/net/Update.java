package com.googlecode.connect4java.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import noxan.xml.lib.XML;
import noxan.xml.lib.XMLEntity;

import com.googlecode.connect4java.Main;


public class Update {
	private int version;
	private int revsion;
	
	private XMLEntity xml;
	
	public Update() {
		update();
	}
	
	public void update() {
		try {
			URL url = new URL("http://connect4java.googlecode.com/files/update.xml");
			InputStream in = url.openStream();
			xml = new XML().read(in);
			
			version = Integer.valueOf(xml.getChild("version").getValue().replaceAll("[^0-9]", ""));
			revsion = Integer.valueOf(xml.getChild("revision").getValue());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int getCurrentVersion() {
		return Integer.valueOf(Main.C4J_VERSION.replaceAll("[^0-9]", ""));
	}
	private int getCurrentRevision() {
		return Main.C4J_REVISION;
	}
	
	public boolean isUpdate() {
		return isRevisionUpdate() && isVersionUpdate();
	}
	public boolean isVersionUpdate() {
		if(version>getCurrentVersion()) {
			return true;
		}
		return false;
	}
	public boolean isRevisionUpdate() {
		if(revsion>getCurrentRevision()) {
			return true;
		}
		return false;
	}
	
	public int getVersion() {
		return version;
	}
	public int getRevision() {
		return revsion;
	}
}
