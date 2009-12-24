package com.googlecode.connect4java.pref;

import noxan.xml.lib.XML;
import noxan.xml.lib.XMLEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class to organize preferences (with xml-import and export).
 * @author noxan
 * @version 0.4.10
 * @since 0.1
 */
public class Preferences {
	private Map<String, String> map;
	
	public Preferences() {
		map = new HashMap<String, String>();
	}
	
	
	public String put(String key, String value) {
		return map.put(key, value);
	}
	public String get(String key) {
		return map.get(key);
	}
	public String get(String key, String defaultValue) {
		String res = map.get(key);
		return res!=null?res:defaultValue;
	}
	
	
	public Set<String> keySet() {
		return map.keySet();
	}
	public String[] getKeys() {
		return (String[]) keySet().toArray();
	}
	public int size() {
		return map.size();
	}
	
	
	public void doImport(String path) throws IOException {
		XML xml = new XML();
		
		XMLEntity xmlroot = xml.read(path);
		for(XMLEntity child:xmlroot.getChildren()) {
			map.put(child.getName(), child.getValue());
		}
	}
	public void doExport(String path) throws IOException {
		XML xml = new XML();
		XMLEntity xmlroot = new XMLEntity("settings");
		
		Set<String> keySet = map.keySet();
		for(String key:keySet) {
			xmlroot.addChild(key, map.get(key));
		}
		
		xml.write(xmlroot, path);
	}
}

