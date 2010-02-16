package com.googlecode.connect4java.field;

import java.util.EventObject;

/**
 * 
 * @author richard.stromer
 * @version 1.0.27
 * @since 1.0.23
 */
public class FieldEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	private boolean win;
	
	public FieldEvent(Field source, boolean win) {
		super(source);
		this.win = win;
	}
	/**
	 * @since 1.0.27
	 * @return
	 */
	public boolean isWin() {
		return win;
	}
}
