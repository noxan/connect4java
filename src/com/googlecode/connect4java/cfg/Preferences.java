package com.googlecode.connect4java.cfg;

import noxan.xml.lib.XML;
import noxan.xml.lib.XMLEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * Class to organize preferences (with xml-import and export).
 * @author noxan
 * @since 0.0.1
 * @version 0.0.1
 */
public class Preferences {
	/**
	 * Stores all preferences.
	 */
	private HashMap<String, String> map;
	
	/**
	 * Creates a new instance.
	 */
	public Preferences() {
		map = new HashMap<String, String>();
	}
	/**
	 * Imports all preferences from the given location.
	 * @param path
	 * @throws IOException
	 * @since 0.0.1
	 */
	public void load(String path) throws IOException {
		XML xml = new XML();
		
		XMLEntity xmlroot = xml.read(path);
		for(XMLEntity child:xmlroot.getChildren()) {
			map.put(child.getName(), child.getValue());
		}
	}
	/**
	 * Exports all preferences to the given location.
	 * @param path
	 * @throws IOException
	 * @since 0.0.1
	 */
	public void export(String path) throws IOException {
		XML xml = new XML();
		XMLEntity xmlroot = new XMLEntity("settings");
		
		Set<String> keySet = map.keySet();
		for(String key:keySet) {
			xmlroot.addChild(key, map.get(key));
		}
		
		xml.write(xmlroot, path);
	}
	/**
	 * Returns all available keys. 
	 * @return all keys.
	 * @since 0.0.1
	 */
	public String[] getKeys() {
		String[] res = new String[map.size()];
		
		Set<String> keySet = map.keySet();
		int i=0;
		for(String key:keySet) {
			res[i] = key;
			i++;
		}
		
		return res;
	}
	/**
	 * Adds the given value to the given key.
	 * @param key
	 * @param value
	 * @since 0.0.1
	 */
	public void put(String key, String value) {
		map.put(key, value);
	}
	/**
	 * Returns the value saved as the given key. 
	 * @param key
	 * @return
	 * @since 0.0.1
	 */
	public String get(String key) {
		return map.get(key);
	}
	/**
	 * Returns the value saved as the given key or dvalue if the key is empty.
	 * @since 0.0.1
	 * @param key
	 * @param dvalue default value
	 * @return
	 */
	public String get(String key, String dvalue) {
		String res = map.get(key);
		if(res==null) {
			return dvalue;
		}
		return res;
	}
}

