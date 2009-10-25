package com.googlecode.connect4java.img;

import java.util.HashMap;

import javax.swing.ImageIcon;

/**
 * Class to load images.
 * @author noxan
 * @since 0.0.1
 * @version 0.0.1
 */
public class ImageLoader {
	/**
	 * Caches the images.
	 */
	private static HashMap<String, ImageIcon> map = new HashMap<String, ImageIcon>();
	
	/**
	 * Loads a defined image.
	 * @param img image-path
	 * @return the image or null
	 */
	public static ImageIcon load(String img) {
		if(ImageLoader.map.get(img)==null) {
			map.put(img, new ImageIcon(ClassLoader.getSystemResource("com/googlecode/connect4java/img/"+img)));
		}
		return map.get(img);
	}
}